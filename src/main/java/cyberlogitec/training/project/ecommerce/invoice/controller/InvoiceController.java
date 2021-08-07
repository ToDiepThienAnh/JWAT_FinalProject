package cyberlogitec.training.project.ecommerce.invoice.controller;

import cyberlogitec.training.project.ecommerce.common.ResponseObject;
import cyberlogitec.training.project.ecommerce.dto.invoice.PurchasedComputer;
import cyberlogitec.training.project.ecommerce.dto.invoice.UpdateStatusInvoice;
import cyberlogitec.training.project.ecommerce.invoice.model.Invoice;
import cyberlogitec.training.project.ecommerce.invoice.service.InvoiceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/invoice")
@AllArgsConstructor
public class InvoiceController {
    private InvoiceService service;

    @GetMapping("")
    public ResponseEntity<Object> findAll(){
        List<Invoice> list = service.findAll();

        if(list.isEmpty())
            return ResponseObject.getResponse("There is no data", HttpStatus.OK);
        return ResponseObject.getResponse(list, HttpStatus.OK);
    }

    @PostMapping("/purchase")
    public ResponseEntity<Object> purchaseComputer(@Valid @RequestBody PurchasedComputer computers,
                                                   BindingResult errors){
        if(errors.hasErrors())
            return ResponseObject.getResponse(errors, HttpStatus.BAD_REQUEST);
        Invoice invoice = service.save(computers);
        return ResponseObject.getResponse(invoice, HttpStatus.CREATED);
    }

    @PutMapping("/confirm-sent")
    public ResponseEntity<Object> confirmSentInvoice(@Valid @RequestBody UpdateStatusInvoice dto,
                                                     BindingResult errors){
        if(errors.hasErrors())
            return ResponseObject.getResponse(errors, HttpStatus.BAD_REQUEST);
        Invoice invoice = service.confirmSentInvoice(dto);
        if(invoice == null)
            return ResponseObject.getResponse("invoice code is invalid", HttpStatus.BAD_REQUEST);
        return ResponseObject.getResponse(invoice, HttpStatus.OK);
    }

    @DeleteMapping("/confirm-cancel")
    public ResponseEntity<Object> confirmCancelInvoice(@Valid @RequestBody UpdateStatusInvoice dto,
                                                       BindingResult errors){
        if(errors.hasErrors())
            return ResponseObject.getResponse(errors, HttpStatus.BAD_REQUEST);
        Invoice invoice = null;
        try {
            invoice = service.confrimCancelInvoice(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseObject.getResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        if(invoice == null)
            return ResponseObject.getResponse("invoice code is invalid", HttpStatus.BAD_REQUEST);
        return ResponseObject.getResponse(invoice, HttpStatus.OK);
    }
}
