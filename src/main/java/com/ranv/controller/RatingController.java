package com.ranv.controller;

import com.ranv.configuration.achievements.events.RatingEvent;
import com.ranv.model.DB.Rating;
import com.ranv.model.DTO.RatingDTO;
import com.ranv.service.eventsPublishing.Publisher;
import com.ranv.service.serviceDTO.ServiceRatingDTO;
import com.ranv.service.serviceModel.ManualService;
import com.ranv.service.serviceModel.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class RatingController {

    private final ServiceRatingDTO serviceRatingDTO;
    private final ManualService manualService;
    private final RatingService ratingService;
    private final Publisher publisher;

    @Autowired
    public RatingController(ServiceRatingDTO serviceRatingDTO, ManualService manualService,
                            RatingService ratingService, Publisher publisher){
        this.serviceRatingDTO=serviceRatingDTO;
        this.manualService=manualService;
        this.ratingService=ratingService;
        this.publisher = publisher;
    }

    @RequestMapping(value = "/setRating", method = RequestMethod.POST)
    public void setRating(@RequestBody RatingDTO ratingDTO) {
        Rating rating = serviceRatingDTO.convertFromItemDTO(ratingDTO);
        rating.getManual().setRating(rating.getManual().getRating() + rating.getValue());
        manualService.saveManual(rating.getManual());
        ratingService.saveRating(rating);
        publisher.publish(new RatingEvent(this, rating.getManual()));
    }

    @RequestMapping("/getRatingsByUserId/{userId}")
    public List<RatingDTO> getCommentsByStepId(@PathVariable Long userId) {
        return serviceRatingDTO.convertItems(ratingService.getRatingsByUserId(userId));
    }

    @RequestMapping("/getRatingsByUserIdAndAuthorId/{userId}/{authorId}")
    public List<RatingDTO> getCommentsByStepIdAndAuthorId(@PathVariable Long userId, @PathVariable Long authorId ) {
        return serviceRatingDTO.convertItems(ratingService.getRatingsByUserIdAndAuthorId(userId, authorId));
    }

}
