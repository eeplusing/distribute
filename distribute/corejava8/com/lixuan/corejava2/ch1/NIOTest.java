package com.lixuan.corejava2.ch1;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.zip.CRC32;

public class NIOTest
{
	public static void main(String[] args) throws IOException
	{
		
		System.out.println("InputStream");
		long start = System.currentTimeMillis();
		long crcValue = checksumInputStream(args[0]);
		long end = System.currentTimeMillis();
		System.out.println(Long.toHexString(crcValue));
		System.out.println("millisecond");
		
		System.out.println("BufferedInputStream");
		start = System.currentTimeMillis();
		crcValue = checksumInputStream(args[0]);
		end = System.currentTimeMillis();
		System.out.println(Long.toHexString(crcValue));
		System.out.println("millisecond");
		
		System.out.println("RandomAccessFile");
		start = System.currentTimeMillis();
		crcValue = checksumInputStream(args[0]);
		end = System.currentTimeMillis();
		System.out.println(Long.toHexString(crcValue));
		System.out.println("millisecond");
		
		System.out.println("MappedByteBuffer");
		start = System.currentTimeMillis();
		crcValue = checksumInputStream(args[0]);
		end = System.currentTimeMillis();
		System.out.println(Long.toHexString(crcValue));
		System.out.println("millisecond");
		
	}
	
	public static long checksumInputStream(String fileName) throws IOException
	{
		InputStream in = new FileInputStream(fileName);
		
		CRC32 crc = new CRC32();
		int c;
		while((c = in.read()) != -1)
		{
			crc.update(c);
		}
		
		
		return crc.getValue();
	}
	public static long checksumBufferedInputStream(String fileName) throws IOException
	{
		InputStream in = new BufferedInputStream(new FileInputStream(fileName));
		
		CRC32 crc = new CRC32();
		int c;
		while((c = in.read()) != -1)
		{
			crc.update(c);
		}
		return crc.getValue();
	}
	
	public static long checksumRandomAccessFile(String fileName) throws IOException
	{
		RandomAccessFile file = new RandomAccessFile(fileName, "r");
		long length = file.length();
		CRC32 crc = new CRC32();
		
		for(int i = 0; i < length; i++)
		{
			file.seek(i);
			int c = file.readByte();
			crc.update(c);
		}
		return crc.getValue();
	}
	
	public static long checksumMappedFile(String fileName) throws IOException
	{
		FileInputStream in = new FileInputStream(fileName);
		FileChannel channel = in.getChannel();
		CRC32 crc = new CRC32();
		int length = (int) channel.size();
		MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, length);
		
		for(int i = 0; i < length; i++)
		{
			int c = buffer.get(i);
			crc.update(c);
		}
		return crc.getValue();
	}
}
