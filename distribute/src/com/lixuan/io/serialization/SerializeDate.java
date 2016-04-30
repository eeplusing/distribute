package com.lixuan.io.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

/************************************************************************************
 * @Title        : SerializeDate.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年4月30日 下午2:55:48
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class SerializeDate {

	Date d;
	SerializeDate() throws IOException{
		d = new Date();
		FileOutputStream f = new FileOutputStream("date.ser");
		ObjectOutputStream s = new ObjectOutputStream(f);
		s.writeObject(d);
		f.close();
	}
	public static void main(String[] args) throws IOException {
		SerializeDate b = new SerializeDate();
		System.out.println("The save date is " + b.d.toString());
	}

}

/***********************
 * 对没有进行实例化的对象进行操作会报空指针异常
 * *************************/
