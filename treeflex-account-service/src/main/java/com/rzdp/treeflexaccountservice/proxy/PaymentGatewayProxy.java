package com.rzdp.treeflexaccountservice.proxy;

import com.rzdp.treeflexaccountservice.model.proxy.emailservice.MessageResponse;
import com.rzdp.treeflexaccountservice.model.proxy.paymentgatewayservice.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "treeflex-payment-gateway-service")
public interface PaymentGatewayProxy {

    @PostMapping("/v1/paypal")
    public PaymentResponse sendPayPalPayment(@RequestHeader("Authorization") String token);

    @PostMapping("/v1/paymaya")
    public PaymentResponse sendPayMayaPayment(@RequestHeader("Authorization") String token);

    @PostMapping("/v1/mastercard")
    public PaymentResponse sendMasterCardPayment(@RequestHeader("Authorization") String token);

    @PostMapping("/v1/visa")
    public PaymentResponse sendVisaPayment(@RequestHeader("Authorization") String token);
}
