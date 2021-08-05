package cyberlogitec.training.project.ecommerce.invoice.service;

import cyberlogitec.training.project.ecommerce.common.GenericService;
import cyberlogitec.training.project.ecommerce.computer.model.Computer;
import cyberlogitec.training.project.ecommerce.computer.repository.ComputerRepository;
import cyberlogitec.training.project.ecommerce.dto.invoice.ComputerAmount;
import cyberlogitec.training.project.ecommerce.dto.invoice.PurchasedComputer;
import cyberlogitec.training.project.ecommerce.invoice.model.Invoice;
import cyberlogitec.training.project.ecommerce.invoice.model.InvoiceDetail;
import cyberlogitec.training.project.ecommerce.invoice.repository.InvoiceDetailRepository;
import cyberlogitec.training.project.ecommerce.invoice.repository.InvoiceRepository;
import cyberlogitec.training.project.ecommerce.invoice.utils.InvoiceDetailId;
import cyberlogitec.training.project.ecommerce.invoice.utils.InvoiceStatus;
import cyberlogitec.training.project.ecommerce.mybatis.mapper.IInvoiceDetailMapper;
import cyberlogitec.training.project.ecommerce.user.model.User;
import cyberlogitec.training.project.ecommerce.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class InvoiceServiceImpl extends GenericService<Invoice, Long> implements InvoiceService {
    private ComputerRepository computerRepository;
    private InvoiceRepository invoiceRepository;
    private UserRepository userRepository;
    private IInvoiceDetailMapper iInvoiceDetailMapper;
    private InvoiceDetailRepository invoiceDetailRepository;

    @Override
    public Invoice save(PurchasedComputer computers) {
        Invoice invoice = new Invoice();
        invoice.setCode(RandomStringUtils.randomAlphanumeric(10));
        invoice.setStatus(InvoiceStatus.PENDING);
        Optional<User> buyer = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if(buyer.isPresent())
            invoice.setUser(buyer.get());
        BigDecimal invoicePrice = BigDecimal.ZERO;
        for (ComputerAmount computer : computers.getComputers()){
            Computer purchasedComputer = computerRepository.findByName(computer.getName());
            BigDecimal priceDiscount = purchasedComputer.getPrice().multiply(BigDecimal.valueOf(purchasedComputer.getDiscount()));
            invoicePrice = invoicePrice.add(purchasedComputer.getPrice()
                    .subtract(priceDiscount)
                    )
                    .multiply(new BigDecimal(computer.getAmount()));
        }
        if(invoicePrice.compareTo(new BigDecimal("20000000")) != 1){
            invoicePrice = invoicePrice.add(computers.getFeeShip());
            invoice.setFeeShip(new BigDecimal("20000000"));
        }
        else {
            invoicePrice = invoicePrice.subtract(computers.getFeeShip());
            invoice.setFeeShip(BigDecimal.ZERO);
        }
        invoice.setPromotion(null);
        invoice.setPrice(invoicePrice);
        Set<InvoiceDetail> invoiceDetails = new HashSet<>();
        Invoice invoiceAdded = invoiceRepository.save(invoice);
        for (ComputerAmount computer : computers.getComputers()){
            Computer purchasedComputer = computerRepository.findByName(computer.getName());
            InvoiceDetail invoiceDetail = new InvoiceDetail();
            InvoiceDetailId invoiceDetailId = new InvoiceDetailId();
            invoiceDetailId.setInvoiceId(invoiceAdded.getId());
            invoiceDetailId.setComputerId(purchasedComputer.getId());
            invoiceDetail.setId(invoiceDetailId);
            invoiceDetail.setAmount(computer.getAmount());
            invoiceDetail.setInvoice(invoiceAdded);
            invoiceDetail.setComputer(purchasedComputer);
            invoiceDetailRepository.save(invoiceDetail);
        }
        return invoiceAdded;
    }
}
