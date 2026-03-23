/*
 * MovieService.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.example.service;

import com.example.cli.TmdbClient;
import com.example.enums.MovieType;
import com.example.model.Movie;

import java.util.List;

/**
 * MovieService.java
 *
 * @author Nguyen
 */
public class MovieService {
    private final TmdbClient client = new TmdbClient();

    public List<Movie> getMovies(MovieType type) {
        return client.fetchMovies(type);
    }
}
