package com.lixuan.io.serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

/************************************************************************************
 * @Title        : ManagerExtern.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年4月30日 下午7:31:28
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class ManagerExtern extends EmployeeExtern implements Externalizable {

	String position;
	public ManagerExtern() {}

	ManagerExtern(int id, String name, int age, int salary, String hireDay,
			String department, String position) {
		super(id, name, age, salary, hireDay, department);
		this.position = position;
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		Date saveDate = new Date();
		out.writeInt(id);
		out.writeObject(name);
		out.writeInt(age);
		out.writeInt(salary);
		out.writeObject(hireDay);
		out.writeObject(department);
		out.writeObject(position);;
		out.writeInt(saveDate.getYear());
		
	}

	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		Date readDate = new Date();
		int savedYear;
		id = in.readInt();
		name = (String) in.readObject();
		age = in.readInt();
		salary = in.readInt();
		hireDay = (String) in.readObject();
		department = (String) in.readObject();
		position = (String) in.readObject();
		savedYear = in.readInt();
		
		age = age + (readDate.getYear() - savedYear);
		
	}
	
	public String toString(){
		return super.toString() + "\n postion:" + position;
	}
	
	
	

}
