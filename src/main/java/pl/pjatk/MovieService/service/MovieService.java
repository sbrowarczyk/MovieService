package pl.pjatk.MovieService.service;

import java.util.List;
import org.springframework.stereotype.Service;
import pl.pjatk.MovieService.model.Movie;

@Service
public class MovieService {

  private static final List<Movie> movieList = List
      .of(new Movie(1L, "Sample name"), new Movie(2L, "sample name two"));

  public List<Movie> getAllMovies() {

    return movieList;
  }

  public Movie getMovieById(Long id) {

    for (Movie movie : movieList) {

      if (movie.getId().equals(id)) {
        return movie;
      }
    }

    return null;
  }


  public void addMovie(Movie movie) {
  }

  public void deleteById(Long id) {

  }

  public void updateMovieById(Long id, Movie movie) {
  }
}
