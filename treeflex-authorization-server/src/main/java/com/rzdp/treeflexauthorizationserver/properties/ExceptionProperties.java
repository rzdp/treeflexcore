package com.rzdp.treeflexauthorizationserver.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "exception")
@PropertySource("classpath:message/messages.properties")
@Data
public class ExceptionProperties {

    private UsernameNotFound usernameNotFound;

    @Data
    public static class UsernameNotFound {
        private String v1;
    }
}
