package com.lixuan.io.file;

import java.io.IOException;
import java.io.RandomAccessFile;

/************************************************************************************
 * @Title        : RandomAccessTest.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年4月30日 下午2:30:39
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class RandomAccessTest {

	public static void main(String[] args) throws IOException {
		long filePoint = 0;
		String s;
		RandomAccessFile file = new RandomAccessFile("RandomAccessTest.java", "r");
		long fileLength = file.length();
		while(filePoint < fileLength){
			s = file.readLine();
			System.out.println(s);
			filePoint = file.getFilePointer();
		}
		file.close();
	}

}
