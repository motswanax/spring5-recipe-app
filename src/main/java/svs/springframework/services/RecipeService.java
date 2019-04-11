package svs.springframework.services;

import svs.springframework.commands.RecipeCommand;
import svs.springframework.domain.Recipe;

import java.util.Set;

/**
 * @author BAD
 * @version 24/02/19
 */
public interface RecipeService {

    Set<Recipe> getRecipes();
    RecipeCommand findCommandById(Long l);
    Recipe findById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    void deleteById(Long idToDelete);
}
