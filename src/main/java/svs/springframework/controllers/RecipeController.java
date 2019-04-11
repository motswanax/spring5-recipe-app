package svs.springframework.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import svs.springframework.commands.RecipeCommand;
import svs.springframework.services.RecipeService;

/**
 * @author baike
 * 07/04/2019
 */
@Slf4j
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
    @GetMapping
    @RequestMapping("/recipe/{id}/show") // pick the id value from the URL
    public String showById(@PathVariable String id, Model model){

        model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));

        return "recipe/show";
    }

    /**
     * This creates a new Recipe and returns the recipeform view for the creation of a new recipe
     * @param model - the model
     * @return - the recipe form
     */
    @GetMapping
    @RequestMapping("recipe/new")
    public String newRecipe(Model model){
        model.addAttribute("recipe", new RecipeCommand());

        return "recipe/recipeform";
    }

    @GetMapping
    @RequestMapping("/recipe/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
        return "recipe/recipeform";
    }

    /**
     * This saves or updates the recipe and redirects to the show view displaying the recipe
     * the @ModelAttribute binds the form parameters to the RecipeCommand properties
     * @param command - the RecipeCommand object
     * @return - the view of the just saved recipe
     */
    @PostMapping
    @RequestMapping("recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command) {
        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);

        return "redirect:/recipe/" + savedCommand.getId() + "/show";
    }

    /**
     * Deletes the recipe with the given ID and returns a redirect to the home view
     * @param id - the id
     * @return - the home view
     */
    @GetMapping
    @RequestMapping("recipe/{id}/delete")
    public String deleteById(@PathVariable String id){

        log.debug("Deleting id: " + id);

        recipeService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }
}