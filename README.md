# SpringBootLearning
:bulb: Spring Boot 学习之旅~



##快速体验：
###	步骤：
	1. Springboot2 需要添加 @EnableCaching 注解
	2. 
		1. 开启基于注释的缓存 @EnableCaching
	3. 
		
	
	
###	CacheManager
		- 管理多个 Cache 组件的，对缓存的真正 CRUD 操作在组件中，每个缓存组件都有自己唯一一个名字
	@Cacheable 属性
		- cacheNames/value：指定缓存组件的名字
		- key：缓存数据使用的 Key ，可以用它来指定，默认是使用方法参数的值
		- cacheManager：指定缓存管理器（见图）
		- condition：指定符合条件的情况下才缓存
		- unless：与condition相反
		- sync：是否使用异步模式
		
		- 
			
			§ SpEl写法
	example：@Cacheable(cacheNames = {"emp"}，key="#id"）
		- #id = #a0 = #root.args[0]
	
###	@CachePut
	  ```java
		/**
		*@CachePut:既调用方法，有更新数据
		*修改了数据库的某个数据，同时更新
		*@paramemployee
		*@return
		*/
		@CachePut(keyGenerator="myKeyGenerator",value={"emp"})
		publicEmployeeupdateEmp(Employeeemployee){
		
		System.out.println("222222");
		employeeMapper.updateEmp(employee);
		returnemployee;
		}
		```
###		@CacheEvict
		
    ```java
		/**
		*@CacheEvict:缓存数据清除
		*allEntries=true：指定清除这个缓存所有的数据
		*beforeInvocaion=false；缓存清除是否是否在方法执行之前执行
		*默认代表是在方法执行之后执行，如果出现异常缓存就不会清除
		*@paramid
		*/
		@CacheEvict(value="emp",key="#id")
		publicvoiddeleteEmp(Integerid){
		
		employeeMapper.deleteEmById(id);
		}
		```
		
		```java
    		@Caching
		
		//@Caching定义复杂的缓存规则
		@Caching(
		cacheable={
		@Cacheable(/*value="emp",*/key="#lastName")
		},
		put={
		@CachePut(/*value="emp",*/key="#result.id"),
		@CachePut(/*value="emp",*/key="#result.email")
		}
		)
		publicEmployeegetEmpByLastName(StringlastName){
		returnemployeeMapper.getEmpByLastName(lastName);
}
```

