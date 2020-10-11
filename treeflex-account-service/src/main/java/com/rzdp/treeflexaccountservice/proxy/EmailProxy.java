package com.rzdp.treeflexaccountservice.proxy;

import com.rzdp.treeflexaccountservice.model.proxy.emailservice.MessageResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "treeflex-email-service")
public interface EmailProxy {

    @GetMapping("/v1/email")
    public MessageResponse sendEmail(@RequestHeader("Authorization") String token);
}
