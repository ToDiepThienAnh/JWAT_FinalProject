package cyberlogitec.training.project.ecommerce.mybatis.mapper;

import cyberlogitec.training.project.ecommerce.dto.computer.CreateComputerDto;
import cyberlogitec.training.project.ecommerce.mybatis.computer.ComputerSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface IComputerModuleMapper {

    @SelectProvider(type = ComputerSqlProvider.class, method = "searchByName")
    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "code", column = "code"),
            @Result(property = "avatar", column = "avatar"),
            @Result(property = "cpu", column = "cpu"),
            @Result(property = "memory", column = "memory"),
            @Result(property = "name", column = "name"),
            @Result(property = "screen", column = "screen"),
            @Result(property = "pin", column = "pin"),
            @Result(property = "graphicsCard", column = "graphics_card"),
            @Result(property = "status", column = "status"),
            @Result(property = "price", column = "price"),
            @Result(property = "typeName", column = "type_name"),
    })
    public List<CreateComputerDto> searchComputerByName(@Param("name") String name);
}
