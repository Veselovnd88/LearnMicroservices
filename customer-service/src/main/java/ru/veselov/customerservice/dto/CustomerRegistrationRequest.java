package ru.veselov.customerservice.dto;

public record CustomerRegistrationRequest(
        //todo validation
        String firstName,
        String lastName,
        String email) {
}
