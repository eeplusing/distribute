package com.lixuan.corejava.ch13;

import java.util.HashMap;
import java.util.Map;

/************************************************************************************
 * @Title        : MapTest.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年6月26日 上午11:27:18
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class MapTest
{
	public static void main(String[] args)
	{
		Map<String, Employee> staff = new HashMap<String, Employee>();
		staff.put("144-35-56", new Employee("小明", 5000));
		staff.put("144-35-66", new Employee("大明", 6000));
		staff.put("144-35-77", new Employee("白明", 7000));
		staff.put("144-35-88", new Employee("黑明", 8000));
		
		System.out.println(staff);
		staff.remove("144-35-56");
		staff.put("144-35-88", new Employee("明明", 90000));
		System.out.println(staff.get("144-35-66"));
		
		for(Map.Entry<String, Employee> entry:staff.entrySet())
		{
			String key = entry.getKey();
			Employee value = entry.getValue();
			System.out.println("Key:" + key + ",value:" + value);
		}
		
		
	}

}
