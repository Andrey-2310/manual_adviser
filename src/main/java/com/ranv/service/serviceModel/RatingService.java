package com.ranv.service.serviceModel;

import com.ranv.model.DB.Rating;
import com.ranv.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public void saveRating(Rating rating) {
        ratingRepository.save(rating);
    }

    public List<Rating> getRatingsByUserId(Long userId) {
        return ratingRepository.findAllByUser_Id(userId);
    }

    public List<Rating> getRatingsByUserIdAndAuthorId(Long userId, Long authorId) {
        return ratingRepository.findAllByUser_IdAndManual_User_Id(userId, authorId);
    }
}
