package pl.pjatk.MovieService.handlerexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.pjatk.MovieService.exception.NotFoundMovieException;

@RestControllerAdvice
public class HandlerException {


  @ExceptionHandler(NotFoundMovieException.class)
  public ResponseEntity<String> handleException(NotFoundMovieException notFoundMovieException) {
    String exceptionMessage =
        "Exception occurred on request. Exception message: " + notFoundMovieException.getMessage();

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionMessage);
  }


}
