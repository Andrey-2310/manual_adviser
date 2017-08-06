package com.ranv.service.serviceDTO;

import com.ranv.model.DB.Rating;
import com.ranv.model.DTO.RatingDTO;
import com.ranv.repository.ManualRepository;
import com.ranv.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceRatingDTO extends ServiceModelDTO<RatingDTO, Rating> {

    private final UserRepository userRepository;
    private final ManualRepository manualRepository;

    @Autowired
    public ServiceRatingDTO(UserRepository userRepository, ManualRepository manualRepository) {
        this.userRepository = userRepository;
        this.manualRepository = manualRepository;
    }

    @Override
    protected RatingDTO convertToItemDTO(Rating rating) {
        RatingDTO ratingDTO = new RatingDTO();
        ratingDTO.setValue(rating.getValue());
        ratingDTO.setManual(rating.getManual().getId());
        ratingDTO.setUser(rating.getUser().getId());
        return ratingDTO;
    }

    @Override
    public Rating convertFromItemDTO(RatingDTO ratingDTO) {
        Rating rating = modelMapper.map(ratingDTO, Rating.class);
        rating.setUser(userRepository.findOne(ratingDTO.getUser()));
        rating.setManual(manualRepository.findOne(ratingDTO.getManual()));
        return rating;
    }
}
