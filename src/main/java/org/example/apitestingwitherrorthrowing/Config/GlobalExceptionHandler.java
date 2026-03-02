package org.example.apitestingwitherrorthrowing.Config;


import org.example.apitestingwitherrorthrowing.Dtos.ErrorMessage;
import org.example.apitestingwitherrorthrowing.Exceptions.BusinessException;
import org.example.apitestingwitherrorthrowing.Exceptions.SongNotFoundException;
import org.example.apitestingwitherrorthrowing.Exceptions.UserException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorMessage> handleBusinessException(final BusinessException ex) {
        return ResponseEntity.badRequest().body(new ErrorMessage("business error", ex.getMessage()));
    }

    @ExceptionHandler(SongNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleSongNotFoundException(final SongNotFoundException ex) {
        return ResponseEntity.badRequest().body(new ErrorMessage("there aren't any songs", ex.getMessage()));
    }

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorMessage> handleUserException(final UserException ex) {
        return ResponseEntity.badRequest().body(new ErrorMessage("the user already exists", ex.getMessage()));
    }


}
