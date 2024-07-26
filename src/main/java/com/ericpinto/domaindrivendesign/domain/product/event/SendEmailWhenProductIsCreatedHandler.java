package com.ericpinto.domaindrivendesign.domain.product.event;

import com.ericpinto.domaindrivendesign.domain.shared.event.EventHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SendEmailWhenProductIsCreatedHandler implements EventHandler<ProductCreatedEvent> {

    @Override
    public void handle(ProductCreatedEvent event) {
        log.info("Sending email....");
    }
}
