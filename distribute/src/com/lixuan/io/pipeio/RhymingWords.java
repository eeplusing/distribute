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

	/*主线程*/
	public static void main(String[] args) throws IOException {
		
		//节点流
		FileReader words = new FileReader("D:\\logs\\distribute\\mywords.txt");
		
		//进行单词的逆序    排序    再逆序还原
		//字符输入流顶层类
		Reader rhymedWords = reverse(sort(reverse(words)));
		
		/*将处理过的单词输出显示*/
		//缓存流
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
		
		/*1.创建管道流，并将管道输出流和管道输入流进行挂接*/
		PipedWriter pipeOut = new PipedWriter();
		PipedReader pipeIn = new PipedReader(pipeOut);
		
		/*2.将管道输出流传递给ReverseThread作为该线程的输出流*/
		PrintWriter out = new PrintWriter(pipeOut);
		new ReverseThread(out, in).start();
		
		/*3.将管道输人流作为主线程的输入流*/
		return pipeIn;
	}
	
	
	/**创建管道,创建并启动单词排序线程
	 * @throws IOException **/
	public static Reader sort(Reader source) throws IOException{
		BufferedReader in = new BufferedReader(source);
		
		/*1.创建管道流，并将管道输出流和管道输入流进行挂接*/
		PipedWriter pipeOut = new PipedWriter();
		PipedReader pipeIn = new PipedReader(pipeOut);
		
		/*2.将管道输出流传递给SortThread作为该线程输出流*/
		PrintWriter out = new PrintWriter(pipeOut);
		new SortThread(out, in).start();
		
		/*3.将管道输入流作为主线程的输入流*/
		return pipeIn;
	}
	
	

}
