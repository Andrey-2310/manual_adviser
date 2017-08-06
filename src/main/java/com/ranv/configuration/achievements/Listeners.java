package com.ranv.configuration.achievements;

import com.ranv.configuration.achievements.events.CreateManualEvent;
import com.ranv.configuration.achievements.events.RatingEvent;
import com.ranv.service.serviceModel.MedalService;
import com.ranv.service.serviceModel.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Listeners {


    private final UserService userService;
    private final MedalService medalService;

    @Autowired
    public Listeners(UserService userService, MedalService medalService) {
        this.userService = userService;
        this.medalService = medalService;
    }


    @EventListener
    public void handleCreateManualEvent(CreateManualEvent createManualEvent) {
        int manualsCount = userService.findById(createManualEvent.getUserId()).getManuals().size();
        switch (manualsCount) {
            case 1: {
                medalService.setMedalToUser(createManualEvent.getUserId(), "First manual");
                break;
            }
            case 10: {
                medalService.setMedalToUser(createManualEvent.getUserId(), "Tenth manual");
                break;
            }
        }
    }

    @EventListener
    public void handleRatingEvent(RatingEvent ratingEvent) {
        switch (ratingEvent.getManual().getRating()) {
            case -1: {
                medalService.setMedalToUser(ratingEvent.getManual().getUser().getId(), "Loh");
                break;
            }
            case 10: {
                medalService.setMedalToUser(ratingEvent.getManual().getUser().getId(), "Tenth like");
            }
        }
    }
}
