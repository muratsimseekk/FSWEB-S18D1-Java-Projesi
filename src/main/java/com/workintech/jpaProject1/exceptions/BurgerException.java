package com.workintech.jpaProject1.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public class BurgerException extends RuntimeException{

    private HttpStatus httpStatus;
    public BurgerException(String message,HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
