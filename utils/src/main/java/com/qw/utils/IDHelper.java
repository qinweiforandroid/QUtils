package com.qw.utils;

import java.util.UUID;

/**
 * id生成器
 */
public class IDHelper {
    /**
     * Generates a new id for sync objects
     * UUID.randomUUID
     *
     * @return random id
     */
    public static String generateNew() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
