package ru.veselov.clientsservice.notification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequest {

    private UUID toCustomerId;

    private String toCustomerName;

    private String message;

}
