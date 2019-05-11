package svs.springframework.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import svs.springframework.commands.RecipeCommand;
import svs.springframework.converters.RecipeCommandToRecipe;
import svs.springframework.converters.RecipeToRecipeCommand;
import svs.springframework.domain.Recipe;
import svs.springframework.exceptions.NotFoundException;
import svs.springframework.repositories.RecipeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author BAD
 * @version 24/02/19
 */
@Slf4j // project lombok logging
@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("I'm in the service.");
        Set<Recipe> recipeSet = new HashSet<>();

        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }

    @Override
    public Recipe findById(Long l) {

        // Optional from spring data (CrudRepository via RecipeResository)
        Optional<Recipe> recipeOptional = recipeRepository.findById(l);

        // check to see if we get a value back
        if (!recipeOptional.isPresent()) {
            throw new NotFoundException("Recipe not found for ID value: " + l.toString());
        }

        // this goes to the RecipeController's showById
        return recipeOptional.get();
    }

    /**
     * Finds a recipe with the given ID in the database, converts it to a RecipeCommand and returns it.
     * @param l - the recipe Id
     * @return - RecipeCommand object
     */
    @Override
    @Transactional // because we're converting outside the scope
    public RecipeCommand findCommandById(Long l) {
        return recipeToRecipeCommand.convert(findById(l));
    }

    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand command) {
        Recipe detachedRecipe = recipeCommandToRecipe.convert(command);

        Recipe savedRecipe = recipeRepository.save(detachedRecipe);
        log.debug("Saved RecipeId: " + savedRecipe.getId());
        return recipeToRecipeCommand.convert(savedRecipe);
    }

    @Override
    public void deleteById(Long idToDelete) {
        recipeRepository.deleteById(idToDelete);
    }
}
