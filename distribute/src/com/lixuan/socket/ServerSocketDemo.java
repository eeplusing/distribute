package com.lixuan.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.lixuan.socket.Server.ClientThread;


/************************************************************************************
 * @Title        : SocketServer.java
 * @Todo         :<----功能描述---->
 * @Author       : CaoPeng
 * @DateTime     : 2016年4月19日 下午4:40:23
 * @Copyright    : 2016 LLC All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class ServerSocketDemo{

	private static PrintWriter writer;  
	private static BufferedReader reader; 
	private static Socket socket;
	private static ServerSocket ss;
	private static Scanner sc = new Scanner(System.in);
	private static String sendString;
	private static ClientThread clientThread;
	public static void main(String[] args) throws Exception{
		if(connectClicen()){
			while(true){
				sendString = sc.nextLine();
				if (sendString.equals("exit")){
					reverseMessage(sendString);
					closeConnect();
					break;
				}
				reverseMessage(sendString);
			}
		}
	}

	public static boolean connectClicen() throws IOException{
		//通讯端口9090
		ss = new ServerSocket(9090);
		/*阻塞直到所有客户端连接*/
		socket = ss.accept();

		try {
			//读取客户端发过来的流
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//写入客户端的流
			writer = new PrintWriter(socket.getOutputStream());
			reverseMessage( "Server响应连接请求");

			clientThread = new ServerSocketDemo().new ClientThread(reader);
			clientThread.start();
			return true;
		} catch (Exception e){
			e.printStackTrace();
			return false;
		} 
	}



	/*用于处理从客户端发过来的消息*/
	class ClientThread extends Thread {  
		private Socket socket;  
		private BufferedReader reader;  
		private PrintWriter writer;  

		public BufferedReader getReader() {  
			return reader;  
		}  

		public PrintWriter getWriter() {  
			return writer;  
		}  

		public ClientThread(BufferedReader reader){
			this.reader = reader;
		}

		/**
		 *不断接收客户端的消息，进行处理
		 */
		@SuppressWarnings("deprecation")  
		public void run() {// 
			String message = null;  
			while (true) {  
				try {  
					message = reader.readLine();// 接收客户端消息
					recieveMessage(message);
					if (message.equals("exit"))// 下线命令  
					{  
						try {
							closeConnect();
						} catch (Exception e) {
							e.printStackTrace();
						}
					} 
				} catch (IOException e) {  
					e.printStackTrace();  
				}  
			}  
		}  
	}

	/**
	 * 发送的消息
	 */
	public static void reverseMessage(String str){
		writer.println(str);
		writer.flush();
		System.out.println("Server:" + str + "+++++++++++++++++++++++");
	}

	/**
	 * 接收到的消息
	 */
	public void recieveMessage(String str){
		System.out.println("Client:" + str + "+++++++++++++++++++++++");
	}

	/**
	 *服务端主动关闭连接 
	 */
	public static void closeConnect() throws Exception{
		clientThread.stop();
		//clientThread.destroy();
		if (reader != null)
			reader.close(); 
		if (writer != null)  
			writer.close();  
		if (socket != null)  
			socket.close(); 
		if(ss != null)
			ss.close();
	}

}
