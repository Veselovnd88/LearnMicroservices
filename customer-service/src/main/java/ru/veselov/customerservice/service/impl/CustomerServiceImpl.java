package ru.veselov.customerservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.veselov.customerservice.dto.CustomerRegistrationRequest;
import ru.veselov.customerservice.entity.CustomerEntity;
import ru.veselov.customerservice.repository.CustomerRepository;
import ru.veselov.customerservice.service.CustomerService;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        CustomerEntity customerEntity = CustomerEntity.builder()
                .lastName(customerRegistrationRequest.lastName())
                .firstName(customerRegistrationRequest.firstName())
                .email(customerRegistrationRequest.email())
                .build();
        customerRepository.save(customerEntity);
        log.info("Customer saved [{}]", customerEntity.getEmail());
    }
}
