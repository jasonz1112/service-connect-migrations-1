package com.opentable.gc.infra.connectmigrations.util;

public enum TypeDescription {
    C("Guest Center Restaurant"),
    P("Connect 2.0 (GuestCenter Connect / OTC)"),
    E("ERB"),
    G("GuestBridge"),
    I("Restaurant API"),
    L("Listing");

    private String description;

    TypeDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
