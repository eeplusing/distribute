package com.lixuan.corejava.ch14;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
/************************************************************************************
 * @Title        : BlockingQueueTest.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年6月27日 下午2:25:13
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class BlockingQueueTest
{
	private BlockingQueue<File> queue;
	private File startingDirectory;
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("输入根目录");
		String directory = in.nextLine();
		System.out.println("输入一个单词");
		String keyword = in.nextLine();
		
		final int FILE_QUEUE_SIZE = 10;
		final int SEARCH_THREADS = 100;
		
		BlockingQueue<File> queue = new ArrayBlockingQueue<File>(FILE_QUEUE_SIZE);
		FileEnumerationTask enumerator = new FileEnumerationTask(queue, new File(directory));
		new Thread(enumerator).start();
		for(int i = 1; i <= SEARCH_THREADS; i++)
			new Thread(new SearchTask(queue, keyword)).start();;
	}
}

//加载文件线程
class FileEnumerationTask implements Runnable
{
	public static File DUMMY = new File("");
	private BlockingQueue<File> queue;
	private File startingDirectory;
	public FileEnumerationTask(BlockingQueue<File> queue, File file)
	{
		this.queue = queue;
		this.startingDirectory = file;
	}

	@Override
	public void run()
	{
		try
		{
			enumerate(startingDirectory);
			queue.put(DUMMY);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	private void enumerate(File directory) throws InterruptedException
	{
		File[] files = directory.listFiles();
		for(File file:files)
		{
			if(file.isDirectory())
				enumerate(file);
			else 
				queue.put(file);
		}
	}
}

//查询线程
class SearchTask implements Runnable
{
	private BlockingQueue<File> queue;
	private String keyword;
	public SearchTask(BlockingQueue<File> queue, String keyword)
	{
		this.queue = queue;
		this.keyword = keyword;
	}

	@Override
	public void run()
	{
		try
		{
			boolean done = false;
			while(!done)
			{
				File file = queue.take();
				if(file == FileEnumerationTask.DUMMY)
				{
					queue.put(file);
					done = true;
				}else
				{
					search(file);
				}
				
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private void search(File file) throws IOException
	{
		Scanner in = new Scanner(new FileInputStream(file));
		int lineNumber = 0;
		while(in.hasNextLine())
		{
			lineNumber++;
			String line = in.nextLine();
			if(line.contains(keyword))
				System.out.printf("%s:%d:%s%n", file.getPath(), lineNumber, line);
		}
		in.close();
	}

}

