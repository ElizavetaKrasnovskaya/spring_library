package com.bsuir.test.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER("User"), ADMIN("Admin");

    private String name;

    @Override
    public String getAuthority() {
        return name();
    }

    Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}