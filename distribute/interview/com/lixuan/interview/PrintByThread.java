package com.lixuan.interview;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;
/**  
 * @ClassName:PrintByThread   
 * @Date:     2016年8月1日 下午2:56:48  
 * @Author    CAOPENG  
 * @Version   1.0 
 * @Since     JDK 1.8.0_45-b15 
 * @Right     Copyright (c) 2016, lixuan.com All Rights Reserved.   
 * @Todo      this java target 
 */
/*
一个文件中有10000个数，用Java实现一个多线程程序将这个10000个数输出到5个不同文件中（不要求输出到每个文件中的数量相同）。
要求启动10个线程，两两一组，分为5组。
每组两个线程分别将文件中的奇数和偶数输出到该组对应的一个文件中，
需要偶数线程每打印10个偶数以后，就将奇数线程打印10个奇数，如此交替进行。
同时需要记录输出进度，每完成1000个数就在控制台中打印当前完成数量，并在所有线程结束后，在控制台打印”Done”.
*/
/**
* 分析：可以将10000个数分成5份，每一份（2000个数）对应一组，即两个线程，来分别输出这一份的奇数和偶数，
* 同时声明一个共享变量，用于统计当前所有线程输出的个数，反映记录的输出进度
*/
public class PrintByThread {
	public static void main(String[] args) {
        try {
            //创建一个包含10000数字的输入文件
            PrintWriter pw = new PrintWriter(new FileWriter(new File("interview/com/lixuan/interview/input.txt")),true);
            Random random = new Random();
            System.out.println(random.nextInt());
            for(int i = 0; i < 10000; i++){
                pw.print(Math.abs(random.nextInt())%100+",");
            }
            pw.flush();
            pw.close();
            //读取文件中的数字，分5次读取，每次读取2000个
            BufferedReader reader = new BufferedReader(new FileReader("interview/com/lixuan/interview/input.txt"));
            String str = reader.readLine();
            reader.close();
            String[] strs = str.split(",");//将一行字符串全部解析为10000个数字
            
            int j = 0;//10000个数的索引计数
            for(int i = 0; i < 5; i++){
                int records[]=new int[2000];
                for (int k = 0; k < 2000; k++){
                    records[k]=Integer.parseInt(strs[j]);
                    j++;
                }
                //定义输出文件
                PrintWriter writer =new PrintWriter(new FileWriter(new File("interview/com/lixuan/interview/output"+i+".txt")),true);
                //定义实现的方法
                ThreadGroup group=new ThreadGroup(records, writer);
                //开启一对儿线程
                new Thread(group).start();
                new Thread(group).start();             
            }         
             
        } catch (Exception e) {
            // TODO: handle exception
        }      
    } 
}

class ThreadGroup implements Runnable{
	//所有类对象共享的同一个计数器count，记录总共输出的记录总数
	private static int count=0;
	//所有的ThreadGroup类对象共享一个锁，用于count变量的同步，任何一个线程需要修改count变量，必须取得该锁
	private static Object lock=new Object();
	public static final int EVEN=0;//代表偶数
	public static final int ODD=1;//代表奇数
	//*********以上静态变量，属于整个类所有***********
	
	private int type;
	private int records[];
	private PrintWriter writer;//每组共享一个writer，输出到同一个文件
	private int oddPoint=0;//记录每次打印奇数的起始位置
	private int evenPoint=0;//记录每次打印偶数的起始位置
	 
	public ThreadGroup(int[] records,PrintWriter writer){
	    this.records=records;
	    this.writer=writer;
	    this.type=EVEN;
	}
	 
	//线程方法实现
	public void run(){
	    while(print());
	}
	
	private synchronized boolean print(){
        for(int i=0;i<10;){
            //如果奇数和偶数都打印完成以后，就直接停止打印循环，等待该线程自己结束
            if(oddPoint >= records.length && evenPoint >= records.length) {
                notifyAll();
                return false;
            }
            //如果该线程该打印奇数，但奇数已经打印完了，就直接停止本次10个数的打印，
            //同理偶数，等下次切换打印类型后，再开始打印另外一种类型
            if((oddPoint >= records.length && type==ODD)||(evenPoint >= records.length && type==EVEN)) {
                break;
            }
            //判断开始打印偶数
            if(type==EVEN) {
                if (records[evenPoint]%2==0) {
                    i++;
                    writer.print(records[evenPoint]+",");
                    writer.flush();
                    //锁定全局变量方便线程输出后计数
                    synchronized (lock) {
                        count++;
                        if (count%1000==0) {
                            System.out.println("当前完成数量："+count);
                            if (count==10000) {
                                System.out.println("Done!");
                            }
                        }
                    }
                }
                //无论是否是偶数，打印成功一个后，偶数的起始位置都要后移
                evenPoint++;
            }else {
                //打印奇数
                if (records[oddPoint]%2==1) {
                    i++;
                    writer.print(records[oddPoint]+",");
                    writer.flush();
                    //锁定全局变量方便线程输出后计数
                    synchronized (lock) {
                        count++;
                        if (count%1000==0) {
                            System.out.println("当前完成数量："+count);
                            if (count==10000) {
                                System.out.println("Done!");
                            }
                        }
                    }
                }
                //无论是否是奇数，打印成功一个后，偶数的起始位置都要后移
                oddPoint++;
            }
             
        }
        type = ~type;//切换打印类型
        notifyAll();//一组中的任一线程打印完后唤醒另一个线程
        try {
            wait();//释放锁进入等待状态，等待另一线程打印
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }
}
  
