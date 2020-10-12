package com.rzdp.treeflexaccountservice.controller;

import com.rzdp.treeflexaccountservice.model.CreateMemberRequest;
import com.rzdp.treeflexaccountservice.model.CreateMemberResponse;
import com.rzdp.treeflexaccountservice.model.MessageResponse;
import com.rzdp.treeflexaccountservice.model.proxy.paymentgatewayservice.PaymentResponse;
import com.rzdp.treeflexaccountservice.proxy.EmailProxy;
import com.rzdp.treeflexaccountservice.proxy.PaymentGatewayProxy;
import com.rzdp.treeflexaccountservice.util.AccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final EmailProxy emailProxy;
    private final PaymentGatewayProxy paymentGatewayProxy;

    @Autowired
    public MemberController(EmailProxy emailProxy, PaymentGatewayProxy paymentGatewayProxy) {
        this.emailProxy = emailProxy;
        this.paymentGatewayProxy = paymentGatewayProxy;
    }

    @PostMapping("/v1/members")
    public MessageResponse createMember(@RequestBody CreateMemberRequest request) {
        log.info("Creating member");
        CreateMemberResponse response = new CreateMemberResponse();
        response.setFirstName(request.getFirstName());
        response.setLastName(request.getLastName());

        String paymentMethod = request.getPaymentMethod().toUpperCase();
        log.info("Sending Payment through {}", paymentMethod);

        PaymentResponse proxyPaymentResponse;
        if (paymentMethod.equals("PAYPAL")) {
            proxyPaymentResponse = paymentGatewayProxy
                    .sendPayPalPayment(AccessToken.getAccessToken());
        } else if (paymentMethod.equals("PAYMAYA")) {
            proxyPaymentResponse = paymentGatewayProxy
                    .sendPayMayaPayment(AccessToken.getAccessToken());
        } else if (paymentMethod.equals("MASTERCARD")) {
            proxyPaymentResponse = paymentGatewayProxy
                    .sendMasterCardPayment(AccessToken.getAccessToken());
        } else if (paymentMethod.equals("VISA")) {
            proxyPaymentResponse = paymentGatewayProxy
                    .sendVisaPayment(AccessToken.getAccessToken());
        } else {
            throw new IllegalArgumentException("Invalid Payment Method");
        }

        log.info("Sending payment through {} successful", paymentMethod);
        CreateMemberResponse.PaymentResponse paymentResponse =
                new CreateMemberResponse.PaymentResponse();
        paymentResponse.setPaymentMethod(proxyPaymentResponse.getPaymentMethod());
        paymentResponse.setMessage(proxyPaymentResponse.getMessage());
        paymentResponse.setDescription(proxyPaymentResponse.getDescription());
        response.setPayment(paymentResponse);

        log.info("Sending email notification to member");
        CreateMemberResponse.EmailResponse emailResponse = new CreateMemberResponse.EmailResponse();
        emailResponse.setMessage(emailProxy.sendEmail(AccessToken.getAccessToken()).getMessage());
        emailResponse.setSuccess(true);
        response.setEmail(emailResponse);
        log.info("Email sent successfully");
        return new MessageResponse("Create member successful", response);
    }
}
