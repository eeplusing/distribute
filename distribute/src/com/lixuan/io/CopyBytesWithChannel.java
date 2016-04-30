package com.lixuan.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/************************************************************************************
 * @Title        : CopyBytesWithChannel.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年4月30日 下午8:21:27
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class CopyBytesWithChannel {

	private static final int BSIZE = 1024;
	public static void main(String[] args) throws IOException {
		FileInputStream inStream = new FileInputStream("src\\com\\lixuan\\io\\myfile.txt");
		FileOutputStream outStream = new FileOutputStream("src\\com\\lixuan\\io\\myfileCopy.txt");
		
		FileChannel inChannel = inStream.getChannel();//获取该文件的输入流通道
		FileChannel outChannel = outStream.getChannel();//
		
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);//创建缓冲区
		while((inChannel.read(buffer)) != -1){
			buffer.flip();
			outChannel.write(buffer);
			buffer.clear();
		}
		
		inStream.close();
		outStream.close();
	}

}
