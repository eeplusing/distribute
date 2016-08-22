 
package multithread;  
public class Ticket extends Thread implements Runnable{
	private int tick = 20;
	private String name;
	private Ticket t;
	private boolean flag = true;
	private Object obj = new Object();
	
	public void run(){
		synchronized(obj){
			while(flag){
				if(tick > 0){
					System.out.println(currentThread().getName() + "出售票：" + tick--);
				}
				if(tick == 0){
					flag = false;
				}
			}
		}
	}
	
	public static void main(String[] args){
		Ticket t = new Ticket();//创建Runnable接口的子类对象
		Thread t1 = new Thread(t, "第一个售票员");
		Thread t2 = new Thread(t, "第二个售票员");
		Thread t3 = new Thread(t, "第三个售票员");
		Thread t4 = new Thread(t, "第四个售票员");
		
		t2.start();
		t1.start();
		t3.start();
		t4.start();
	}
}
  
