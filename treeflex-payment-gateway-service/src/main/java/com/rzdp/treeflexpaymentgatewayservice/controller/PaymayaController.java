package com.rzdp.treeflexpaymentgatewayservice.controller;

import com.rzdp.treeflexpaymentgatewayservice.model.PaymentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymayaController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${payment-method.paymaya.test}")
    private String paymayaTest;

    @PostMapping("/v1/paymaya")
    public PaymentResponse sendPayment() {
        log.info("Sending payment through PayMaya");
        log.info("Payment sent successfully!");
        return new PaymentResponse("PayMaya",
                "Payment sent successfully", paymayaTest);
    }
}
