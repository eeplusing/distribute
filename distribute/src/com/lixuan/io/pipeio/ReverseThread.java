package com.lixuan.io.pipeio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/************************************************************************************
 * @Title        : ReverseThread.java
 * @Todo         :<----功能描述---->
 * @Author       : Administrator
 * @DateTime     : 2016年4月25日 下午10:47:38
 * @Copyright    : 2016 LLC All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class ReverseThread extends Thread {

	private PrintWriter out = null;
	private BufferedReader in = null;
	
	public ReverseThread(PrintWriter out, BufferedReader in) {
		this.out = out;
		this.in = in;
	}
	
	//逆序线程的线程体
	public void run(){
		if(out != null && in != null){
			try{
				String input;
				while((input = in.readLine()) != null){
					out.println(reverseIt(input));
					out.flush();
				}
				out.close();				
			}catch(IOException e){
				System.err.println("ReverseThread run :" + e);
			}
		}
	}

	private String reverseIt(String source) {
		int i, length = source.length();
		StringBuffer dest = new StringBuffer(length);
		for(i = length - 1; i >= 0; i--){
			dest.append(source.charAt(i));
		}
		return dest.toString();
	}
	
}
