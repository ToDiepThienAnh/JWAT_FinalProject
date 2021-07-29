package cyberlogitec.training.project.ecommerce.mybatis.user;

import org.apache.ibatis.jdbc.SQL;

public class RoleSqlProvider {
    public String findAllRole(){
        return new SQL(){
            {
                SELECT("NAME");
                SELECT("DESCRIPTION");
                FROM("ECOMMERCE_ROLE");
            }
        }.toString();
    }
}
