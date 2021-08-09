package cyberlogitec.training.project.ecommerce.computer.controller;

import cyberlogitec.training.project.ecommerce.common.ResponseObject;
import cyberlogitec.training.project.ecommerce.computer.model.TypeComputer;
import cyberlogitec.training.project.ecommerce.computer.service.TypeComputerService;
import cyberlogitec.training.project.ecommerce.dto.computer.CreateTypeComputerDto;
import cyberlogitec.training.project.ecommerce.utils.Domain;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("")
@AllArgsConstructor
public class TypeComputerController {
    private TypeComputerService service;

    @GetMapping(Domain.DOMAIN_USER+"/type-computer")
    public ResponseEntity<Object> findAll(){
        List<TypeComputer> list = service.findAll();
        if(list.isEmpty())
            return ResponseObject.getResponse("There is no data", HttpStatus.OK);
        return ResponseObject.getResponse(list, HttpStatus.OK);
    }

    @PostMapping(Domain.EMPLOYEE+"/type-computer")
    public ResponseEntity<Object> addNewType(@Valid @RequestBody CreateTypeComputerDto type,
                                             BindingResult errors){
        if(errors.hasErrors())
            return ResponseObject.getResponse(errors, HttpStatus.BAD_REQUEST);
        TypeComputer newType = service.save(type);

        return ResponseObject.getResponse(newType, HttpStatus.OK);

    }

    @PutMapping(Domain.DOMAIN_EMPLOYEE+"/type-computer/{type-name}")
    public ResponseEntity<Object> updateTypeComputer(@Valid @RequestBody CreateTypeComputerDto type,
                                                     BindingResult errors,
                                                     @PathVariable("type-name") String typeName){
        if(errors.hasErrors())
            return ResponseObject.getResponse(errors, HttpStatus.BAD_REQUEST);
        TypeComputer typeUpdate = service.update(type, typeName);
        return ResponseObject.getResponse(typeUpdate, HttpStatus.OK);
    }

    @DeleteMapping(Domain.DOMAIN_EMPLOYEE+"/type-computer/{type-name}")
    public ResponseEntity<Object> deleteByName(@PathVariable("type-name") String typeName){

        if(typeName == null){
            return ResponseObject.getResponse("typeName is invalid", HttpStatus.BAD_REQUEST);
        }
        TypeComputer typeDelete = service.deleteByName(typeName);
        return ResponseObject.getResponse(typeDelete, HttpStatus.OK);
    }
}
