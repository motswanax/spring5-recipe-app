package svs.springframework.repositories;

import org.springframework.data.repository.CrudRepository;
import svs.springframework.domain.Category;

/**
 * @author BAD
 * @version 24/02/19
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
