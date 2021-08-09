package cyberlogitec.training.project.ecommerce.invoice.controller;

import cyberlogitec.training.project.ecommerce.common.ResponseObject;
import cyberlogitec.training.project.ecommerce.dto.invoice.ComputerIsSelledDto;
import cyberlogitec.training.project.ecommerce.dto.invoice.PurchasedComputer;
import cyberlogitec.training.project.ecommerce.dto.invoice.RevenueOfMonthDto;
import cyberlogitec.training.project.ecommerce.dto.invoice.UpdateStatusInvoice;
import cyberlogitec.training.project.ecommerce.invoice.model.Invoice;
import cyberlogitec.training.project.ecommerce.invoice.service.InvoiceService;
import cyberlogitec.training.project.ecommerce.utils.Domain;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("")
@AllArgsConstructor
public class InvoiceController {
    private InvoiceService service;

    @GetMapping(Domain.DOMAIN_EMPLOYEE+"/invoice")
    public ResponseEntity<Object> findAll(){
        List<Invoice> list = service.findAll();

        if(list.isEmpty())
            return ResponseObject.getResponse("There is no data", HttpStatus.OK);
        return ResponseObject.getResponse(list, HttpStatus.OK);
    }

    @PostMapping(Domain.DOMAIN_CUSTOMER+"/invoice/purchase")
    public ResponseEntity<Object> purchaseComputer(@Valid @RequestBody PurchasedComputer computers,
                                                   BindingResult errors){
        if(errors.hasErrors())
            return ResponseObject.getResponse(errors, HttpStatus.BAD_REQUEST);
        Invoice invoice = service.save(computers);
        return ResponseObject.getResponse(invoice, HttpStatus.CREATED);
    }

    @PutMapping(Domain.DOMAIN_EMPLOYEE+"/invoice/confirm-sent")
    public ResponseEntity<Object> confirmSentInvoice(@Valid @RequestBody UpdateStatusInvoice dto,
                                                     BindingResult errors){
        if(errors.hasErrors())
            return ResponseObject.getResponse(errors, HttpStatus.BAD_REQUEST);
        Invoice invoice = service.confirmSentInvoice(dto);
        if(invoice == null)
            return ResponseObject.getResponse("invoice code is invalid", HttpStatus.BAD_REQUEST);
        return ResponseObject.getResponse(invoice, HttpStatus.OK);
    }

    @DeleteMapping(Domain.DOMAIN_USER+"/invoice/confirm-cancel")
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

    @GetMapping(Domain.DOMAIN_EMPLOYEE+"/invoice/revenue")
    public ResponseEntity<Object> getComputerIsSelled(){
        List<ComputerIsSelledDto> list = service.getComputerIsSelled();

        if(list.isEmpty())
            return ResponseObject.getResponse("There is no data", HttpStatus.OK);
        return ResponseObject.getResponse(list, HttpStatus.OK);
    }

    @GetMapping(Domain.DOMAIN_EMPLOYEE+"/invoice/computer-selled")
    public ResponseEntity<Object> getRevenueOfThisMonth(){
        RevenueOfMonthDto list = service.getRevenueOfThisMonth();

        if(list == null)
            return ResponseObject.getResponse("There is no data", HttpStatus.OK);
        return ResponseObject.getResponse(list, HttpStatus.OK);
    }
}
