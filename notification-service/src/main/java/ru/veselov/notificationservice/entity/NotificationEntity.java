package ru.veselov.notificationservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@EqualsAndHashCode(exclude = "notificationId")
@Table(name = "notification")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationEntity {

    @Id
    @GeneratedValue
    @Column(name = "notification_id", columnDefinition = "uuid", updatable = false)
    private UUID notificationId;

    @Column(name = "to_customer_id")
    private UUID toCustomerId;

    @Column(name = "to_customer_email")
    private String toCustomerEmail;

    @Column(name = "sender")
    private String sender;

    @Column(name = "message", columnDefinition = "varchar(1000")
    private String message;

    @Column(name = "sent_At")
    private LocalDateTime sentAt;

}
