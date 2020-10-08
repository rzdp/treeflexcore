package com.rzdp.treeflexauthorizationserver.service.audit.impl;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        if (name != null) {
            return Optional.of(SecurityContextHolder.getContext().getAuthentication().getName());
        } else {
            return Optional.of("TREEFLEXCORE");
        }
    }
}
