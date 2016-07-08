package com.lixuan.corejava.ch10;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class PropertiesTest
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				PropertiesFrame frame = new PropertiesFrame();
				frame.setVisible(true);
			}
			
		});
	}
}


class PropertiesFrame extends JFrame
{
	/** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	private File propertiesFile;
	private Properties settings;
	public PropertiesFrame()
	{
		//获取系统的用户目录
		String userDir = System.getProperty("user.home");
		//在用户目录下创建目录文件
		File propertiesDir = new File(userDir, ".ch10");
		if(!propertiesDir.exists())
		{
			propertiesDir.mkdir();
		}
		//在指定目录下创建文件
		propertiesFile = new File(propertiesDir, "program.properties");
		
		Properties defaultSettings = new Properties();
		defaultSettings.put("left", "0");
		defaultSettings.put("top", "0");
		defaultSettings.put("width", "200");
		defaultSettings.put("height", "100");
		defaultSettings.put("title", "");
		
		settings = new Properties(defaultSettings);
		if(propertiesFile.exists())
		try
		{
			FileInputStream in = new FileInputStream(propertiesFile);
			settings.load(in);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		int left = Integer.parseInt(settings.getProperty("left"));
		int top = Integer.parseInt(settings.getProperty("top"));
		int width = Integer.parseInt(settings.getProperty("width"));
		int height = Integer.parseInt(settings.getProperty("height"));
		setBounds(left, top, width, height);
		
		String title = settings.getProperty("title");
		if(title.equals(""))
			title = JOptionPane.showInputDialog("请输入窗口标题：");
		if(title == null)
			title = "";
		setTitle(title);
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent event)
			{
				settings.put("left", "" + getX());
				settings.put("top", "" + getY());
				settings.put("width", "" + getWidth());
				settings.put("height", "" + getHeight());
				settings.put("title", getTitle());
				FileOutputStream out;
				try
				{
					out = new FileOutputStream(propertiesFile);
					settings.store(out, "Program Properties");
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.exit(0);
			}
			
			
		});
		
		
	}
}








