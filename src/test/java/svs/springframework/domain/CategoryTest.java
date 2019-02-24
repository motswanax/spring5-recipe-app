package svs.springframework.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author BAD
 * @version 24/02/19
 */
public class CategoryTest {

    Category category;

    /**
     * Create a new Category object before each method is executed.
     */
    @Before
    public void setUp()  {
        category = new Category();
    }

    @Test
    public void getId() throws Exception {
        Long idValue = 4L;
        category.setId(idValue);

        assertEquals(idValue, category.getId());
    }

    @Test
    public void getDescription() throws Exception {
    }

    @Test
    public void getRecipes() throws Exception {
    }
}