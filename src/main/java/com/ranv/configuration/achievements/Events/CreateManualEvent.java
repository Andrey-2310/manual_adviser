package com.ranv.configuration.achievements.Events;

import org.springframework.context.ApplicationEvent;

public class CreateManualEvent extends ApplicationEvent {

    private Long userId;

    public CreateManualEvent(Object source, Long userId) {
        super(source);
        this.userId = userId;
    }


    public Long getUserId() {
        return userId;
    }
}
