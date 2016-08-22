 
package multithread;

import com.sun.swing.internal.plaf.synth.resources.synth;

public class Foo {
	private int x = 100;
	public int getX(){
		return x;
	}
	/*public synchronized int fix(int y){
		x = x - y;
		System.out.println(Thread.currentThread().getName() + " : 当前foo.x = " + getX());
		return x;
	}*/
	public int fix(int y){
		synchronized(this){
			x = x - y;
			System.out.println(Thread.currentThread().getName() + " : 当前foo.x = " + getX());
			return x;
		}
	}
}
  
