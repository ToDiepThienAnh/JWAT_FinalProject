package cyberlogitec.training.project.ecommerce.mybatis.mapper;

import cyberlogitec.training.project.ecommerce.dto.user.RoleDto;
import cyberlogitec.training.project.ecommerce.dto.user.UserWithRoleDto;
import cyberlogitec.training.project.ecommerce.mybatis.user.RoleSqlProvider;
import cyberlogitec.training.project.ecommerce.mybatis.user.UserSqlProvider;
import cyberlogitec.training.project.ecommerce.user.model.Role;
import cyberlogitec.training.project.ecommerce.user.model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
@Repository
public interface IUserModuleMapper {

    @SelectProvider(type = RoleSqlProvider.class, method = "findByRoleName")
    public List<RoleDto> findByRoleName(@Param("roleName") String roleName);

    @SelectProvider(type = UserSqlProvider.class, method = "getUserWithRole")
    @Results({
            @Result(property = "role", column = "role_name", javaType = RoleDto.class,
                    one = @One(select = "findByRoleName", fetchType = FetchType.LAZY))
    })
    public List<UserWithRoleDto> getUserWithRole();

}
