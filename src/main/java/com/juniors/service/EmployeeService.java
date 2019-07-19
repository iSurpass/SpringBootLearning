package com.juniors.service;

import com.juniors.mapper.EmployeeMapper;
import com.juniors.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
/**
 * @author Juniors
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 将方法运行结果进行缓存，
     * 以后再要相同的数据，直接从缓存中获取，
     * 不用调用方法
     *
     * @param id
     * @return
     */
    @Cacheable
    public Employee getEmployee(Integer id){

        Employee employee = employeeMapper.getEmpById(id);
        return employee;
    }
}
