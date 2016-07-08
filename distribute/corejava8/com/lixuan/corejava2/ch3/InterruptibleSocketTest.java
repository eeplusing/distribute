package com.lixuan.corejava2.ch3;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/************************************************************************************
 * @Title        : InterruptibleSocketTest.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年7月2日 下午9:55:07
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class InterruptibleSocketTest
{

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run()
			{
				JFrame frame = new InterruptibleSocketFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class InterruptibleSocketFrame extends JFrame
{
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 400;
	private Scanner in;
	private JButton interruptibleButton;
	private JButton blockingButton;
	private JButton cancelButton;
	private JTextArea messages;
	private Thread connectThread;
	private TestServer server;
	
	public InterruptibleSocketFrame()
	{
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setTitle("InterruptibleSocketFrame");
		JPanel northPanel = new JPanel();
		add(northPanel, BorderLayout.NORTH);
		
		messages = new JTextArea();
		add(new JScrollPane(messages));
		
		interruptibleButton = new JButton("Interruptible");
		blockingButton = new JButton("Blocking");
		northPanel.add(interruptibleButton);
		northPanel.add(blockingButton);
		
		interruptibleButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				interruptibleButton.setEnabled(false);
				blockingButton.setEnabled(false);
				cancelButton.setEnabled(true);
				connectThread = new Thread(new Runnable(){
					public void run()
					{
						try
						{
							connectInterruptibly();
						} catch (IOException e)
						{
							messages.append("\nInterruptibleSocketTest.connectInterruptily:" + e);
						}
					}
				});
				connectThread.start();
				
			}
		});
		
		blockingButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				interruptibleButton.setEnabled(false);
				blockingButton.setEnabled(false);
				cancelButton.setEnabled(true);
				connectThread = new Thread(new Runnable(){
					public void run()
					{
						try
						{
							connectBlocking();
						} catch (IOException e)
						{
							messages.append("\nInterruptibleSocketTest.connectBlocking:" + e);
						}
					}
				});
				connectThread.start();
				
			}
		});
		
		cancelButton = new JButton("Cancel");
		cancelButton.setEnabled(false);
		northPanel.add(cancelButton);
		cancelButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e)
			{
				connectThread.interrupt();
				cancelButton.setVisible(false);
			}
		});
		server = new TestServer();
		new Thread(server).start();
	}


	private  void connectInterruptibly() throws IOException 
	{
		messages.append("Interruptible\n");
		SocketChannel channel = SocketChannel.open(new InetSocketAddress("localhost", 8989));
		
		try
		{
			in = new Scanner(channel);
			while(!Thread.currentThread().isInterrupted())
			{
				messages.append("Reading ");
				if(in.hasNextLine())
				{
					String line = in.nextLine();
					messages.append(line + "\n");
				}	
				
			}
		} 
		finally
		{
			channel.close();
			EventQueue.invokeLater(new Runnable(){
				@Override
				public void run()
				{
					messages.append("Channel closed\n");
					interruptibleButton.setEnabled(true);
					blockingButton.setEnabled(true);
				}
			});
		}
	}
	
	private void connectBlocking() throws IOException
	{
		messages.append("Blocking\n");
		Socket socket = new Socket("localhost", 8989);
		
		try
		{
			in = new Scanner(socket.getInputStream());
			while(!Thread.currentThread().isInterrupted())
			{
				messages.append("Reading ");
				if(in.hasNextLine())
				{
					String line = in.nextLine();
					messages.append(line + "\n");
				}	
				
			}
		} 
		finally
		{
			socket.close();
			EventQueue.invokeLater(new Runnable(){
				@Override
				public void run()
				{
					messages.append("Socket closed\n");
					interruptibleButton.setEnabled(true);
					blockingButton.setEnabled(true);
				}
			});
		}
		
	}
	
	
	
	class TestServer implements Runnable
	{
		public void run()
		{
			try
			{
				ServerSocket s = new ServerSocket(8989);
				while(true)
				{
					Socket incoming = s.accept();
					Runnable r = new TestServerHandler(incoming);
					Thread t = new Thread(r);
					t.start();
				}
			} 
			catch (IOException e)
			{
				messages.append("\nTestServer.run" + e);
			}
		}
	}
	
	class TestServerHandler implements Runnable
	{
		private Socket incoming;
		private int counter;
		public TestServerHandler(Socket incoming)
		{
			this.incoming = incoming;
		}

		@Override
		public void run()
		{
			try
			{
				OutputStream outstream = incoming.getOutputStream();
				PrintWriter out = new PrintWriter(outstream, true);
				out.println("Hello! Enter BYE to exit");
				while(counter < 100)
				{
					counter++;
					if(counter <= 10)
						out.println(counter);
					Thread.sleep(100);
				}
				
			} 
			catch(Exception e)
			{
				messages.append("\nTestServerHandler.run" + e);
			}
			
			
		}
		
	}
}


