package com.ericpinto.domaindrivendesign.domain.event.product.handler;

import com.ericpinto.domaindrivendesign.domain.event.product.ProductCreatedEvent;
import com.ericpinto.domaindrivendesign.domain.event.shared.EventHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SendEmailWhenProductIsCreatedHandler implements EventHandler<ProductCreatedEvent> {

    @Override
    public void handle(ProductCreatedEvent event) {
        log.info("Sending email....");
    }
}
