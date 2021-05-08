package pl.pjatk.MovieService.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import pl.pjatk.MovieService.model.Movie;

@Service
public class MovieService {


  public List<Movie> getAllMovies() {
    return new ArrayList<>();
  }

  public Movie getMoviesById(Long id) {
    return new Movie();
  }


}
