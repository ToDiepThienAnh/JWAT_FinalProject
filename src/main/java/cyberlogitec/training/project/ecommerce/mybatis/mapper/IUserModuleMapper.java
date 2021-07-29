package cyberlogitec.training.project.ecommerce.mybatis.mapper;

import cyberlogitec.training.project.ecommerce.dto.user.RoleDto;
import cyberlogitec.training.project.ecommerce.mybatis.user.RoleSqlProvider;
import cyberlogitec.training.project.ecommerce.mybatis.user.UserSqlProvider;
import cyberlogitec.training.project.ecommerce.user.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IUserModuleMapper {

    @SelectProvider(type = RoleSqlProvider.class, method = "findAllRole")
    public List<RoleDto> findAllRole();
}
