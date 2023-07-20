package ru.veselov.customerservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.veselov.customerservice.dto.CustomerRegistrationRequest;
import ru.veselov.customerservice.dto.FraudCheckResponse;
import ru.veselov.customerservice.entity.CustomerEntity;
import ru.veselov.customerservice.repository.CustomerRepository;
import ru.veselov.customerservice.service.CustomerService;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    public static final String FRAUD_URL = "http://localhost:7075/api/v1/fraud-check/";

    private final CustomerRepository customerRepository;

    private final RestTemplate restTemplate;

    @Override
    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        CustomerEntity customerEntity = CustomerEntity.builder()
                .lastName(customerRegistrationRequest.lastName())
                .firstName(customerRegistrationRequest.firstName())
                .email(customerRegistrationRequest.email())
                .build();
        customerRepository.saveAndFlush(customerEntity);
        log.info("Customer saved [{}]", customerEntity.getId());
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(FRAUD_URL + "{customerId}",
                FraudCheckResponse.class, customerEntity.getId().toString());
        if (fraudCheckResponse.isFraudster()) {
            log.error("Customer is fraudster");
            throw new IllegalStateException("Customer is fraudster");
        }
        log.info("Customer is no a fraudster");
        //TODO notification
    }
}
