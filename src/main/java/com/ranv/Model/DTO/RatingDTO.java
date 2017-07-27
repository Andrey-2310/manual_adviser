package com.ranv.Model.DTO;

import com.ranv.Model.ModelDB.Rating;
import com.ranv.Repository.ManualRepository;
import com.ranv.Repository.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Андрей on 27.07.2017.
 */
@Getter
@Setter
@Component
public class RatingDTO extends ModelDTO<RatingDTO, Rating> {

    private Long userId;
    private Long manualId;
    private Long value;

    @Override
    protected RatingDTO convertToItemDTO(Rating rating) {
        RatingDTO ratingDTO = modelMapper.map(rating, RatingDTO.class);
        ratingDTO.setManualId(rating.getManual().getId());
        ratingDTO.setUserId(rating.getUser().getId());
        return ratingDTO;
    }


    @Autowired
    UserRepository userRepository;
    @Autowired
    ManualRepository manualRepository;

    public Rating convertFromItemDTO(RatingDTO ratingDTO){
        Rating rating=modelMapper.map(ratingDTO, Rating.class);
        rating.setUser(userRepository.findOne(ratingDTO.getUserId()));
        rating.setManual(manualRepository.findOne(ratingDTO.getManualId()));
        return rating;
    }
}
