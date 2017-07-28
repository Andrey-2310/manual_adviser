package com.ranv.Service.ServiceModel;

import com.ranv.Model.ModelDB.Rating;
import com.ranv.Repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    public  void saveRating(Rating rating){
        ratingRepository.save(rating);
    }
}
