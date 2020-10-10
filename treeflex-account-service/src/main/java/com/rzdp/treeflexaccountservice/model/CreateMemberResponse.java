package com.rzdp.treeflexaccountservice.model;

import lombok.Data;

@Data
public class CreateMemberResponse {
    private String firstName;
    private String lastName;
    private EmailResponse email;

    @Data
    public static class EmailResponse {
        private Boolean success;
        private String message;
    }
}
