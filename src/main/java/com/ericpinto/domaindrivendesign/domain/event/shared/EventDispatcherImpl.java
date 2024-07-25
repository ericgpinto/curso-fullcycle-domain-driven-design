package com.ericpinto.domaindrivendesign.domain.event.shared;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class EventDispatcherImpl implements EventDispatcher{

    Map<EventHandler<Event>, String> eventHandlers = new HashMap<>();

    @Override
    public void notify(Event event) {
        String eventName = event.getEventData().toString();
        if (this.eventHandlers.containsValue(eventName)){
            this.eventHandlers
                    .forEach((eventHandler, eventName2) -> eventHandler.handle(event));
        }
    }

    @Override
    public void register(String eventName, EventHandler eventHandler) {

        if (!eventHandlers.containsValue(eventName)) {
            this.eventHandlers = new HashMap<>();
        }

        eventHandlers.put(eventHandler, eventName);

    }

    @Override
    public void unRegister(String eventName, EventHandler<Event> eventHandler) {

        if (this.eventHandlers.containsValue(eventName)){
            this.eventHandlers.remove(eventHandler, eventName);
        }
    }

    @Override
    public void unRegisterAll() {
        eventHandlers.clear();
    }
}
