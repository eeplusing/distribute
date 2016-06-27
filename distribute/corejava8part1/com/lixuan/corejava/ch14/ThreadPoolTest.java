package com.lixuan.corejava.ch14;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
public class ThreadPoolTest
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("请输入根目录");
		String directory = in.nextLine();
		System.out.println("请输入查找的关键字");
		String keyword = in.nextLine();
		
		ExecutorService pool = Executors.newCachedThreadPool();//创建一个线程池
		MatchCounter counter = new MatchCounter(new File(directory), keyword, pool);
		Future<Integer> result = pool.submit(counter);
		
		try
		{
			System.out.println(result.get() + "matching files");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		pool.shutdown();
		
		int largestPoolSize = ((ThreadPoolExecutor)pool).getLargestPoolSize();
		System.out.println("largest pool size= " + largestPoolSize);
		
		
	}
}

class MatchCounter implements Callable<Integer>
{
	private File directory;
	private String keyword;
	private ExecutorService pool;
	private int count;
	

	public MatchCounter(File directory, String keyword, ExecutorService pool)
	{
		this.directory = directory;
		this.keyword = keyword;
		this.pool = pool;
	}
	
	@Override
	public Integer call() throws Exception
	{
		count = 0;
		File[] files = directory.listFiles();
		ArrayList<Future<Integer>> results = new ArrayList<Future<Integer>>();
		for(File file:files)
		{
			if(file.isDirectory())
			{
				MatchCounter counter = new MatchCounter(file, keyword, pool);
				Future<Integer> result = pool.submit(counter);
				results.add(result);
			}
			else
			{
				if(search(file))
					count++;
			}
		}
		return count;
	}

	private boolean search(File file)
	{
		try
		{
			Scanner in = new Scanner(new FileInputStream(file));
			boolean found = false;
			while(!found && in.hasNextLine())
			{
				String line = in.nextLine();
				if(line.contains(keyword))
					found = true;
			}
			in.close();
			return found;
		} catch (IOException e)
		{
			e.printStackTrace();
			return false;
		}
	}
}
