package com.lixuan.huawei.junior;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class NiceLevel {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        String[] names=new String[N];
        for (int i = 0; i < N; i++) {
            names[i]=sc.next();
            System.out.println(beautyfulNames(names[i]));
        }
        sc.close();
    }

    public static int beautyfulNames(String name){
        char[] c=name.toCharArray();
        /*Key:字母, Value:字母出现的次数*/
        Map<Character, Integer> map=new HashMap<Character,Integer>();
        for (int i = 0; i < c.length; i++) {
            if (map.containsKey(c[i])) {
                map.put(c[i], map.get(c[i])+1);
            }else {
                map.put(c[i], 1);
            }       
        }

        
        List<Map.Entry<Character, Integer>> list = 
        		new ArrayList<Map.Entry<Character,Integer>>(map.entrySet());
        
        Collections.sort(list,new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> o1,Map.Entry<Character, Integer> o2){
                return o2.getValue().compareTo(o1.getValue());//降序排列
            }
        });

        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            result = result+list.get(i).getValue()*(26-i);
        }
        return result;

    }

}