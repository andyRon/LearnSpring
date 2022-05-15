package com.andyron.tacocloud.data;

import com.andyron.tacocloud.pojo.Ingredient;

public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Ingredient findOne(String id);

    Ingredient save(Ingredient ingredient);
}
