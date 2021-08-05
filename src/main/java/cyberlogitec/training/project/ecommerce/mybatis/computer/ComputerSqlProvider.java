package cyberlogitec.training.project.ecommerce.mybatis.computer;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class ComputerSqlProvider {
    public String searchNameRamCardCpu(String name, String ram, String card, String cpu){
        return new SQL(){
            {
                SELECT("*");
                FROM("ECOMMERCE_COMPUTER");
                WHERE("name like _#{name}_");
                AND();
                WHERE("ram like _#{ram}_");
                AND();
                WHERE("card like _#{card}_");
                AND();
                WHERE("cpu like _#{cpu}_");
            }
        }.toString();
    }

    public String searchByName(Map<String, Object> para){
        return new SQL(){
            {
                SELECT("*");
                FROM("ECOMMERCE_COMPUTER");
                WHERE("lower(replace(name, ' ','')) like '%"
                +para.get("name")+"%' ");
            }
        }.toString();
//        return "select * from ecommerce_computer where (lower(replace(name, ' ','')) like '%"
//                + para.get("name") + "%') ";
    }
}
