package cyberlogitec.training.project.ecommerce.mybatis.mapper;

import cyberlogitec.training.project.ecommerce.dto.user.RoleDto;
import cyberlogitec.training.project.ecommerce.mybatis.user.RoleSqlProvider;
import cyberlogitec.training.project.ecommerce.mybatis.user.UserSqlProvider;
import cyberlogitec.training.project.ecommerce.user.model.Role;
import cyberlogitec.training.project.ecommerce.user.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IUserModuleMapper {

    @SelectProvider(type = RoleSqlProvider.class, method = "findAllRole")
    public List<RoleDto> findAllRole();

    @SelectProvider(type = UserSqlProvider.class, method = "getUserWithRole")
    @Results({
            @Result(property = "role.name", javaType = User.class, column = "r.name", one = @One),
            @Result(property = "role.description", javaType = User.class, column = "r.description", one = @One)
    })
    public List<User> getUserWithRole();
}
