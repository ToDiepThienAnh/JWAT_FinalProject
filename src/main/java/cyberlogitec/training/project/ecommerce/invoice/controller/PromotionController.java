package cyberlogitec.training.project.ecommerce.invoice.controller;

import cyberlogitec.training.project.ecommerce.common.ResponseObject;
import cyberlogitec.training.project.ecommerce.dto.computer.CreateCommentDto;
import cyberlogitec.training.project.ecommerce.dto.invoice.CreatePromotionDto;
import cyberlogitec.training.project.ecommerce.invoice.model.Promotion;
import cyberlogitec.training.project.ecommerce.invoice.service.PromotionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/promotion")
@AllArgsConstructor
public class PromotionController {
    private PromotionService service;

    @GetMapping("")
    public ResponseEntity<Object> findAllPromotions(){
        List<Promotion> list = service.findAll();
        if(list.isEmpty())
            return ResponseObject.getResponse("There is no data", HttpStatus.OK);
        return ResponseObject.getResponse(list, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> add(@Valid @RequestBody CreatePromotionDto dto,
                                      BindingResult errors){
        if(errors.hasErrors())
            return ResponseObject.getResponse(errors, HttpStatus.BAD_REQUEST);
        Promotion promotion = service.save(dto);
        return ResponseObject.getResponse(promotion, HttpStatus.CREATED);
    }

    @PutMapping("/{code}")
    public ResponseEntity<Object> update(@Valid @RequestBody CreatePromotionDto dto,
                                      BindingResult errors,
                                         @PathVariable("code") String code){
        if(code == null || code.equals(""))
            return ResponseObject.getResponse("code is invalid", HttpStatus.BAD_REQUEST);
        if(errors.hasErrors())
            return ResponseObject.getResponse(errors, HttpStatus.BAD_REQUEST);
        Promotion promotion = service.update(dto, code);
        if(promotion == null)
            return ResponseObject.getResponse("code is invalid", HttpStatus.BAD_REQUEST);
        return ResponseObject.getResponse(promotion, HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Object> deleteByCode(@PathVariable("code") String code){
        if(code == null || code.equals(""))
            return ResponseObject.getResponse("code is invalid", HttpStatus.BAD_REQUEST);
        Promotion promotion = service.deleteByCode(code);
        if(promotion == null)
            return ResponseObject.getResponse("code is invalid", HttpStatus.BAD_REQUEST);
        return ResponseObject.getResponse(promotion, HttpStatus.OK);
    }
}
