package com.lixuan.io.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/************************************************************************************
 * @Title        : Employee.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年4月30日 下午5:06:02
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class Employee implements Serializable{
	int id;
	String name;
	int age;
	int salary;
	String hireDay;
	String department;
	
	public Employee(){}
	public Employee(int id, String name, int age, int salary, String hireDay, String department){
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.hireDay = hireDay;
		this.department = department;
		
	}
	
	private void writeObject(ObjectOutputStream out) throws IOException{
		Date saveDate = new Date();
		out.writeInt(id);
		out.writeUTF(name);
		out.writeInt(age);
		out.writeInt(salary);
		out.writeUTF(hireDay);
		out.writeUTF(department);
		out.writeInt(saveDate.getYear());
	}
	
	private void readObject(ObjectInputStream in) throws IOException {
		Date readDate = new Date();
		int savedYear;
		id = in.readInt();
		name = in.readUTF();
		age = in.readInt();
		salary = in.readInt();
		hireDay = in.readUTF();
		department = in.readUTF();
		savedYear = in.readInt();
		age = age + (readDate.getYear() - savedYear);
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age
				+ ", salary=" + salary + ", hireDay=" + hireDay
				+ ", department=" + department + "]";
	}
	
	
	
}
