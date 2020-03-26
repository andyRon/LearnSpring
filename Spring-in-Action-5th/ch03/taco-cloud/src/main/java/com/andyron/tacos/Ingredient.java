package com.andyron.tacos;

import lombok.Data;
import lombok.RequiredArgsConstructor;


/**
 * 配料
 * @author Andy Ron
 */
@Data
@RequiredArgsConstructor
public class Ingredient {

    private final String id;
    private final String name;
    private final Type type;

    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
