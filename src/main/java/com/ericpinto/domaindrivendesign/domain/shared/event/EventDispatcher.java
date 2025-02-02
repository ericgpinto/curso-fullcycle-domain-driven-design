package com.ericpinto.domaindrivendesign.domain.shared.event;
/*
* Classe que notifica e registra tudo que acontece na aplicação
* */
public interface EventDispatcher {

    void notify(Event event);
    void register(String eventName, EventHandler<Event> eventHandler);
    void unRegister(String eventName, EventHandler<Event> eventHandler);
    void unRegisterAll();

}
