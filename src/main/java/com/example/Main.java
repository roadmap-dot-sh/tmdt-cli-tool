package com.example;

import com.example.enums.MovieType;
import com.example.model.Movie;
import com.example.service.MovieService;
import picocli.CommandLine;

import java.util.List;

@CommandLine.Command(name = "tmdb-app")
public class Main implements Runnable {
    @CommandLine.Option(names = "--type",
            required = true,
            description = "playing, popular, top, upcoming"
    )
    private String type;

    public static void main(String[] args) {
        new CommandLine(new Main()).execute(args);
    }

    @Override
    public void run() {
        try {
            MovieType movieType = MovieType.valueOf(type.toUpperCase());

            MovieService service = new MovieService();
            List<Movie> movies = service.getMovies(movieType);

            movies.stream().limit(10).forEach(m ->
                    System.out.printf("%s (%s) %.1f%n",
                            m.title,
                            m.released_date,
                            m.vote_average
                    )
            );
            
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid type. Use: playing | popular | top | upcoming");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}