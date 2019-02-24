package svs.springframework.repositories;

import org.springframework.data.repository.CrudRepository;
import svs.springframework.domain.UnitOfMeasure;

import java.util.Optional;

/**
 * @author BAD
 * @version 24/02/19
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByDescription(String description);
}
