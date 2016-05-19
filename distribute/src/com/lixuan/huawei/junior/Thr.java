package com.lixuan.huawei.junior;

import java.util.Scanner;
public class Thr extends Thread {  
    int id;  
    private static Object lock=new Object();  
    static int n=1;  
    static int input;  
      
    public Thr(int id){  
        this.id=id;  
    }  
      
      
    public static void main(String[] args) {  
        Scanner scan=new Scanner(System.in);  
        input=scan.nextInt();  
        Thr t1=new Thr(1);  
        Thr t2=new Thr(2);  
        Thr t3=new Thr(3);  
        Thr t4=new Thr(0);  
          
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