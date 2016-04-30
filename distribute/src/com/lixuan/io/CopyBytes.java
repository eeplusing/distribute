package com.lixuan.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/************************************************************************************
 * @Title        : CopyBytes.java
 * @Todo         :通过文件字节/符流实现文件的复制
 * @Author       : Administrator
 * @DateTime     : 2016年4月25日 下午9:40:43
 * @Copyright    : 2016 LLC All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class CopyBytes {

	public static void main(String[] args) throws IOException {
		
		/*字节流*/
		File inputFile = new File("src\\com\\lixuan\\io\\inputfile.txt");
		File outputFile = new File("src\\com\\lixuan\\io\\outfile.txt");
		FileInputStream in = new FileInputStream(inputFile);
		FileOutputStream out = new FileOutputStream(outputFile);
		int byteStream;
		while((byteStream = in.read()) != -1){
			out.write(byteStream);
		}
		in.close();
		out.close();
		
		
		/*字符流*/
		FileReader input = new FileReader("D:\\logs\\distribute\\inputfile1.txt");
		FileWriter output = new FileWriter("D:\\logs\\distribute\\outfile1.txt");
		int charStream;
		while((charStream = input.read()) != -1){
			output.write(charStream);
		}
		input.close();
		output.close();
	}

}
