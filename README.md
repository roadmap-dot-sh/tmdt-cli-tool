# TMDB CLI Tool

Use TMDB API to fetch movie information and display it in the terminal.

Project URL: <a href="https://roadmap.sh/projects/tmdb-cli">https://roadmap.sh/projects/tmdb-cli</a>

## Requirements

The application should run from the command line, and be able to pull and show the popular, top-rated, upcoming and now
playing movies from the TMDB API. The user should be able to specify the type of movies they want to see by passing a
command line argument to the CLI tool.

```bash
tmdb-app --type "playing"
tmdb-app --type "popular"
tmdb-app --type "top"
tmdb-app --type "upcoming"
```

You can look at the API documentation to understand how to fetch the data for each type of movie.

- <a href="https://developer.themoviedb.org/reference/movie-now-playing-list">Now Playing Movies</a>
- <a href="https://developer.themoviedb.org/reference/movie-popular-list">Popular Movies</a>
- <a href="https://developer.themoviedb.org/reference/movie-top-rated-list">Top Rated Movies</a>
- <a href="https://developer.themoviedb.org/reference/movie-upcoming-list">Upcoming Movies</a>

There are some considerations to keep in mind:

- Handle errors gracefully, such as API failures or network issues.
- Use a programming language of your choice to build this project.
- Make sure to include a README file with instructions on how to run the application and any other relevant information.

## Run Application

### Prerequisites

- Java 11 or higher
- Maven 3.6 or higher

### Build from source

#### 1. Clone repository

```bash
git clone https://github.com/roadmap-dot-sh/tmdt-cli-tool.git
cd tmdt-cli-tool
```

#### 2. Build the project

```bash
mvn clean package
```

#### 3. Run the tool

Example:

```bash
java -jar target/tmdt-cli-tool-1.0-SNAPSHOT.jar --type "popular"
```