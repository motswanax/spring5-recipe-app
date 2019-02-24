package svs.springframework.repositories;

import org.springframework.data.repository.CrudRepository;
import svs.springframework.domain.Recipe;

/**
 * @author BAD
 * @version 24/02/19
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
