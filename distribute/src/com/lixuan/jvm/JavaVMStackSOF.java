 
package com.lixuan.jvm;  
/**  
 *VM args: -Xss128K //HotSpot虚拟机中不区分虚拟机栈和本地方法栈，所以-Xoos参数（设置本地方法栈大小）虽然存在但实际上无效
 *
 */
public class JavaVMStackSOF {
	private int stackLength = 1;
	
	public void stackLeak(){
		stackLength++;
		stackLeak();
	}
	
	public static void main(String[] args) throws Throwable{
		JavaVMStackSOF oom = new JavaVMStackSOF();
		
		try {
			oom.stackLeak();
		} catch (Throwable e) {
			System.out.println("stack length:" + oom.stackLength);
			throw e;  
		}
	}
}
  
