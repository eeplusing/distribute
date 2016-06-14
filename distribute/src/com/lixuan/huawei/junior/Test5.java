package com.lixuan.huawei.junior;
import java.util.*;      
public class Test5{      
    public static void main(String[] args){      
        Scanner sc = new Scanner(System.in);      
        String str = sc.nextLine();      
        String ch = sc.nextLine();      
        int sum = 0;      
        for(int i = 0; i < str.length(); i++){      
            if(ch.toUpperCase().equals(String.valueOf(str.charAt(i))) || ch.toLowerCase().equals(String.valueOf(str.charAt(i))))      
                sum++;      
        }      
        System.out.println(sum);      
        sc.close();      
    }      
}   
