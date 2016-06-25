package com.lixuan.corejava.ch6;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class InnerClassTest
{
	public static void main(String[] args)
	{
		TalkingClock clock = new TalkingClock(1, true);
		clock.start();
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}
}

class TalkingClock
{
	private int interval;
	private boolean beep;
	
	public TalkingClock(int interval, boolean beep)
	{
		this.interval = interval;
		this.beep = beep;
	}
	
	public void start()
	{
		ActionListener listener = new TimePrinter();
		Timer t = new Timer(interval, listener);
		t.start();
	}
	
	/**
	 * 内部类，可以访问外围类的数据域
	 * **/
	public class TimePrinter implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			Date now = new Date();
			System.out.println("At the tone, the time is " + now);
			/*if(beep)*/
			if(TalkingClock.this.beep)
			{
				Toolkit.getDefaultToolkit().beep();
			}
		}
		
	}
}