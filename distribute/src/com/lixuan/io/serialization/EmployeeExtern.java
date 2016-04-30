package com.lixuan.io.serialization;

/************************************************************************************
 * @Title        : EmployeeExtern.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年4月30日 下午7:28:58
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class EmployeeExtern {
	int id;
	String name;
	int age;
	int salary;
	String hireDay;
	String department;
	
	public EmployeeExtern(){}

	public EmployeeExtern(int id, String name, int age, int salary, String hireDay, String department) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.hireDay = hireDay;
		this.department = department;
	}

	@Override
	public String toString() {
		return "EmployeeExtern [id=" + id + ", name=" + name + ", age=" + age
				+ ", salary=" + salary + ", hireDay=" + hireDay
				+ ", department=" + department + "]";
	}
	
	
	
}
