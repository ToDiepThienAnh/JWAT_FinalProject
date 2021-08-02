package cyberlogitec.training.project.ecommerce.computer.service;

import cyberlogitec.training.project.ecommerce.common.IGenericService;
import cyberlogitec.training.project.ecommerce.computer.model.Computer;
import cyberlogitec.training.project.ecommerce.dto.computer.CreateComputerDto;

public interface ComputerService extends IGenericService<Computer, Long> {
    public Computer save(CreateComputerDto computer);
}
