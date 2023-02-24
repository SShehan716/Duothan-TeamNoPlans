package com.NoPlan.Phama.adviser;


import com.NoPlan.Phama.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWiderExceptionHandler {
    @ExceptionHandler(ClassNotFoundException.class)
    public ResponseEntity<StandardResponse> handleNotFoundExceptions(ClassNotFoundException e){
        return new ResponseEntity<>(
                new StandardResponse(
                        404,
                        e.getMessage()+" was occurred!",e.getMessage()
                ), HttpStatus.NOT_FOUND
        );

    }
}
