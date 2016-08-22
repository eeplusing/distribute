 
package multithread;  
public class SailTicket implements Runnable {
	private static int num = 300;
	private static Object obj = new Object();
	
	@Override
	public void  run() {
		synchronized(obj){
			while(true){
				if(num > 0){
					System.out.println(Thread.currentThread().getName() + "正在售票:" + num);
					num--;
				}
				else{
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		SailTicket st1 = new SailTicket();
		SailTicket st2 = new SailTicket();
		SailTicket st3 = new SailTicket();
		
		Thread t1 = new Thread(st1);
		Thread t2 = new Thread(st2);
		Thread t3 = new Thread(st3);
		
		t1.start();
		t2.start();
		t3.start();
	}
}
  
