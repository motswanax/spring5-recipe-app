package svs.springframework.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import svs.springframework.commands.UnitOfMeasureCommand;
import svs.springframework.domain.UnitOfMeasure;

/**
 * @author baike
 * 10/04/2019
 * This converts from the type of the domain object to the command object and vice-versa.
 */
@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {

    /**
     * This takes an instance of UnitOfMeasureCommand and converts then returns an instance of UnitOfMeasure.
     * We use @Synchronized because Spring does not guarantee thread safety when run in a multithreaded environment.
     * @param source - the source type
     * @return - the converted type
     */
    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand source) {
        if (source == null) {
            return null;
        }

        final UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(source.getId());
        uom.setDescription(source.getDescription());
        return uom;
    }
}