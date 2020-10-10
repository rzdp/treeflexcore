package com.rzdp.treeflexaccountservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageResponse {

    private String message;
    public Object data;
}
