package com.lixuan.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/************************************************************************************
 * @Title        : StandardIO.java
 * @Todo         :<----功能描述---->
 * @Author       : Administrator
 * @DateTime     : 2016年4月29日 下午8:34:22
 * @Copyright    : 2016 LLC All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class StandardIO {
	public static void main(String[] args){
		String s;
		//InputStreamReader将从System.in的字节数据转换为Unicode字符
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please input:");
		
		try {
			s= in.readLine();
			while(!s.equals("exit")){
				System.out.println("   read:" + s);
				s = in.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
