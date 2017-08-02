package com.ranv.Controller;

import com.ranv.Model.DTO.RatingDTO;
import com.ranv.Model.ModelDB.Rating;
import com.ranv.Service.ServiceDTO.ServiceRatingDTO;
import com.ranv.Service.ServiceModel.ManualService;
import com.ranv.Service.ServiceModel.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class RatingController {

    private final ServiceRatingDTO serviceRatingDTO;
    private final ManualService manualService;
    private final RatingService ratingService;

    @Autowired
    public RatingController(ServiceRatingDTO serviceRatingDTO, ManualService manualService,
                            RatingService ratingService){
        this.serviceRatingDTO=serviceRatingDTO;
        this.manualService=manualService;
        this.ratingService=ratingService;
    }

    @RequestMapping(value = "/setRating", method = RequestMethod.POST)
    public void setRating(@RequestBody RatingDTO ratingDTO) {
        Rating rating = serviceRatingDTO.convertFromItemDTO(ratingDTO);
        rating.getManual().setRating(rating.getManual().getRating() + rating.getValue());
        manualService.saveManual(rating.getManual());
        ratingService.saveRating(rating);

    }
}
