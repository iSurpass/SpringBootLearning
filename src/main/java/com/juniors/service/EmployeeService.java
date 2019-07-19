package com.juniors.service;

import com.juniors.mapper.EmployeeMapper;
import com.juniors.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
/**
 * @author Juniors
 */
@Service
//抽取缓存的公共配置
@CacheConfig(cacheNames = "myKeyGenerator")
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
    @Cacheable(keyGenerator = "myKeyGenerator",value = {"emp"},key = "#id",condition = "#a0 > 1",unless = "#result == null ")
    public Employee getEmployee(Integer id){

        System.out.println("1111111");
        Employee employee = employeeMapper.getEmpById(id);
        return employee;
    }

    /**
     * @CachePut:既调用方法，有更新数据
     * 修改了数据库的某个数据，同时更新
     * @param employee
     * @return
     */
    @CachePut(keyGenerator = "myKeyGenerator",value = {"emp"},key = "#result.id")
    public Employee updateEmp(Employee employee){

        System.out.println("222222");
        employeeMapper.updateEmp(employee);
        return employee;
    }

    /**
     * @CacheEvict:缓存数据清除
     * allEntries = true ：指定清除这个缓存所有的数据
     * beforeInvocaion = false；缓存清除是否是否在方法执行之前执行
     *          默认代表是在方法执行之后执行，如果出现异常缓存就不会清除
     * @param id
     */
    @CacheEvict(value = "emp",key = "#id")
    public void deleteEmp(Integer id){

        employeeMapper.deleteEmById(id);
    }

    // @Caching 定义复杂的缓存规则
    @Caching(
            cacheable = {
                    @Cacheable(/*value="emp",*/key = "#lastName")
            },
            put = {
                    @CachePut(/*value="emp",*/key = "#result.id"),
                    @CachePut(/*value="emp",*/key = "#result.email")
            }
    )
    public Employee getEmpByLastName(String lastName){
        return employeeMapper.getEmpByLastName(lastName);
    }

}
