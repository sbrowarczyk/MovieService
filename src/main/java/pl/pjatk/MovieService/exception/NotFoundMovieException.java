package pl.pjatk.MovieService.exception;

public class NotFoundMovieException extends Exception {


  public NotFoundMovieException(String id) {
    super("Not found movie with id:" + id);
  }

}
