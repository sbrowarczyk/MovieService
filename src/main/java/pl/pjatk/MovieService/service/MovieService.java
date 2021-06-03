package pl.pjatk.MovieService.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import pl.pjatk.MovieService.model.Movie;
import pl.pjatk.MovieService.repository.MovieRepository;

@Service
public class MovieService {

  private final MovieRepository movieRepository;

  public MovieService(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  public List<Movie> getAllMovies() {

    return movieRepository.findAll();
  }

  public Optional<Movie> getMovieById(Long id) {

    return movieRepository.findById(id);
  }

  public Movie addMovie(Movie movie) {

    return movieRepository.save(movie);
  }

  public void deleteById(Long id) {

    movieRepository.deleteById(id);
  }

  public void updateMovieById(Long id, Movie movie) {

    Movie movieToUpdate = movieRepository.findById(id).get();

    movieToUpdate.setName(movie.getName());
    movieToUpdate.setCategory(movie.getCategory());

    movieRepository.save(movie);
  }

  public void changeIsAvailableToTrue(Long id) {

    Movie movie = movieRepository.findById(id).get();

    movie.setAvailable(true);

    movieRepository.save(movie);
  }
}
