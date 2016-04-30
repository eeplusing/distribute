package com.lixuan.io.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/************************************************************************************
 * @Title        : ObjectSerial.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年4月30日 下午5:23:19
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class ObjectSerial {
	public static void main(String args[]) throws IOException, ClassNotFoundException{
		Employee emp = new Employee(12345, "Tom", 23, 50000, "2015/10/1", "INTEL");
		ObjectOutputStream fout1 = new ObjectOutputStream(new FileOutputStream("data1.ser"));
		
		//使用Employee定制readObject方法
		fout1.writeObject(emp);
		fout1.close();
		
		//重新置空
		emp = null;
		ObjectInputStream fin1 = new ObjectInputStream(new FileInputStream("data1.ser"));
		emp = (Employee)fin1.readObject();
		fin1.close();
		System.out.println(emp.toString());
		
	}
}
