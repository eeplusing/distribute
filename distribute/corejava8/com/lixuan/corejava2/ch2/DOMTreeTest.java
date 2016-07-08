package com.lixuan.corejava2.ch2;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Enumeration;
import java.util.concurrent.ExecutionException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.SwingWorker;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.Document;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeNode;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/************************************************************************************
 * @Title        : DomTreeTest.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年7月2日 上午11:14:59
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class DOMTreeTest
{

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run()
			{
				JFrame frame = new DOMTreeFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
			
		});
	}

}

class DOMTreeFrame extends JFrame
{
	private DocumentBuilder builder;
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 400;
	
	public DOMTreeFrame()
	{
		setTitle("DOMTreeTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		JMenu fileMenu = new JMenu("File");
		JMenuItem openItem = new JMenuItem("open");
		
		openItem.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				openFile();
			}
		});
		fileMenu.add(openItem);
		
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		fileMenu.add(exitItem);
		
		JMenuBar menuBar = new JMenuBar(); 
		menuBar.add(fileMenu);
		setJMenuBar(menuBar);
		
	}

	protected void openFile()
	{
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		chooser.setFileFilter(new javax.swing.filechooser.FileFilter()
		{
			
			@Override
			public String getDescription()
			{
				return "XML files";
			}
			
			@Override
			public boolean accept(File f)
			{
				return f.isDirectory() || f.getName().toLowerCase().endsWith(".xml");
			}
		});
		
		int r = chooser.showOpenDialog(this);
		if(r != JFileChooser.APPROVE_OPTION) 
			return;
		final File file = chooser.getSelectedFile();
		
		new SwingWorker<Document, Void>()
		{
			@Override
			protected Document doInBackground() throws Exception
			{
				if(builder == null)
				{
					DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
					builder = factory.newDocumentBuilder();
				}
				return (Document) builder.parse(file);
			}
			
			protected void done()
			{
				try
				{
					Document doc = get();
					JTree tree = new JTree(new DOMTreeModel(doc));
					tree.setCellRenderer(new DOMTreeCellRenderer());
					setContentPane(new JScrollPane(tree));
					validate();
				} catch (Exception e)
				{
					JOptionPane.showMessageDialog(DOMTreeFrame.this, e);
					e.printStackTrace();
				}
			}
		}.execute();
	}
}

class DOMTreeModel implements TreeNode
{
	private Document doc;
	public DOMTreeModel(Document doc)
	{
		this.doc = doc;
	}

	public Object getRoot()
	{
		return doc.getDefaultRootElement();
	}
	
	public int getChildCount(Object parent)
	{
		Node node = (Node)parent;
		NodeList list = node.getChildNodes();
		return list.getLength();
	}
	
	public Object getChild(Object parent, int index)
	{
		Node node = (Node)parent;
		NodeList list = node.getChildNodes();
		return list.item(index);
	}
	
	public Object getIndexOfChild(Object parent, Object child)
	{
		Node node = (Node)parent;
		NodeList list = node.getChildNodes();
		for(int i = 0; i < list.getLength(); i++)
		{
			if(getChild(node, i) == child);
			return i;
		}
		return -1;
	}
	
	public boolean isLeaf(Object node)
	{
		return getChildCount(node) == 0;
	}
	
	@Override
	public TreeNode getChildAt(int childIndex)
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public TreeNode getParent()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getIndex(TreeNode node)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getAllowsChildren()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLeaf()
	{
		// TODO Auto-generated method stub
		return false;
	}
	

	@Override
	public Enumeration children()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getChildCount()
	{
		// TODO Auto-generated method stub
		return 0;
	}
	
}

class DOMTreeCellRenderer extends DefaultTreeCellRenderer
{

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean selected, boolean expanded, boolean leaf, int row,
			boolean hasFocus)
	{
		Node node = (Node)value;
		if(node instanceof Element)
			return elementPanel((Element)node);
		
		super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
		/*if(node instanceof CharacterData)
			setText(characterString((CharacterData)node));//抽象类作为参数类型
		else 
			setText(node.getClass() + ":" + node.toString());*/
		
		return this;
	}

	/*private String characterString(CharacterData node)
	{
		// TODO Auto-generated method stub
		return null;
	}*/

	public static JPanel elementPanel(Element e)
	{
		JPanel panel = new JPanel();
		panel.add(new JLabel("Element:" + e.getTagName()));
		final NamedNodeMap map = e.getAttributes();
		panel.add(new JTable(new AbstractTableModel(){

			@Override
			public int getRowCount()
			{
				return map.getLength();
			}

			@Override
			public int getColumnCount()
			{
				return 2;
			}

			@Override
			public Object getValueAt(int rowIndex, int columnIndex)
			{
				return columnIndex == 0 ? map.item(rowIndex).getNodeName() : map.item(rowIndex).getNodeValue();
			}
			
		}));
		return panel;
	}
	
}