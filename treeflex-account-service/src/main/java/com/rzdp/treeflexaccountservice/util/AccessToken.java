package com.rzdp.treeflexaccountservice.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

public class AccessToken {

    public static String getAccessToken() {
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)
                SecurityContextHolder.getContext().getAuthentication().getDetails();
        return details.getTokenType().concat(" ").concat(details.getTokenValue());
    }
}
