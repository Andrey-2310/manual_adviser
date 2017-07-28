package com.ranv.Service.ServiceDTO;

import com.ranv.Model.DTO.RatingDTO;
import com.ranv.Model.ModelDB.Rating;
import com.ranv.Repository.ManualRepository;
import com.ranv.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceRatingDTO extends ServiceModelDTO<RatingDTO, Rating> {
    @Override
    protected RatingDTO convertToItemDTO(Rating rating) {
        RatingDTO ratingDTO = modelMapper.map(rating, RatingDTO.class);
        ratingDTO.setManual(rating.getManual().getId());
        ratingDTO.setUser(rating.getUser().getId());
        return ratingDTO;
    }


    @Autowired
    UserRepository userRepository;
    @Autowired
    ManualRepository manualRepository;

    public Rating convertFromItemDTO(RatingDTO ratingDTO){
        Rating rating=modelMapper.map(ratingDTO, Rating.class);
        rating.setUser(userRepository.findOne(ratingDTO.getUser()));
        rating.setManual(manualRepository.findOne(ratingDTO.getManual()));
        return rating;
    }
}
