package com.ericpinto.domaindrivendesign.domain.shared.notification;

import java.util.List;
import java.util.stream.Collectors;

public class NotificationException extends RuntimeException {
    public NotificationException(List<NotificationError> errors) {
        super(errors.stream()
                .map(error -> error.getContext() + ": " + error.getMessage())
                .collect(Collectors.joining()));
    }
}
