package cyberlogitec.training.project.ecommerce.mybatis.user;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class RoleSqlProvider {
    public String findByRoleName(@Param("roleName") String roleName){
        return new SQL(){
            {
                SELECT("*");
                FROM("ECOMMERCE_ROLE");
                WHERE("name = #{roleName}");
            }
        }.toString();
    }
}
