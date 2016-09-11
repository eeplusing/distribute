 
package com.lixuan.jvm;

import com.lixuan.huawei.junior.IsAllCharExist;

/**  
 *
 */
public class FinalizeEscapeGC {
	public static FinalizeEscapeGC SAVE_HOOK = null;
	public void isAlive(){
		System.out.println("yes i am still alive");
	}
	public static void main(String[] args) throws Throwable {
		SAVE_HOOK = new FinalizeEscapeGC();
		
		/*对象第一次成功拯救自己*/
		SAVE_HOOK = null;
		System.gc();//调用对象的finalize()
		Thread.sleep(500);//Finalizer方法优先级很低
		if(SAVE_HOOK != null){
			SAVE_HOOK.isAlive();
		}else{
			System.out.println("I am dead");
		}
		
		/*对象第二次拯救自己失败*/
		SAVE_HOOK = null;
		System.gc();
		Thread.sleep(500);
		if(SAVE_HOOK != null){
			SAVE_HOOK.isAlive();
		}else{
			System.out.println("I am dead");
		}
	}
	
	@Override
	public void finalize() throws Throwable{
		super.finalize();
		System.out.println("finalize() executed");
		FinalizeEscapeGC.SAVE_HOOK = this;
	}
}
  
