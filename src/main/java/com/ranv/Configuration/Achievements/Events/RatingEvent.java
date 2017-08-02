package com.ranv.Configuration.Achievements.Events;

import com.ranv.Model.ModelDB.Manual;
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
