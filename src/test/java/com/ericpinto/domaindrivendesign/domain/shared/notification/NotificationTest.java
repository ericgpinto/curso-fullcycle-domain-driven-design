package com.ericpinto.domaindrivendesign.domain.shared.notification;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotificationTest {

    @Test
    void shouldCreateAnError(){
        NotificationError error = new NotificationError();
        error.setMessage("Error message");
        error.setContext("customer");

        Notification notification = new Notification();
        notification.addError(error);

        assertEquals(notification.getErrorsAsString(null), "customer: Error message");

        NotificationError error2 = new NotificationError();
        error2.setMessage("Error message2");
        error2.setContext("customer");

        notification.addError(error2);

        assertEquals(notification.getErrorsAsString("customer"), "customer: Error message, customer: Error message2");

        NotificationError error3 = new NotificationError();
        error3.setMessage("Error message3");
        error3.setContext("order");

        notification.addError(error3);
        assertEquals(notification.getErrorsAsString(null),
                "customer: Error message, customer: Error message2, order: Error message3");
    }

    @Test
    void shouldCheckIfNotificationHasAtLeastOneError(){
        NotificationError error = new NotificationError();
        error.setMessage("Error message");
        error.setContext("customer");

        Notification notification = new Notification();
        notification.addError(error);

        assertTrue(notification.hasErrors());
    }

    @Test
    void shouldGetAllErrors(){
        NotificationError error = new NotificationError();
        error.setMessage("Error message");
        error.setContext("customer");

        Notification notification = new Notification();
        notification.addError(error);

        assertEquals(notification.getErrors().size(), 1);
    }


}