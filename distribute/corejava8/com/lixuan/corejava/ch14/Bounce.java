package com.lixuan.corejava.ch14;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.ByteOrder;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/************************************************************************************
 * @Title        : Bounce.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年6月26日 下午8:30:33
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class Bounce
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame = new BounceFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class BounceFrame extends JFrame
{
	private BallComponent comp;
	public static final int DEFAULT_WIDTH = 450;
	public static final int DEFAULT_HEIGHT = 450;
	public static final int STEPS = 1000;
	public static final int DELAY = 3;
	
	public BounceFrame()
	{
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setTitle("Bounce");
		
		comp = new BallComponent();
		add(comp, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		addButton(buttonPanel, "Start", new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				addBall();
			}
		});
		
		addButton(buttonPanel, "close", new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		add(buttonPanel, BorderLayout.SOUTH);
	}

	protected void addBall()
	{
		try
		{
			Ball ball = new Ball();
			comp.add(ball);
			
			for(int i = 1; i <= STEPS; i++)
			{
				ball.move(comp.getBounds());
				comp.paint(comp.getGraphics());
				Thread.sleep(DELAY);
			}
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
	}

	private void addButton(JPanel buttonPanel, String string, ActionListener actionListener)
	{
		JButton button = new JButton(string);
		buttonPanel.add(button);
		button.addActionListener(actionListener);
	}
}

