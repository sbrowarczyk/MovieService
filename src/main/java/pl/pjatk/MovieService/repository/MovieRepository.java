package pl.pjatk.MovieService.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.MovieService.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

  @Override
  List<Movie> findAll();

  @Override
  Optional<Movie> findById(Long aLong);

  @Override
  <S extends Movie> S save(S s);

  @Override
  void deleteById(Long aLong);

}
