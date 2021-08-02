package cyberlogitec.training.project.ecommerce.computer.service;

import cyberlogitec.training.project.ecommerce.common.IGenericService;
import cyberlogitec.training.project.ecommerce.computer.model.TypeComputer;
import cyberlogitec.training.project.ecommerce.dto.computer.CreateTypeComputerDto;

public interface TypeComputerService extends IGenericService<TypeComputer, Long> {
    public TypeComputer save(CreateTypeComputerDto type);

    public TypeComputer update(CreateTypeComputerDto type, String typeName);

    public TypeComputer deleteByName(String typeName);

}
