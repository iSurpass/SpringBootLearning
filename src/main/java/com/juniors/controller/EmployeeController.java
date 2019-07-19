package com.juniors.controller;

import com.juniors.mapper.EmployeeMapper;
import com.juniors.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Juniors
 */
@RestController
public class EmployeeController {

    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable("id")Integer id){

        Employee employee = employeeMapper.getEmpById(id);
        return employee;
    }
}
