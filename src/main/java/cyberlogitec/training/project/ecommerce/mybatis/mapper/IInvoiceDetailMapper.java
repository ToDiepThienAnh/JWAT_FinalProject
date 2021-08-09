package cyberlogitec.training.project.ecommerce.mybatis.mapper;

import cyberlogitec.training.project.ecommerce.dto.invoice.ComputerIsSelledDto;
import cyberlogitec.training.project.ecommerce.dto.invoice.RevenueOfMonthDto;
import cyberlogitec.training.project.ecommerce.invoice.model.InvoiceDetail;
import cyberlogitec.training.project.ecommerce.mybatis.invoice.InvoiceSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
@Mapper
public interface IInvoiceDetailMapper {

    @Update("insert into ecommerce_invoice_computer_detail (computer_id, invoice_id, amount) values" +
            "(#{i.computer_id}" +
            "#{i.invoice_id}" +
            "#{i.amount})" )
    public void addInoviceDetail(@Param("i") InvoiceDetail invoiceDetail);


    @SelectProvider(type = InvoiceSqlProvider.class, method = "getRevenueOfThisMonth")
    @Results({
            @Result(property = "revenue", column = "revenue", javaType = BigDecimal.class),
            @Result(property = "month", column = "month", javaType = Integer.class)
    })
    public RevenueOfMonthDto getRevenueOfThisMonth();

    @SelectProvider(type = InvoiceSqlProvider.class, method = "getComputerIsSelled")
    @Results({
            @Result(property = "price", column = "price", javaType = BigDecimal.class)
    })
    public List<ComputerIsSelledDto> getComputerIsSelled();
}
