package com.juniors.mapper;

import com.juniors.model.Employee;
import org.apache.ibatis.annotations.*;

//@Mapper或者@MapperScan将接口扫描装配到容器中
@Mapper
public interface EmployeeMapper {

    @Select("SELECT * FROM employee WHERE id = #{id}")
    Employee getEmpById(Integer id);

    @Update("UPDATE employee SET lastname = #{lastname},email = #{email},gender = #{gender},d_id=#{dId}")
    void updateEmp(Employee employee);

    @Delete("DELETE * FROM employ WHERE id = #{id}")
    void deleteEmById(Integer id);

    @Insert("INSERT INTO employee(lastName,email,gender,d_id) VALUES(#{lastName},#{email},#{gender},#{dId}")
    void insertEmById(Employee employee);

    @Select("SELECT * FROM employee WHERE lastName = #{lastName}")
    Employee getEmpByLastName(String lastName);
}
