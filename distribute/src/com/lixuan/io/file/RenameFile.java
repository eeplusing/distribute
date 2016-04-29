package com.lixuan.io.file;

import java.io.File;
import java.util.Date;

/************************************************************************************
 * @Title        : RenameFile.java
 * @Todo         :<----功能描述---->
 * @Author       : Administrator
 * @DateTime     : 2016年4月29日 下午8:48:28
 * @Copyright    : 2016 LLC All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class RenameFile {

	private static void fileData(File file){
		System.out.println(
				"绝对路径：" + file.getAbsolutePath() + 
				"\n 可读：" + file.canRead() +
				"\n 可写：" + file.canWrite() + 
				"\n 文件名称：" + file.getName() + 
				"\n 问价路径：" + file.getPath() + 
				"\n 长度：" + file.length() + 
				"\n 最后修改日期：" + new Date(file.lastModified())
		);
		if(file.isFile()){
			System.out.println("这是一个文件");
		}else if(file.isDirectory()){
			System.out.println("这是一个目录");
		}
		
	}
	
	public static void main(String[] args) {
		File old = new File(args[0]);
		File rname = new File(args[1]);
		
		System.out.println("命名前文件信息：");
		fileData(old);
		
		old.renameTo(rname);
		System.out.println("修改后文件信息：");
		fileData(rname);		
		if(!old.exists()){
			System.out.println("原来的文件已被重命名");
		}
		
		
	}

}

/*************************个人总结****************************
	1.在dos中使用javac命令编译时，文件中不能含有中文
	2.main()方法中的参数 直接在类名后按顺序传入
/*****************************************************/