package cyberlogitec.training.project.ecommerce.computer.service;

import cyberlogitec.training.project.ecommerce.common.GenericService;
import cyberlogitec.training.project.ecommerce.computer.model.TypeComputer;
import cyberlogitec.training.project.ecommerce.computer.repository.TypeComputerRepository;
import cyberlogitec.training.project.ecommerce.dto.computer.CreateTypeComputerDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TypeComputerServiceImpl extends GenericService<TypeComputer, Long> implements TypeComputerService {
    private TypeComputerRepository repository;

    @Override
    public TypeComputer save(CreateTypeComputerDto type) {
        TypeComputer newType = new TypeComputer();
        newType.setName(type.getName());
        newType.setDescription(type.getDescription());

        return repository.save(newType);
    }

    @Override
    public TypeComputer update(CreateTypeComputerDto type, String typeName) {
        TypeComputer typeUpdate = repository.findByName(typeName);
        typeUpdate.setName(type.getName());
        typeUpdate.setDescription(type.getDescription());
        return repository.save(typeUpdate);
    }

    @Override
    public TypeComputer deleteByName(String typeName) {
        TypeComputer typeDelete = repository.findByName(typeName);
        if(typeDelete != null){
            repository.deleteByName(typeName);
            return typeDelete;
        }
        return null;

    }
}
