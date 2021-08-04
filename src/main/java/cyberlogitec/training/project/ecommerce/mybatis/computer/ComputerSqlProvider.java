package cyberlogitec.training.project.ecommerce.mybatis.computer;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

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

    public String searchByName(@Param("name") String name){
        return new SQL(){
            {
                SELECT("*");
                FROM("ECOMMERCE_COMPUTER");
                WHERE("name like '%#{name}%' ");
            }
        }.toString();
    }
}
