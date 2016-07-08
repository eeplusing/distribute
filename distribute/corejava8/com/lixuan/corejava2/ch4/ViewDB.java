package com.lixuan.corejava2.ch4;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.sun.rowset.CachedRowSetImpl;

/************************************************************************************
 * @Title        : ViewDB.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年7月6日 下午7:37:35
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class ViewDB
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame = new ViewDBFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class ViewDBFrame extends JFrame
{
	public static final int DEFAULT_WIDTH = 400;
	public static final int DEFAULT_HEIGHT = 200;
	private JButton previousButton;
	private JButton nextButton;
	private JButton deleteButton;
	private JButton saveButton;
	private DataPanel dataPanel;
	private Component scrollPane;
	private JComboBox tableNames;
	private Properties props;
	private CachedRowSet crs;
	public ViewDBFrame()
	{
		setTitle("ViewDB");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		tableNames = new JComboBox();
		tableNames.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				showTable((String)tableNames.getSelectedItem());
			}
		});
		add(tableNames, BorderLayout.NORTH);
		
		try
		{
			readDatabaseProperties();
			Connection conn = getConnection();
			try
			{
				DatabaseMetaData meta = conn.getMetaData();
				ResultSet mrs = meta.getTables(null, null, null, new String[]{"TABLE"});
				while(mrs.next())
				{
					tableNames.addItem(mrs.getString(3));
				}
			}
			finally
			{
				conn.close();
			}
		} 
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(this, e);
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(this, e);
		}
		

		JPanel buttonPanel = new JPanel();
		add(buttonPanel, BorderLayout.SOUTH);
		
		previousButton = new JButton("Previous");
		previousButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				showPreviousRow();
			}
		});
		buttonPanel.add(previousButton);
		
		nextButton = new JButton("Next");
		nextButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				showNextRow();
			}
		});
		buttonPanel.add(nextButton);
		
		saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				saveChanges();
			}
		});
		buttonPanel.add(saveButton);
		
	}

	protected void deleteRow()
	{
		try
		{
			Connection conn = getConnection();
			try
			{
				crs.deleteRow();
				crs.acceptChanges(conn);
				if(!crs.isLast())
					crs.next();
				else if(!crs.isFirst())
					crs.previous();
				else 
					crs = null;
				dataPanel.showRow(crs);
			} 
			finally
			{
				conn.close();
			}
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	protected void saveChanges()
	{
		try
		{
			Connection conn = getConnection();
			try
			{
				dataPanel.setRow(crs);
				crs.acceptChanges(conn);
			} finally
			{
				conn.close();
			}
		} 
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(this, e);
		}
	}

	protected void showNextRow()
	{
		try
		{
			if(null == crs  || crs.isFirst())
				return;
			crs.previous();
			dataPanel.showRow(crs);
		} catch (SQLException e)
		{
			JOptionPane.showMessageDialog(this, e);
		}
		
	}

	protected void showPreviousRow()
	{
		try
		{
			if(null == crs  || crs.isFirst())
				return;
			crs.previous();
			dataPanel.showRow(crs);
		} catch (SQLException e)
		{
			for(Throwable t:e)
				t.printStackTrace();
		}
	}

	private void showTable(String tableName)
	{
		try
		{
			Connection conn = getConnection();
			try
			{
				Statement stat = conn.createStatement();
				ResultSet result = stat.executeQuery("SELECT * FROM " + tableName);
				crs = new CachedRowSetImpl();
				crs.setTableName(tableName);
				crs.populate(result);
			} finally
			{
				conn.close();
			}
			
			if(scrollPane != null)
				remove(scrollPane);
			dataPanel = new DataPanel(crs);
			scrollPane = new JScrollPane(dataPanel);
			add(scrollPane, BorderLayout.CENTER);
			validate();
			showNextRow();
		}catch(SQLException e)
		{
			JOptionPane.showMessageDialog(this, e);
		}
		
	}
	
	private void readDatabaseProperties() throws IOException
	{
		props = new Properties();
		FileInputStream in = new FileInputStream("corejava8part2/com/lixuan/corejava2/ch4/database.properties");
		props.load(in);
		in.close();
		String drivers = props.getProperty("jdbc.drivers");
		if(drivers != null)
		{
			System.setProperty("jdbc.drivers", drivers);
		}
	}

	private Connection getConnection() throws SQLException
	{
		String url = props.getProperty("jdbc.url");
		String name = props.getProperty("jdbc.username");
		String password = props.getProperty("jdbc.password");
		return DriverManager.getConnection(url, name, password);
	}
}

class DataPanel extends JPanel
{
	private  ArrayList<JTextField> fields;
	public DataPanel(RowSet rs) throws SQLException
	{
		fields = new ArrayList<JTextField>();
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		
		ResultSetMetaData rsmd = rs.getMetaData();
		
		for(int i = 1; i <= rsmd.getColumnCount(); i++)
		{
			gbc.gridy = i - 1;
			gbc.gridx = 0;
			String columnName = rsmd.getCatalogName(i);
			gbc.anchor = GridBagConstraints.EAST;
			add(new JLabel(columnName), gbc);
			
			int columnWidth = rsmd.getColumnDisplaySize(i);
			JTextField tb = new JTextField(columnWidth);
			if(!rsmd.getColumnClassName(i).equals("java.lang.String"))
			{
				tb.setEditable(false);
			}
			
			fields.add(tb);
			gbc.gridx = 1;
			gbc.anchor = GridBagConstraints.WEST;
			add(tb, gbc);
		}
	}
	
	public void showRow(ResultSet rs) throws SQLException
	{
		for(int i = 1; i <= fields.size(); i++)
		{
			String field = rs.getString(i);
			JTextField tb = fields.get(i - 1);
			tb.setText(field);
		}
	}
	public void setRow(ResultSet rs) throws SQLException
	{
		for(int i = 1; i <= fields.size(); i++)
		{
			String field = rs.getString(i);
			JTextField tb = fields.get(i - 1);
			if(!field.equals(tb.getText()))
				tb.setText(field);
		}
		rs.updateRow();
	}
}







