package com.ericpinto.domaindrivendesign.domain.shared.entity;

import com.ericpinto.domaindrivendesign.domain.shared.notification.Notification;

public abstract class Entity {

    protected String id;
    protected Notification notification;

    public Entity(){
        this.notification = new Notification();
    }
}
