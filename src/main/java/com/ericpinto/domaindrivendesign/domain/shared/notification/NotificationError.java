package com.ericpinto.domaindrivendesign.domain.shared.notification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationError {
    private String message;
    private String context;
}
