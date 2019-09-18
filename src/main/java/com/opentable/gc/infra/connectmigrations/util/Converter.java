package com.opentable.gc.infra.connectmigrations.util;

public final class Converter {

    private Converter() {

    }

    public static String getTypeDescription(String restaurantType) {
        if ("C".equals(restaurantType)) {
            return "Guest Center Restaurant";
        }
        else if ("P".equals(restaurantType)) {
            return "Connect 2.0 (GuestCenter Connect / OTC)";
        }
        else if ("E".equals(restaurantType)) {
            return "ERB";
        }
        else if ("G".equals(restaurantType)) {
            return "GuestBridge";
        }
        else if ("I".equals(restaurantType)) {
            return "Restaurant API";
        }
        else if ("L".equals(restaurantType)) {
            return "Listing";
        }
        else {
            return "no description found for the given type";
        }
    }

    public static String getStateDescription(String stateId) {
        if ("1".equals(stateId)) {
            return "Active";
        }
        else if ("2".equals(stateId)) {
            return "Awaiting Install";
        }
        else if ("4".equals(stateId)) {
            return "Inactive";
        }
        else if ("5".equals(stateId)) {
            return "Closed Temporarily";
        }
        else if ("6".equals(stateId)) {
            return "Seasonal";
        }
        else if ("7".equals(stateId)) {
            return "Temporarily Inactive";
        }
        else if ("8".equals(stateId)) {
            return "Initiating Uninstall";
        }
        else if ("10".equals(stateId)) {
            return "Client Grace Period";
        }
        else if ("11".equals(stateId)) {
            return "Decline Online w/ Conn.";
        }
        else if ("12".equals(stateId)) {
            return "Waiting for Connectivity";
        }
        else if ("13".equals(stateId)) {
            return "Updating Book";
        }
        else if ("14".equals(stateId)) {
            return "No Connectivity Available";
        }
        else if ("15".equals(stateId)) {
            return "Decline Online w/o Conn.";
        }
        else if ("16".equals(stateId)) {
            return "False Reserve Now";
        }
        else {
            return "no state description found for the given stateId";
        }

    }

}
