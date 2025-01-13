package com.ericpinto.domaindrivendesign.domain.shared.notification;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Notification {

    private final List<NotificationError> errors = new ArrayList<>();

    public void addError(NotificationError error) {
        errors.add(error);
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public List<NotificationError> getErrors() {
        return errors;
    }

    public String getErrorsAsString(String context) {
        StringBuilder message = new StringBuilder();
        this.errors.forEach(error -> {
            if (context == null || error.getContext().equals(context)) {
                if (!message.isEmpty()) {
                    message.append(", ");
                }
                message.append(error.getContext()).append(": ").append(error.getMessage());
            }
        });
        return message.toString();
    }
}
