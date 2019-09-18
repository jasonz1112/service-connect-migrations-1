package com.opentable.gc.infra.connectmigrations.clients;

public class SourceRequest {
    private final String email;
    private final String phoneNumber;

    public SourceRequest(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
