package com.lixuan.huawei.junior;

import java.util.Scanner;

/*有4个线程和1个公共的字符数组。线程1的功能就是向数组输出A，线程2的功能就是向字符输出B，
 线程3的功能就是向数组输出C，线程4的功能就是向数组输出D。
 要求按顺序向数组赋值ABCDABCDABCD，ABCD的个数由线程函数1的参数指定。*/
public class ThreadDemo extends Thread {  
    int id;  
    private static Object lock=new Object();  
    static int n=1;  
    static int input;  
      
    public ThreadDemo(int id){  
        this.id=id;  
    }  
      
      
    public static void main(String[] args) {  
        Scanner scan=new Scanner(System.in);  
        input=scan.nextInt();  
        ThreadDemo t1=new ThreadDemo(1);  
        ThreadDemo t2=new ThreadDemo(2);  
        ThreadDemo t3=new ThreadDemo(3);  
        ThreadDemo t4=new ThreadDemo(0);  
          
        t1.start();  
        t2.start();  
        t3.start();  
        t4.start();   
    }  
      
    public void run(){  
        for(int i=0;i<input;i++){  
            synchronized (lock) {  
                while(n%4!=id){  
                    try {  
                        lock.wait();  
                    } catch (InterruptedException e) {  
                        e.printStackTrace();  
                    }  
                }  
                  
                if(id==1){  
                    System.out.print("A");  
                }  
                  
                if(id==2){  
                    System.out.print("B");  
                }  
                  
               if(id==3){  
                    System.out.print("C");  
                }  
                  
                if(id==0){  
                    System.out.print("D");  
                }  
                  
                n++;  
                lock.notifyAll();  
            }  
        }  
    }  
}  