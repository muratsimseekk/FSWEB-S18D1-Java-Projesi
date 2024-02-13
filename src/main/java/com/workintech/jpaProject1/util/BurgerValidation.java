package com.workintech.jpaProject1.util;

import com.workintech.jpaProject1.exceptions.BurgerException;
import org.springframework.http.HttpStatus;

public class BurgerValidation {

    public static void checkName(String name){
        if (name == null || name.isEmpty()){
            throw new BurgerException("Burger name is null or empty!", HttpStatus.BAD_REQUEST);
        }
    }

}
