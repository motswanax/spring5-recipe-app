package svs.springframework.services;

import svs.springframework.commands.IngredientCommand;

/**
 * @author baike
 * 12/02/2019
 */
public interface IngredientService {
    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
}
