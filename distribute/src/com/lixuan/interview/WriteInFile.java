package com.lixuan.interview;
import java.io.*;
public class WriteInFile
{
	public static void main(String[] args)
	{
		try
		{
			FileOutputStream out = new FileOutputStream("src/com/lixuan/interview/FileName.txt");
			//相对目录的根目录为项目文件夹
			out.write("\n测试将字符串写入文件测试将字符串写入文件\n".getBytes());
			out.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
