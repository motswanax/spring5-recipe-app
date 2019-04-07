package svs.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import svs.springframework.services.RecipeService;

/**
 * @author baike
 * 07/04/2019
 */
@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    /**
     * Returns a path to the page displaying the recipe with the given ID.
     * By convention path variable name should have same name as the argument in the URL
     * @param id - the recipe ID
     * @param model - the model object
     * @return - the recipe path
     */
    @RequestMapping("/recipe/show/{id}") // pick the id value from the URL
    public String showById(@PathVariable String id, Model model){

        model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));

        return "recipe/show";
    }
}