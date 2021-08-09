package cyberlogitec.training.project.ecommerce.computer.controller;

import cyberlogitec.training.project.ecommerce.common.ResponseObject;
import cyberlogitec.training.project.ecommerce.computer.model.Computer;
import cyberlogitec.training.project.ecommerce.computer.model.TypeComputer;
import cyberlogitec.training.project.ecommerce.computer.service.ComputerService;
import cyberlogitec.training.project.ecommerce.dto.computer.ComputerDto;
import cyberlogitec.training.project.ecommerce.dto.computer.CreateComputerDto;
import cyberlogitec.training.project.ecommerce.dto.computer.CreateTypeComputerDto;
import cyberlogitec.training.project.ecommerce.utils.Domain;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "", produces = "application/json;charset=UTF-8")
public class ComputerController {
    private ComputerService service;

    @GetMapping(Domain.DOMAIN_USER+"/computer")
    public ResponseEntity<Object> findAll(){
        List<Computer> list = service.findAll();
        if(list.isEmpty())
            return ResponseObject.getResponse("There is no data", HttpStatus.OK);
        return ResponseObject.getResponse(list, HttpStatus.OK);
    }

    @GetMapping(Domain.DOMAIN_USER+"/computer/search")
    public ResponseEntity<Object> searchByName(@RequestParam("name") String name){
        List<ComputerDto> list = service.searchByName(name);
        if(list.isEmpty())
            return ResponseObject.getResponse("There is no data", HttpStatus.OK);
        return ResponseObject.getResponse(list, HttpStatus.OK);
    }

    @PostMapping(Domain.DOMAIN_EMPLOYEE+"/computer")
    public ResponseEntity<Object> add(@Valid @RequestBody CreateComputerDto dto,
                                             BindingResult errors){
        if(errors.hasErrors())
            return ResponseObject.getResponse(errors, HttpStatus.BAD_REQUEST);
        Computer newComputer = service.save(dto);

        return ResponseObject.getResponse(newComputer, HttpStatus.OK);

    }

    @PutMapping(Domain.DOMAIN_EMPLOYEE+"computer/{code}")
    public ResponseEntity<Object> update(@Valid @RequestBody CreateComputerDto dto,
                                             BindingResult errors,
                                         @PathVariable("code") String code){
        if(code == null || code.equals(""))
            return ResponseObject.getResponse("code can not be blank", HttpStatus.BAD_REQUEST);
        if(errors.hasErrors())
            return ResponseObject.getResponse(errors, HttpStatus.BAD_REQUEST);
        Computer newComputer = service.update(dto, code);

        return ResponseObject.getResponse(newComputer, HttpStatus.OK);

    }

    @DeleteMapping(Domain.DOMAIN_EMPLOYEE+"/computer/{code}")
    public ResponseEntity<Object> deleteByCode(
                                         BindingResult errors,
                                         @PathVariable("code") String code){
        if(code == null || code.equals(""))
            return ResponseObject.getResponse("code can not be blank", HttpStatus.BAD_REQUEST);
        service.deleteByCode(code);

        return ResponseObject.getResponse("delete successfully", HttpStatus.OK);

    }

}
