package com.andyron.tacos.data;

import com.andyron.tacos.Ingredient;

/**
 * @author Andy Ron
 */
public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Ingredient findOne(String id);

    Ingredient save(Ingredient ingredient);


}
