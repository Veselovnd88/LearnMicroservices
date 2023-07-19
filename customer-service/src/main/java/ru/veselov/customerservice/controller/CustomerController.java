package ru.veselov.customerservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.veselov.customerservice.dto.CustomerRegistrationRequest;
import ru.veselov.customerservice.service.CustomerService;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public void RegisterCustomer(@RequestBody CustomerRegistrationRequest customerRequest) {
        customerService.registerCustomer(customerRequest);
    }


}
