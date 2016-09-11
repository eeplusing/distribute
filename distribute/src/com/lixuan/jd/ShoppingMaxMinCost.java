 
package com.lixuan.jd;  
import java.io.*;
import java.util.*;
import java.util.Map.Entry;
public class ShoppingMaxMinCost
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n, m;
        while(in.hasNext())
        {
        	n = in.nextInt();//价格标签数
        	m = in.nextInt();//商品个数
        	
        	List<Integer> prices = new ArrayList<Integer>();
        	Map<String, Integer> items = new HashMap<String, Integer>();
        	
        	for(int i = 0; i < n; i++){
        		prices.add(in.nextInt());
        	}
        	Collections.sort(prices, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2.compareTo(o1);
				}
			});
        	
            for(int i = 0; i < m; i++){
            	String name = in.next();
            	if(items.containsKey(name)){
            		int sum = items.get(name);
            		items.put(name, sum+1);
            	}else{
            		items.put(name, 1);
            	}
            }
            
            List<Map.Entry<String, Integer>> listItem = new ArrayList<Map.Entry<String, Integer>>(items.entrySet());
    		Collections.sort(listItem, new Comparator<Map.Entry<String, Integer>>() {
    			@Override
    			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2){
    				return o2.getValue().compareTo(o1.getValue());
    			}
    		});
            
    		int max = 0;
    		int min = 0;
    		int indexF = 0;
    		int indexE = n - 1;
    		for(Map.Entry<String, Integer> it:listItem){
    			max += it.getValue() * prices.get(indexF++);
    			min += it.getValue() * prices.get(indexE--);
    		}
    		
            System.out.println(min + " " + max);
        }
    }
}