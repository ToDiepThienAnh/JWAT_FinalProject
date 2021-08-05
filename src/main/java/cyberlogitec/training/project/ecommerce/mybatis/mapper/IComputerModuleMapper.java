package cyberlogitec.training.project.ecommerce.mybatis.mapper;

import cyberlogitec.training.project.ecommerce.computer.model.Computer;
import cyberlogitec.training.project.ecommerce.computer.model.TypeComputer;
import cyberlogitec.training.project.ecommerce.dto.computer.ComputerDto;
import cyberlogitec.training.project.ecommerce.dto.computer.CreateComputerDto;
import cyberlogitec.training.project.ecommerce.dto.computer.CreateTypeComputerDto;
import cyberlogitec.training.project.ecommerce.mybatis.computer.ComputerSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface IComputerModuleMapper {

    @Select("select * from ecommerce_computer_type where name = #{name}")
    public CreateTypeComputerDto findByName(@Param("name") String name);

//    @SelectProvider(type = ComputerSqlProvider.class, method = "searchByName")
    @Select("select * from ecommerce_computer where lower(replace(cpu, ' ','')) like '%' || #{name} || '%'" )
    @Results({
            @Result(property = "type", column = "type_name", javaType = CreateTypeComputerDto.class,
                    one = @One(select = "findByName", fetchType = FetchType.LAZY))
    })
    public List<ComputerDto> searchComputerByName(@Param("name") String name);
}
