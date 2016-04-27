package com.lixuan.io.pipeio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.io.Reader;

/************************************************************************************
 * @Title        : RhymingWords.java
 * @Todo         :<----功能描述---->
 * @Author       : Administrator
 * @DateTime     : 2016年4月25日 下午10:35:23
 * @Copyright    : 2016 LLC All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class RhymingWords {

	public static void main(String[] args) throws IOException {
		
		FileReader words = new FileReader("D:\\logs\\distribute\\mywords.txt");
		
		//进行单词的逆序    排序    再逆序还原
		Reader rhymedWords = reverse(sort(reverse(words)));
		
		//将处理过的单词输出显示
		BufferedReader in = new BufferedReader(rhymedWords);
		String input;
		while((input = in.readLine()) != null){
			System.out.println(input);
		}
		in.close();
	}
	
	/**创建管道,创建并启动单词逆序线程**/
	public static Reader reverse(Reader source) throws IOException {
		BufferedReader in = new BufferedReader(source);
		PipedWriter pipeOut = new PipedWriter();
		PipedReader pipeIn = new PipedReader(pipeOut);
		
		PrintWriter out = new PrintWriter(pipeOut);
		new ReverseThread(out, in).start();
		
		return pipeIn;
	}
	
	
	/**创建管道,创建并启动单词排序线程
	 * @throws IOException **/
	public static Reader sort(Reader source) throws IOException{
		BufferedReader in = new BufferedReader(source);
		PipedWriter pipeOut = new PipedWriter();
		PipedReader pipeIn = new PipedReader(pipeOut);
		PrintWriter out = new PrintWriter(pipeOut);
		new SortThread(out, in).start();
		return pipeIn;
	}
	
	

}
