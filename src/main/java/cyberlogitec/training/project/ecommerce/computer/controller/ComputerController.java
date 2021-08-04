package cyberlogitec.training.project.ecommerce.computer.controller;

import cyberlogitec.training.project.ecommerce.common.ResponseObject;
import cyberlogitec.training.project.ecommerce.computer.model.Computer;
import cyberlogitec.training.project.ecommerce.computer.model.TypeComputer;
import cyberlogitec.training.project.ecommerce.computer.service.ComputerService;
import cyberlogitec.training.project.ecommerce.dto.computer.CreateComputerDto;
import cyberlogitec.training.project.ecommerce.dto.computer.CreateTypeComputerDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/computer", produces = "application/json;charset=UTF-8")
public class ComputerController {
    private ComputerService service;

    @GetMapping("")
    public ResponseEntity<Object> findAll(){
        List<Computer> list = service.findAll();
        if(list.isEmpty())
            return ResponseObject.getResponse("There is no data", HttpStatus.OK);
        return ResponseObject.getResponse(list, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Object> searchByName(@RequestParam("name") String name){
        List<CreateComputerDto> list = service.searchByName(name);
        if(list.isEmpty())
            return ResponseObject.getResponse("There is no data", HttpStatus.OK);
        return ResponseObject.getResponse(list, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> addNewType(@Valid @RequestBody CreateComputerDto dto,
                                             BindingResult errors){
        if(errors.hasErrors())
            return ResponseObject.getResponse(errors, HttpStatus.BAD_REQUEST);
        Computer newComputer = service.save(dto);

        return ResponseObject.getResponse(newComputer, HttpStatus.OK);

    }


}
