package com.qw.utils;

import java.util.UUID;

public class IDHelper {
    /**
     * Generates a new id for sync objects
     *
     * @return random id
     */
    public static String generateNew() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
