package ru.veselov.customerservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.veselov.amqp.producer.RabbitMQMessageProducer;
import ru.veselov.clientsservice.fraud.FraudCheckResponse;
import ru.veselov.clientsservice.fraud.FraudClient;
import ru.veselov.clientsservice.notification.NotificationClient;
import ru.veselov.clientsservice.notification.NotificationRequest;
import ru.veselov.customerservice.dto.CustomerRegistrationRequest;
import ru.veselov.customerservice.entity.CustomerEntity;
import ru.veselov.customerservice.repository.CustomerRepository;
import ru.veselov.customerservice.service.CustomerService;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final FraudClient fraudClient;

    private final NotificationClient notificationClient;

    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    @Override
    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        CustomerEntity customerEntity = CustomerEntity.builder()
                .lastName(customerRegistrationRequest.lastName())
                .firstName(customerRegistrationRequest.firstName())
                .email(customerRegistrationRequest.email())
                .build();
        customerRepository.saveAndFlush(customerEntity);
        log.info("Customer saved [{}]", customerEntity.getId());

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customerEntity.getId());
        if (fraudCheckResponse.isFraudster()) {
            log.error("Customer is fraudster");
            throw new IllegalStateException("Customer is fraudster");
        }
        log.info("Customer is no a fraudster");
        NotificationRequest hello = new NotificationRequest(
                customerEntity.getId(),
                customerEntity.getEmail(),
                "Hello"
        );
        rabbitMQMessageProducer.publish(hello,
                "internal.exchange",
                "internal.notification.routing-key"
        );

        log.info("Notification sent for [{}]", customerEntity.getEmail());
    }
}
