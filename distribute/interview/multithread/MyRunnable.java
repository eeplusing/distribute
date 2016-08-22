 
package multithread;  
public class MyRunnable implements Runnable {
	public static void main(String[] args) {
		MyRunnable run = new MyRunnable();
		Thread t1 = new Thread(run, "Thread-A");
		Thread t2 = new Thread(run, "Thread-B");
		t1.start();
		t2.start();
	}
	private Foo foo = new Foo();
	public void run(){
		for(int i = 0; i < 3; i++){
			this.fix(30);
			try{
				Thread.sleep(1);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public int fix(int y){
		return foo.fix(y);
	}

}
  
