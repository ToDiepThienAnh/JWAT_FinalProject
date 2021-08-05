package cyberlogitec.training.project.ecommerce.computer.service;

import cyberlogitec.training.project.ecommerce.common.IGenericService;
import cyberlogitec.training.project.ecommerce.computer.model.Computer;
import cyberlogitec.training.project.ecommerce.dto.computer.ComputerDto;
import cyberlogitec.training.project.ecommerce.dto.computer.CreateComputerDto;

import java.util.List;

public interface ComputerService extends IGenericService<Computer, Long> {
    public Computer save(CreateComputerDto computer);

    public List<ComputerDto> searchByName(String name);
}
