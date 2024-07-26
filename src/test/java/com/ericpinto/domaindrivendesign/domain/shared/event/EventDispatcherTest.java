package com.ericpinto.domaindrivendesign.domain.shared.event;

import static org.junit.jupiter.api.Assertions.*;

import com.ericpinto.domaindrivendesign.domain.product.event.ProductCreatedEvent;
import com.ericpinto.domaindrivendesign.domain.product.event.SendEmailWhenProductIsCreatedHandler;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EventDispatcherTest {

    @Test
    void shouldRegisterEventHandler() {
        EventDispatcherImpl eventDispatcher = new EventDispatcherImpl();
        EventHandler eventHandler = new SendEmailWhenProductIsCreatedHandler();

        eventDispatcher.register("ProductCreatedEvent", eventHandler);

        assertTrue(eventDispatcher.getEventHandlers().containsValue("ProductCreatedEvent"));
        assertEquals(1, eventDispatcher.getEventHandlers().size());
    }

    @Test
    void shouldUnregisterEventHandler() {
        EventDispatcherImpl eventDispatcher = new EventDispatcherImpl();
        EventHandler eventHandler = new SendEmailWhenProductIsCreatedHandler();

        eventDispatcher.register("ProductCreatedEvent", eventHandler);
        assertTrue(eventDispatcher.getEventHandlers().containsValue("ProductCreatedEvent"));

        eventDispatcher.unRegister("ProductCreatedEvent", eventHandler);
        assertEquals(0, eventDispatcher.getEventHandlers().size());

    }

    @Test
    void shouldUnregisterAllEventHandlers() {
        EventDispatcherImpl eventDispatcher = new EventDispatcherImpl();
        EventHandler eventHandler = new SendEmailWhenProductIsCreatedHandler();

        eventDispatcher.register("ProductCreatedEvent", eventHandler);
        assertTrue(eventDispatcher.getEventHandlers().containsValue("ProductCreatedEvent"));

        eventDispatcher.unRegisterAll();
        assertEquals(0, eventDispatcher.getEventHandlers().size());
    }

    @Test
    void shouldNotifyAllEventHandlers() {
        EventHandler<ProductCreatedEvent> eventHandler = Mockito.mock(EventHandler.class);
        EventDispatcherImpl eventDispatcher = new EventDispatcherImpl();
        eventDispatcher.register("ProductCreatedEvent", eventHandler);

        ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent("ProductCreatedEvent");
        eventDispatcher.notify(productCreatedEvent);

        Mockito.verify(eventHandler, Mockito.times(1)).handle(productCreatedEvent);
    }

}