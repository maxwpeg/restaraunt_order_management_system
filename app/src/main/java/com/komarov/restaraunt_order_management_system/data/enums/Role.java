package com.komarov.restaraunt_order_management_system.data.enums;

import jakarta.persistence.Entity;
import org.springframework.security.core.GrantedAuthority;


public enum Role implements GrantedAuthority {
    ROLE_CLIENT, ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
