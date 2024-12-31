package dev.aman.e_commerce_productservice.ControllerAdvice;

import dev.aman.e_commerce_productservice.Exceptions.ProductNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionalHandler {

    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<String> getProductNotFound(ProductNotFound e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
    }
}
