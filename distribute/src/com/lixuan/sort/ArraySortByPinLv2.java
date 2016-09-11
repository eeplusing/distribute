package com.lixuan.sort;
import java.util.*;
import java.util.Map.Entry;

/************************************************************************************
 * @Title        : Test.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年6月12日 下午7:42:39
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class ArraySortByPinLv2{
	public static void main(String[] args){
		int[] arr = {1,2,600000,600000,600000,2,200,200,600000,200,200,3,3,3,4,4,5,5,5,5,6,6,6,7,8,9,10,10000,10000,10000,10000};
		String result = process(arr);
		System.out.println(result);
	}
	
	public static String process(int[] arr){
		StringBuffer sb = new StringBuffer("[");
		
		/*将所有元素放入LinkedHashMap中*/
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();//Map的实现类，LinkedHashMap对插入的元素有先后顺序，
		for(int i = 0; i < arr.length; i++){
			if(map.containsKey(String.valueOf(arr[i]))){
				map.put(String.valueOf(arr[i]), map.get(String.valueOf(arr[i])) + 1);
			}else{
				map.put(String.valueOf(arr[i]), 1);
			}
		}
		
		/*使用Collections.sort()对list排序*/
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2){
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		
		/*将排序后的元素拼进StringBuffer中*/
		for(Entry<String, Integer> l:list){
			for(int i = 0; i < l.getValue(); i++){
				sb.append(l.getKey() + ",");
			}
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append("]");
		return sb.toString();
	}
}
