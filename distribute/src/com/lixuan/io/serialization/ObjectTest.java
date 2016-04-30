package com.lixuan.io.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/************************************************************************************
 * @Title        : ObjectTest.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年4月30日 下午7:46:32
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class ObjectTest {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
		ManagerExtern manager = new ManagerExtern(123123, "tomcat", 
				34, 340000, "2020", "运营", "产品经理");
	
		ObjectOutputStream fout = new ObjectOutputStream(
				new FileOutputStream("src\\com\\lixuan\\io\\serialization\\data2.ser"));//这是相对路径（根据项目目录），
		fout.writeObject(manager);
		fout.close();
		
		manager = null;
		ObjectInputStream fin = new ObjectInputStream(
				new FileInputStream("src\\com\\lixuan\\io\\serialization\\data2.ser"));
		manager = (ManagerExtern)fin.readObject();
		
		System.out.println("manger:" + manager.toString());
	}
}
