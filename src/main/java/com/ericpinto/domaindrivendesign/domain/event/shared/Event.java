package com.ericpinto.domaindrivendesign.domain.event.shared;

import java.util.Date;

public interface Event {

    Date dataTimeOccurred = null;
    Object eventData = null;

    Date getDataTimeOccurred();
    Object getEventData();
    void setDataTimeOccurred(Date dataTimeOccurred);
    void setEventData(Object eventData);

}
