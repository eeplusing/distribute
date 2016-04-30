package com.lixuan.io.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;

/************************************************************************************
 * @Title        : UnSerializeDate.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年4月30日 下午3:27:04
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class UnSerializeDate {

	Date d = null;
	UnSerializeDate() throws Exception{
		FileInputStream f = new FileInputStream("date.ser");
		ObjectInputStream s = new ObjectInputStream(f);
		d = (Date) s.readObject();
		f.close();
	}
	public static void main(String[] args) throws Exception {
		UnSerializeDate a = new UnSerializeDate();
		
		System.out.println("the read date is:" + a.d.toString());
	}

}
