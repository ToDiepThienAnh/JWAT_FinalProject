package cyberlogitec.training.project.ecommerce.mybatis.invoice;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class InvoiceSqlProvider {
    public String getRevenueOfThisMonth(){
        return new SQL(){
            {
                SELECT("sum(price) as revenue");
                SELECT("extract(month from  now()) as month");
                FROM("ecommerce_invoice");
                WHERE("extract(month from  now())" +
                        " = " +
                        "extract(month from created_at)");
                GROUP_BY("extract(month from  now())");
            }
        }.toString();
    }

    public String getComputerIsSelled(){
        return new SQL(){
            {
                SELECT("sum(d.amount) as amount");
                SELECT("c.name");
                SELECT("c.price");
                FROM("ecommerce_invoice as i");
                FROM("ecommerce_computer as c");
                FROM("ecommerce_invoice_computer_detail as d");
                WHERE("i.id = d.invoice_id");
                AND();
                WHERE("d.computer_id = c.id");
                GROUP_BY("c.name");
                GROUP_BY("c.price");
            }
        }.toString();
    }
}
