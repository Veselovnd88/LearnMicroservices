package ru.veselov.fraudservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FraudCheckResponse {

    private boolean isFraudster;

}
