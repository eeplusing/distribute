package com.lixuan.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


/************************************************************************************
 * @Title        : SocketClient.java
 * @Todo         :<----功能描述---->
 * @Author       : CaoPeng
 * @DateTime     : 2016年4月19日 下午4:12:50
 * @Copyright    : 2016 LLC All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class SocketClient{
	static String clientName = "HUILI";

	public static void main(String[] args) throws UnknownHostException, IOException
	{
		Socket socket = new Socket("127.0.0.1", 9090);
		System.out.println("Client发起聊天");
		try{
			/*设置IO句柄*/	
			//读取服务端返回的流
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//向服务端写入的流
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

			//向服务端发送信息
			out.println("hello Server,I am " + clientName);
			System.out.println("Client:" + "hello Server,I am " + clientName + "---------------------");
			
			
			//显示从服务端返回的信息
			String str = in.readLine();	
			System.out.println("-----------------------------------" + str + ":Server");

			//向服务端发送信息
			out.println("byebye");
			System.out.println("Client:" + "byebye" + "------------------------");
			
			//显示从服务端返回的信息
			 str = in.readLine();	
			System.out.println("-----------------------------------" + str + ":Server");
		} catch (Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		finally{
			//关闭Socket
			socket.close();
		}

	}



}
