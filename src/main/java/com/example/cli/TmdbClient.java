/*
 * TmdbClient.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.example.cli;

import com.example.enums.MovieType;
import com.example.model.Movie;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * TmdbClient.java
 *
 * @author Nguyen
 */
public class TmdbClient {
    private static final String BASE_URL = "https://api.themoviedb.org/3/movie/";
    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();

    public List<Movie> fetchMovies(MovieType type) {
//        String apiKey = System.getenv("TMDB_API_KEY");

//        if (apiKey == null) {
//            throw new RuntimeException("Missing TMDB_API_KEY environment variable");
//        }

//        String url = BASE_URL + type.getPath() + "?api_key=" + apiKey;

        String url = BASE_URL + type.getPath();

        Request request = new Request.Builder().url(url).build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new RuntimeException("API error: " + response.code());
            }

            String json = response.body().string();

            JsonNode root = mapper.readTree(json);
            JsonNode results = root.get("results");

            return mapper.convertValue(
                    results,
                    new TypeReference<List<Movie>>() {
                    }
            );
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch movies", e);
        }
    }
}
