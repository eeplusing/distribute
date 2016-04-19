package com.lixuan.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


/************************************************************************************
 * @Title        : SocketServer.java
 * @Todo         :<----功能描述---->
 * @Author       : CaoPeng
 * @DateTime     : 2016年4月19日 下午4:40:23
 * @Copyright    : 2016 LLC All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class SocketServer{
	public static void main(String[] args) throws IOException{
		//通讯端口9090
		ServerSocket ss = new ServerSocket(9090);

		/*阻塞直到所有客户端连接*/
		Socket socket = ss.accept();
		try {

			System.out.println("Server开始聊天");

			//读取客户端发过来的流
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//写入客户端的流
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

			while(true){
				String str = in.readLine();
				System.out.println(str);
				if(str == "byebye" || str == null){
					break;
				}

				System.out.println("--------------------------------------------------" + str + ":Client");
				out.println("I recieve the content from you " + str);
				System.out.println("Server:I recieve the content from you" + str +"------------------------------------------");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			System.out.println("close the ServerSocket and io");
			socket.close();
			ss.close();		
		}

	}
}
