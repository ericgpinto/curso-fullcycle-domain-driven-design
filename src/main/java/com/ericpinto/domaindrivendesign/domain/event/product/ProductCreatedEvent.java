package com.ericpinto.domaindrivendesign.domain.event.product;

import com.ericpinto.domaindrivendesign.domain.event.shared.Event;

import java.util.Date;

public class ProductCreatedEvent implements Event {
    Date dateTimeOccurred;
    Object eventData;

    public ProductCreatedEvent(Object eventData) {
        this.dateTimeOccurred = new Date();
        this.eventData = eventData;
    }

    @Override
    public Date getDataTimeOccurred() {
        return dateTimeOccurred;
    }

    @Override
    public Object getEventData() {
        return eventData;
    }

    @Override
    public void setDataTimeOccurred(Date dataTimeOccurred) {
        this.dateTimeOccurred = dataTimeOccurred;
    }

    @Override
    public void setEventData(Object eventData) {
        this.eventData = eventData;
    }
}
