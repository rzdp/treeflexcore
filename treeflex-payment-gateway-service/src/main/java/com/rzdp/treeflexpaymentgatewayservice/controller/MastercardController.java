package com.rzdp.treeflexpaymentgatewayservice.controller;

import com.rzdp.treeflexpaymentgatewayservice.model.PaymentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MastercardController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${payment-method.mastercard.test}")
    private String mastercardTest;

    @PostMapping("/v1/mastercard")
    public PaymentResponse sendPayment() {
        log.info("Sending payment through Mastercard");
        log.info("Payment sent successfully!");
        return new PaymentResponse("Mastercard",
                "Payment sent successfully", mastercardTest);
    }
}
