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
import pl.pjatk.MovieService.exception.NotFoundMovieException;
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
  public ResponseEntity<Movie> getMovieById(@PathVariable Long id) throws NotFoundMovieException {

    Movie movie = movieService.getMovieById(id)
        .orElseThrow(() -> new NotFoundMovieException(String.valueOf(id)));

    return ResponseEntity.ok(movie);
  }

  @PostMapping
  public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {

    if (movie == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    movie = movieService.addMovie(movie);

    return ResponseEntity.ok(movie);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Movie> updateMovieById(@PathVariable Long id, @RequestBody Movie movie)
      throws NotFoundMovieException {

    movieService.getMovieById(id).orElseThrow(() -> new NotFoundMovieException(String.valueOf(id)));

    movieService.updateMovieById(id, movie);

    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Movie> deleteMovie(@PathVariable Long id) throws NotFoundMovieException {

    movieService.getMovieById(id)
        .orElseThrow(() -> new NotFoundMovieException(String.valueOf(id)));

    movieService.deleteById(id);

    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @GetMapping("/changeIsAvailable/{id}")
  public ResponseEntity<Movie> changeIsAvailable(@PathVariable Long id)
      throws NotFoundMovieException {

    movieService.getMovieById(id)
        .orElseThrow(() -> new NotFoundMovieException(String.valueOf(id)));

    movieService.changeIsAvailableToTrue(id);

    return ResponseEntity.ok().build();
  }
}
