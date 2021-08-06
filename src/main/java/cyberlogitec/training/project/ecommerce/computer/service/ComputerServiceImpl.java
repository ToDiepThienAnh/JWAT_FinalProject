package cyberlogitec.training.project.ecommerce.computer.service;

import cyberlogitec.training.project.ecommerce.common.GenericService;
import cyberlogitec.training.project.ecommerce.computer.model.Computer;
import cyberlogitec.training.project.ecommerce.computer.model.TypeComputer;
import cyberlogitec.training.project.ecommerce.computer.repository.ComputerRepository;
import cyberlogitec.training.project.ecommerce.computer.repository.TypeComputerRepository;
import cyberlogitec.training.project.ecommerce.dto.computer.ComputerDto;
import cyberlogitec.training.project.ecommerce.dto.computer.CreateComputerDto;
import cyberlogitec.training.project.ecommerce.mybatis.mapper.IComputerModuleMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ComputerServiceImpl extends GenericService<Computer, Long> implements ComputerService {
    private ComputerRepository repository;
    private TypeComputerRepository typeComputerRepository;
    private IComputerModuleMapper iComputerModuleMapper;

    @Override
    public Computer save(CreateComputerDto computer) {
        Computer newComputer = new Computer();
        newComputer.setName(computer.getName());
        newComputer.setCode(computer.getCode());
        newComputer.setAvatar(computer.getAvatar());
        newComputer.setCpu(computer.getCpu());
        newComputer.setMemory(computer.getMemory());
        newComputer.setScreen(computer.getScreen());
        newComputer.setPin(computer.getPin());
        newComputer.setGraphicsCard(computer.getGraphicsCard());
        newComputer.setStatus(computer.getStatus());
        newComputer.setPrice(computer.getPrice());
        newComputer.setDiscount(computer.getDiscount());
        TypeComputer type = typeComputerRepository.findByName(computer.getTypeName());
        newComputer.setType(type);
        return repository.save(newComputer);
    }

    @Override
    public Computer update(CreateComputerDto computer, String code) {
        Computer newComputer = repository.findByCode(code);
        newComputer.setName(computer.getName());
        newComputer.setCode(computer.getCode());
        newComputer.setAvatar(computer.getAvatar());
        newComputer.setCpu(computer.getCpu());
        newComputer.setMemory(computer.getMemory());
        newComputer.setScreen(computer.getScreen());
        newComputer.setPin(computer.getPin());
        newComputer.setGraphicsCard(computer.getGraphicsCard());
        newComputer.setStatus(computer.getStatus());
        newComputer.setPrice(computer.getPrice());
        newComputer.setDiscount(computer.getDiscount());
        TypeComputer type = typeComputerRepository.findByName(computer.getTypeName());
        newComputer.setType(type);
        return repository.save(newComputer);
    }

    @Override
    public void deleteByCode(String code) {
        repository.deleteByCode(code);
    }

    @Override
    public List<ComputerDto> searchByName(String name) {

        return iComputerModuleMapper.searchComputerByName(name);
    }
}
