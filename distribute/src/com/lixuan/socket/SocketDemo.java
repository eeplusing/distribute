package com.lixuan.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


/************************************************************************************
 * @Title        : SocketClient.java
 * @Todo         :<----功能描述---->
 * @Author       : CaoPeng
 * @DateTime     : 2016年4月19日 下午4:12:50
 * @Copyright    : 2016 LLC All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class SocketDemo{
	
	private static PrintWriter writer;  
	private static BufferedReader reader; 
	private static boolean isConnected = false;
	private static Socket socket;
	private static Scanner sc = new Scanner(System.in);
	private static String sendString = null;
	private static MessageThread messageThread;
	public static void main(String[] args) throws UnknownHostException, IOException
	{
		if (connectServer()){
			while (true){
				sendString = sc.nextLine();
				if (sendString.equals("exit")){
					sendMessage(sendString);
					closeConnect();
					break;
				}
				sendMessage(sendString);
			}
		}
		
	}
	
	public static boolean connectServer(){
		try{
			socket = new Socket("127.0.0.1", 9090);
			/*设置IO句柄*/	
			//读取服务端返回的流
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//向服务端写入的流
			writer = new PrintWriter(socket.getOutputStream());
			sendMessage( "Client请求连接");
			
			messageThread = new SocketDemo().new MessageThread(reader);
			messageThread.start();
			return true;
		} catch (Exception e){
			e.printStackTrace();
			return false;
		} 
	}
	
	/**
	 * 接收消息的线程
	 */
	public class MessageThread extends Thread{
		private BufferedReader reader;
		
		public MessageThread(BufferedReader reader){
			this.reader = reader;
		}
        
        public void run() {  
            String message = "";  
            while (true) {  
                try {  
                    message = reader.readLine();  
                    if (message.equals("exit"))// 服务器已关闭命令  
                    {  
                        closeCon();// 被动的关闭连接  
                        return;// 结束线程  
                    } else {// 普通消息  
                        recieveMessage(message); 
                    }  
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
            }  
        }
        
        /**被动的关闭连接**/  
        public synchronized void closeCon() throws Exception {  
            // 被动的关闭连接释放资源  
            if (reader != null) {  
                reader.close();  
            }  
            if (writer != null) {  
                writer.close();  
            }  
            if (socket != null) {  
                socket.close();  
            }  
            isConnected = false;// 修改状态为断开  
        }  
	}

	
	
	/**  
     * 客户端主动关闭连接  
     */  
    @SuppressWarnings("deprecation")  
    public synchronized static void closeConnect() {  
        try {  
            sendMessage("exit");// 发送断开连接命令给服务器  
            messageThread.stop();// 停止接受消息线程  
            // 释放资源  
            if (reader != null) {  
                reader.close();  
            }  
            if (writer != null) {  
                writer.close();  
            }  
            if (socket != null) {  
                socket.close();  
            }  
            isConnected = false;  
        } catch (IOException e) {  
            e.printStackTrace();  
            isConnected = true;  
        }  
    }
	
	/*
	 * 发送的消息
	 */
	public static void sendMessage(String str){
		writer.println(str);
		writer.flush();
		System.out.println("Client:" + str + "+++++++++++++++++++++++");
	}
	
	/*
	 * 接收到的消息
	 */
	public void recieveMessage(String str){
		System.out.println("Server:" + str + "+++++++++++++++++++++++");
	}

}
