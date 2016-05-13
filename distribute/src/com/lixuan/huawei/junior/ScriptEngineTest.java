package com.lixuan.huawei.junior;
import java.text.MessageFormat;
import java.text.NumberFormat;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
/************************************************************************************
 * @Title        : Test.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月6日 下午10:03:26
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class ScriptEngineTest {

	public static void main(String[] args) throws ScriptException {
		int n = 128;
		int m = 24;
		
		 ScriptEngineManager manager = new ScriptEngineManager();  
		 ScriptEngine engine = manager.getEngineByName("js");
	     Object o = engine.eval(m + "+" + n);
	     System.out.println(o.toString());

	}
	
	

}
