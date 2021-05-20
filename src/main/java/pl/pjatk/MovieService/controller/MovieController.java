package pl.pjatk.MovieService.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.MovieService.model.Movie;
import pl.pjatk.MovieService.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

  private final MovieService movieService;

  public MovieController(MovieService movieService) {
    this.movieService = movieService;
  }

  @GetMapping
  public ResponseEntity<List<Movie>> getAllMovies() {

    List<Movie> allMovies = movieService.getAllMovies();

    return ResponseEntity.ok(allMovies);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {

    Movie moviesById = movieService.getMovieById(id);

    if (moviesById == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.ok(moviesById);
  }

  @PostMapping
  public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {

    if (movie == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    movieService.addMovie(movie);

    return ResponseEntity.ok().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Movie> updateMovieById(@PathVariable Long id, @RequestBody Movie movie) {

    Movie moviesById = movieService.getMovieById(id);

    if (moviesById == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    movieService.updateMovieById(id, movie);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Movie> deleteMovie(@PathVariable Long id) {

    if (movieService.getMovieById(id) == null) {

      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    movieService.deleteById(id);

    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }


}
