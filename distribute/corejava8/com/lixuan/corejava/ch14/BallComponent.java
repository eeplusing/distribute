package com.lixuan.corejava.ch14;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

/************************************************************************************
 * @Title        : BallComponent.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年6月26日 下午9:00:12
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class BallComponent extends JPanel
{
	/** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	private ArrayList<Ball> balls = new ArrayList<Ball>();
	public void add(Ball ball)
	{
		balls.add(ball);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for(Ball b:balls)
		{
			g2.fill(b.getShape());
		}
	}
}
