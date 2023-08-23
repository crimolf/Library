package it.fivenet.playground.library;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class LibroNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(LibroNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String libroNotFoundHandler(LibroNotFoundException ex) {
        return ex.getMessage();
    }
}