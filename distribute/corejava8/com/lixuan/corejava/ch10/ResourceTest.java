package com.lixuan.corejava.ch10;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JTextArea;
/************************************************************************************
 * @Title        : ResourceTest.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年6月20日 下午5:27:18
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class ResourceTest
{

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			
			@Override
			public void run()
			{
				ResourceTestFrame frame = new ResourceTestFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}

class ResourceTestFrame extends JFrame
{
	public ResourceTestFrame()
	{
		setTitle("ResourceTest");
		setSize(300, 300);
		URL aboutUrl = getClass().getResource("icon.jpg");
		Image img = Toolkit.getDefaultToolkit().getImage(aboutUrl);
		setIconImage(img);
		
		JTextArea textArea = new JTextArea();
		InputStream stream = getClass().getResourceAsStream("temp.txt");
		Scanner in = new Scanner(stream);
		
		while(in.hasNext())
		{
			textArea.append(in.nextLine() + "\n");
			add(textArea);
		}
		
	}
}
