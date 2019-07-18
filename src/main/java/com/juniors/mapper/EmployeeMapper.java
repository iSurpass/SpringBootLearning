package com.juniors.mapper;

import com.juniors.model.Employee;
import org.apache.ibatis.annotations.Mapper;

//@Mapper或者@MapperScan将接口扫描装配到容器中
@Mapper
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);
}
