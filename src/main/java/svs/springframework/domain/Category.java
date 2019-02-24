package svs.springframework.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

/**
 * @author BAD
 * @version 24/02/19
 */
@Data // project lombok refactoring
@EqualsAndHashCode(exclude = {"recipes"}) // override this annotation to prevent StackOverflowError
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;

}
