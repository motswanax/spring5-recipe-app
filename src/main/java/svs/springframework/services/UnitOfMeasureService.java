package svs.springframework.services;

import svs.springframework.commands.UnitOfMeasureCommand;

import java.util.Set;

/**
 * @author baike
 * 12/02/2019
 */
public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUoms();
}