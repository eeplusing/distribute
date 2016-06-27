package com.lixuan.corejava.ch14;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/************************************************************************************
 * @Title        : BounceThread.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年6月26日 下午9:23:21
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class BounceThread
{

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame = new BounceFrame1();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});

	}

}

class BallRunnable implements Runnable
{
	private Component component;
	private Ball ball;
	public static final int STEPS = 1000;
	public static final int DELAY = 5;
	public BallRunnable(Ball aBall, Component aComponent)
	{
		ball = aBall;
		component = aComponent;
	}
	@Override
	public void run()
	{
		try
		{
			for(int i = 1; i <= STEPS; i++)
			{
				ball.move(component.getBounds());
				component.repaint();
				Thread.sleep(DELAY);
			}
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
}


class BounceFrame1 extends JFrame
{
	private BallComponent comp;
	public static final int DEFAULT_WIDTH = 450;
	public static final int DEFAULT_HEIGHT = 350;
	public static final int STEPS = 1000;
	public static final int DELAY = 3;
	
	public BounceFrame1()
	{
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setTitle("BounceThread");
		
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
		
		addButton(buttonPanel, "Close", new ActionListener()
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
		Ball ball = new Ball();
		comp.add(ball);
		
		Runnable r = new BallRunnable(ball, comp);
		Thread t = new Thread(r);
		t.start();
	}

	private void addButton(Container buttonPanel, String string, ActionListener actionListener)
	{
		JButton button = new JButton(string);
		buttonPanel.add(button);
		button.addActionListener(actionListener);
	}
}



