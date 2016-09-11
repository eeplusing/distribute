 
package com.lixuan.jd;  
import java.io.*;
import java.util.*;
import java.util.Map.Entry;
public class ShoppingMaxMinCost2
{
	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		while(scan.hasNextLine()){
			int m= scan.nextInt();
			int n= scan.nextInt();
			int[] prices=new int[m];
			String[] names=new String[n];
			Map<String,Integer> count =new HashMap<String,Integer>();
			for(int i=0;i<m;i++){
				prices[i]=scan.nextInt();
			}
			scan.nextLine();
			for(int i=0;i<n;i++){
				String name=scan.nextLine().trim();
				if(count.containsKey(name)){
					count.put(name, count.get(name)+1);
				}else{
					count.put(name, 1);
				}
			}
			Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
			List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(
					count.entrySet());
			Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>(){
				public int compare(Entry<String, Integer> o1,
						Entry<String, Integer> o2) {
					return o2.getValue().compareTo(o1.getValue());
				}			
			});
            Arrays.sort(prices);
            int max=0;
            int min=0;
            int max_index=prices.length-1;
            int min_index=0;
            for(Entry<String,Integer> entry:entryList){
            	max+=entry.getValue()*prices[max_index];
            	min+=entry.getValue()*prices[min_index];
            	max_index--;
            	min_index++;
            }
            System.out.print(min + " " + max);
		}
	}
}