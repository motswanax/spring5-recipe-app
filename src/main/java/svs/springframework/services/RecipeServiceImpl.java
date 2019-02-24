package svs.springframework.services;

import org.springframework.stereotype.Service;
import svs.springframework.domain.Recipe;
import svs.springframework.repositories.RecipeRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * @author BAD
 * @version 24/02/19
 */
@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipeSet = new HashSet<>();

        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }
}
