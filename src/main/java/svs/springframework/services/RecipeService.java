package svs.springframework.services;

import svs.springframework.domain.Recipe;

import java.util.Set;

/**
 * @author BAD
 * @version 24/02/19
 */
public interface RecipeService {

    Set<Recipe> getRecipes();
}
