package com.lixuan.corejava2.ch5;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.geom.Rectangle2D;
import java.util.Locale;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/************************************************************************************
 * @Title        : Retire.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年7月7日 上午10:22:52
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class Retire extends JApplet
{
	private JTextField savingsField = new JTextField();
	private JTextField contribField = new JTextField();
	private JTextField incomeField = new JTextField();
	private JTextField currentAgeField = new JTextField();
	private JTextField retireAgeField = new JTextField();
	private JTextField deathAgeField = new JTextField();
	private JTextField inflationPercentField = new JTextField();
	private JTextField investPercentField = new JTextField();
	private JTextArea retireText = new JTextArea(10, 25);
	private RetireCanvas retireCanvas = new RetireCanvas();
	private JButton computeButton = new JButton();
	
	private JLabel languageLabel = new JLabel();
	private JLabel savingsLabel = new JLabel();
	private JLabel contribLabel = new JLabel();
	private JLabel incomeLabel = new JLabel();
	private JLabel currentAgeLabel = new JLabel();
	private JLabel retireAgeLabel = new JLabel();
	private JLabel deathAgeLabel = new JLabel();
	private JLabel inflationPercentLabel = new JLabel();
	private JLabel investPercentLabel = new JLabel();
	private RetireInfo info = new RetireInfo();
	
	public void init()
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				initUI();
			}
		});
	}
	
	public void initUI()
	{
		setLayout(new GridBagLayout());
		//add(languageLabel, new GBC(0, 0).setAnchor);
	}
	
	public void setCurrentLocale(Locale locale)
	{
		
	}
	
	public void updateDisplay()
	{
		
	}
	public void updateInfo()
	{
		
	}
	
	public void updateData()
	{
		
	}
	public void updateGraph()
	{
		
	}
	public void getInfo()
	{
		
	}
	
	
}

class RetireInfo
{
	private double savings;
	private double contrib;
	private double income;
	private int currentAge;
	private int retireAge;
	private int deathAge;
	private double inflationPercent;
	private double investPercent;
	private int age;
	private double balance;
	public double getSavings()
	{
		return savings;
	}
	public void setSavings(double savings)
	{
		this.savings = savings;
	}
	public double getContrib()
	{
		return contrib;
	}
	public void setContrib(double contrib)
	{
		this.contrib = contrib;
	}
	public double getIncome()
	{
		return income;
	}
	public void setIncome(double income)
	{
		this.income = income;
	}
	public int getCurrentAge()
	{
		return currentAge;
	}
	public void setCurrentAge(int currentAge)
	{
		this.currentAge = currentAge;
	}
	public int getRetireAge()
	{
		return retireAge;
	}
	public void setRetireAge(int retireAge)
	{
		this.retireAge = retireAge;
	}
	public int getDeathAge()
	{
		return deathAge;
	}
	public void setDeathAge(int deathAge)
	{
		this.deathAge = deathAge;
	}
	public double getInflationPercent()
	{
		return inflationPercent;
	}
	public void setInflationPercent(double inflationPercent)
	{
		this.inflationPercent = inflationPercent;
	}
	public double getInvestPercent()
	{
		return investPercent;
	}
	public void setInvestPercent(double investPercent)
	{
		this.investPercent = investPercent;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public double getBalance(int year)
	{
		if(year < currentAge)
			return 0;
		else if(year == currentAge)
		{
			age = currentAge;
			balance = savings;
			return balance;
		}
		if(year != age + 1)
			getBalance(year - 1);
		age = year;
		if(age < retireAge)
			balance += contrib;
		else 
			balance -= income;
		balance = balance * (1 + investPercent - inflationPercent);
		
		return balance;
	}
	public void setBalance(double balance)
	{
		this.balance = balance;
	}
}

class RetireCanvas extends JPanel
{
	private RetireInfo info = null;
	private Color colorPre;
	private Color colorGain;
	private Color colorLoss;
	private static final int PANEL_WIDTH = 800;
	private static final int PANEL_HEIGHT = 400;
	
	public RetireCanvas()
	{
		setSize(PANEL_WIDTH, PANEL_HEIGHT);
	}
	
	public void setInfo(RetireInfo newInfo)
	{
		this.info = newInfo;
		repaint();
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		if(info == null)
			return;
		
		double minValue = 0;
		double maxValue = 0;
		int i;
		for(i = info.getCurrentAge(); i <= info.getDeathAge(); i++)
		{
			double v = info.getBalance(i);
			if(minValue > v)
				minValue = v;
			if(maxValue > v)
				maxValue = v;
		}
		if(minValue == maxValue)
			return;
		
		int barWidth = getWidth()/(info.getDeathAge() - info.getCurrentAge() + 1);
		double scale = getHeight()/(maxValue - minValue);
		
		for(i = info.getCurrentAge(); i <= info.getDeathAge(); i++)
		{
			int x1 = (i - info.getCurrentAge()) * barWidth + 1;
			int y1;
			double v = info.getBalance(i);
			int height;
			int yOrigin = (int)(maxValue * scale);
			
			if(v >= 0)
			{
				y1 = (int)((maxValue - v) * scale);
				height = yOrigin - y1;
			}
			else
			{
				y1 = yOrigin;
				height = (int)(-v * scale);
			}
			if(i < info.getRetireAge())
				g2.setPaint(colorPre);
			else if(v >= 0)
				g2.setPaint(colorGain);
			else 
				g2.setPaint(colorLoss);
			
			Rectangle2D bar = new Rectangle2D.Double(x1, y1, barWidth - 2, height);
			g2.fill(bar);
			g2.setPaint(Color.black);
			g2.draw(bar);
		}
	}

	public void setColorPre(Color colorPre)
	{
		this.colorPre = colorPre;
		repaint();
	}

	public void setColorGain(Color colorGain)
	{
		this.colorGain = colorGain;
		repaint();
	}

	public void setColorLoss(Color colorLoss)
	{
		this.colorLoss = colorLoss;
		repaint();
	}
}





