package com.rzdp.treeflexpaymentgatewayservice.controller;

import com.rzdp.treeflexpaymentgatewayservice.model.PaymentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaypalController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${payment-method.paypal.test}")
    private String paypalTest;

    @PostMapping("/v1/paypal")
    public PaymentResponse sendPayment() {
        log.info("Sending payment through PayPal");
        log.info("Payment sent successfully!");
        return new PaymentResponse("PayPal",
                "Payment sent successfully", paypalTest);
    }
}
