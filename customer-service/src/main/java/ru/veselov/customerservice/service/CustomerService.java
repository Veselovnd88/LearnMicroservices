package ru.veselov.customerservice.service;

import ru.veselov.customerservice.dto.CustomerRegistrationRequest;

public interface CustomerService {

    void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest);
}
