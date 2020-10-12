package com.rzdp.treeflexaccountservice.model;

import lombok.Data;

@Data
public class CreateMemberResponse {
    private String firstName;
    private String lastName;
    private EmailResponse email;
    private PaymentResponse payment;

    @Data
    public static class EmailResponse {
        private Boolean success;
        private String message;
    }

    @Data
    public static class PaymentResponse {
        private String paymentMethod;
        private String message;
        private String description;
    }
}
