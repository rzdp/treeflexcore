package com.rzdp.treeflexaccountservice.model;

import lombok.Data;

@Data
public class CreateMemberRequest {

    private String firstName;
    private String lastName;
    private String paymentMethod;
}
