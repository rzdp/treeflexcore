package com.rzdp.treeflexpaymentgatewayservice.controller;

import com.rzdp.treeflexpaymentgatewayservice.model.PaymentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VisaController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${payment-method.visa.test}")
    private String visaTest;

    @PostMapping("/v1/visa")
    public PaymentResponse sendPayment() {
        log.info("Sending payment through Visa");
        log.info("Payment sent successfully!");
        return new PaymentResponse("Visa",
                "Payment sent successfully", visaTest);
    }
}
