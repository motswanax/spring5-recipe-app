package svs.springframework.converters;

import org.junit.Before;
import org.junit.Test;
import svs.springframework.commands.UnitOfMeasureCommand;
import svs.springframework.domain.UnitOfMeasure;

import static org.junit.Assert.*;

/**
 * @author baike
 * 10/04/2019
 */
public class UnitOfMeasureCommandToUnitOfMeasureTest {

    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = new Long(1L);

    UnitOfMeasureCommandToUnitOfMeasure converter;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureCommandToUnitOfMeasure();

    }

    /**
     * Test if the converter takes in nulls and returns null.
     * @throws Exception
     */
    @Test
    public void testNullParamter() throws Exception {
        assertNull(converter.convert(null));
    }

    /**
     * Test if the converter accepts an empty object withour causing a NullPointerException
     * @throws Exception
     */
    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new UnitOfMeasureCommand()));
    }

    /**
     * Test if the values are being set properly.
     * @throws Exception
     */
    @Test
    public void convert() throws Exception {
        //given
        UnitOfMeasureCommand command = new UnitOfMeasureCommand();
        command.setId(LONG_VALUE);
        command.setDescription(DESCRIPTION);

        //when
        UnitOfMeasure uom = converter.convert(command);

        //then
        assertNotNull(uom);
        assertEquals(LONG_VALUE, uom.getId());
        assertEquals(DESCRIPTION, uom.getDescription());

    }

}