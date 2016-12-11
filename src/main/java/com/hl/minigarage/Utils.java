package com.hl.minigarage;

public class Utils {

    public static String generateShortName(String longName) {
        return longName.replaceAll(" ", "-").replaceAll("[^a-zA-Z0-9-]+","").toLowerCase();
    }

}
