package cyberlogitec.training.project.ecommerce.mybatis.user;

import org.apache.ibatis.jdbc.SQL;

public class UserSqlProvider {
    public String getUserWithRole(){
        return new SQL(){
            {
                SELECT("*");
                FROM("ecommerce_user as u");
                FROM("ecommerce_role as r");
                WHERE("u.role_name = r.name");
            }
        }.toString();
    }
}
