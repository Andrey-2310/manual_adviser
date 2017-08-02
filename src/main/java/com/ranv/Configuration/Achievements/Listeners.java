package com.ranv.Configuration.Achievements;

import com.ranv.Configuration.Achievements.Events.CreateManualEvent;
import com.ranv.Service.ServiceModel.MedalService;
import com.ranv.Service.ServiceModel.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Listeners {

    @Autowired
    UserService userService;

    @Autowired
    MedalService medalService;

    @EventListener
    public void handleCreateManualEvent(CreateManualEvent createManualEvent) {
        int manualsCount = userService.findById(createManualEvent.getUserId()).getManuals().size();
        switch (manualsCount) {
            case 1: {
                medalService.setMedalToUser(createManualEvent.getUserId(), "Педик");
                break;
            }
            case 5: {
                System.out.println("Fifth manual. UserId:" + createManualEvent.getUserId());
                break;
            }
        }
    }
}
