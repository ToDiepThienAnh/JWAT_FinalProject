package cyberlogitec.training.project.ecommerce.mybatis.mapper;

import cyberlogitec.training.project.ecommerce.invoice.model.InvoiceDetail;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface IInvoiceDetailMapper {

    @Update("insert into ecommerce_invoice_computer_detail (computer_id, invoice_id, amount) values" +
            "(#{i.computer_id}" +
            "#{i.invoice_id}" +
            "#{i.amount})" )
    public void addInoviceDetail(@Param("i") InvoiceDetail invoiceDetail);
}
