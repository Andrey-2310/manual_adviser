package com.ranv.Model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private Long user;
    private Long manual;
    private Long value;

    @Override
    protected RatingDTO convertToItemDTO(Rating rating) {
        RatingDTO ratingDTO = modelMapper.map(rating, RatingDTO.class);
        ratingDTO.setManual(rating.getManual().getId());
        ratingDTO.setUser(rating.getUser().getId());
        return ratingDTO;
    }


    @Autowired
    @JsonIgnore
    UserRepository userRepository;
    @Autowired
    @JsonIgnore
    ManualRepository manualRepository;

    public Rating convertFromItemDTO(RatingDTO ratingDTO){
        Rating rating=modelMapper.map(ratingDTO, Rating.class);
        rating.setUser(userRepository.findOne(ratingDTO.getUser()));
        rating.setManual(manualRepository.findOne(ratingDTO.getManual()));
        return rating;
    }
}
