package svs.springframework.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * @author BAD
 * @version 23/02/19
 */
@Data
@EqualsAndHashCode(exclude = {"recipe"}) // override this annotation to prevent StackOverflowError
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne // no cascade - Recipe will remain if this is deleted
    private Recipe recipe;

    @Lob
    private String recipeNotes;

    protected boolean canEqual(final Object other) {
        return other instanceof Notes;
    }
}