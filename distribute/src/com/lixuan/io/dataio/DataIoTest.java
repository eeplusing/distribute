package com.lixuan.io.dataio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/************************************************************************************
 * @Title        : DataIoTest.java
 * @Todo         :<----功能描述---->
 * @Author       : Administrator
 * @DateTime     : 2016年4月28日 下午9:08:08
 * @Copyright    : 2016 LLC All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class DataIoTest {

	public static void main(String[] args) throws IOException  {
		//创建数据输出流，前端套接文件流并以invoice1.txt为输出文件
		DataOutputStream out = new DataOutputStream(new FileOutputStream("D:\\logs\\distribute\\invoice1.txt"));
		
		//定义要保存的数据数组
		double[] prices = {19.99, 9.89, 4.3};
		int[] units = {12,12,23};
		String[] descs = {"Java T", ".Net T", "C T"};
		
		for(int i = 0; i < prices.length; i++){
			out.writeDouble(prices[i]);
			out.writeChar('\t');
			out.writeInt(units[i]);
			out.writeChar('\t');
			out.writeUTF(descs[i]);
			out.writeChar('\t');
		}
		out.close();
		
		DataInputStream in = new DataInputStream(new FileInputStream("D:\\logs\\distribute\\invoice1.txt"));
		
		double price;
		int unit;
		String desc;
		for(int j = 0; j < prices.length; j++){
			price = in.readDouble();
			in.readChar();
			unit = in.readInt();
			in.readChar();
			desc = in.readUTF();
			in.readChar();
			System.out.println(desc + ":" + price + ":" + unit);
		}
		
		in.close();
		
	}

}
