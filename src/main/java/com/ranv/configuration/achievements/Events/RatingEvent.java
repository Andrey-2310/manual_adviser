package com.ranv.configuration.achievements.Events;

import com.ranv.model.DB.Manual;
import org.springframework.context.ApplicationEvent;

public class RatingEvent extends ApplicationEvent {

    private Manual manual;

    public RatingEvent(Object source, Manual manual) {
        super(source);
        this.manual = manual;
    }

    public Manual getManual() {
        return manual;
    }
}
