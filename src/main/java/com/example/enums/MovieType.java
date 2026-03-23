/*
 * MovieType.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.example.enums;

/**
 * MovieType.java
 *
 * @author Nguyen
 */
public enum MovieType {
    PLAYING("now_playing"),
    POPULAR("popular"),
    TOP("top_rated"),
    UPCOMING("upcoming");

    private final String path;

    MovieType(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
