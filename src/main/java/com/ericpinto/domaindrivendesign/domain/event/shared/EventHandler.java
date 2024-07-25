package com.ericpinto.domaindrivendesign.domain.event.shared;

public interface EventHandler<T extends Event> {

    void handle(T event);
}
