 
package com.lixuan.jvm;  
/**  
 *VM args: -Xss128K //HotSpot虚拟机中不区分虚拟机栈和本地方法栈，所以-Xoos参数（设置本地方法栈大小）虽然存在但实际上无效
 *
 */
public class JavaVMStackSOF1 {
	private int stackLength = 1;
	
	private void dontStop(){
		while(true){
			
		}
	}
		
	
	public void stackLeakByThread(){
		Thread thread = new Thread(new Runnable(){
			@Override
			public void run() {
				dontStop();
			}
			
		});
		thread.start();
	}
	
	public static void main(String[] args) throws Throwable{
		JavaVMStackSOF1 oom = new JavaVMStackSOF1();
		oom.stackLeakByThread();
	}
}
  
