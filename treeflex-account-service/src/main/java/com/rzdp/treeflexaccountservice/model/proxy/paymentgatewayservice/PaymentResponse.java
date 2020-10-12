package com.rzdp.treeflexaccountservice.model.proxy.paymentgatewayservice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentResponse {

    private String paymentMethod;
    private String message;
    private String description;
}
