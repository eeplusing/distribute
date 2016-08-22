 
package com.lixuan.interview;

import java.util.HashSet;

/**  
 * @ClassName:JianBaoShi   
 * @Date:     2016年8月2日 上午11:55:51  
 * @Author    CAOPENG  
 * @Version   1.0 
 * @Since     JDK 1.8.0_45-b15 
 * @Right     Copyright (c) 2016, lixuan.com All Rights Reserved.   
 * @Todo      this java target 
 */
/**
 *  小明陪小红去看钻石，他们从一堆钻石中随机抽取两颗并比较她们的重量。这些钻石的重量各不相同。在他们们比较了一段时间后，它们看中了两颗钻石g1和g2。现在请你根据之前比较的信息判断这两颗钻石的哪颗更重。
	给定两颗钻石的编号g1,g2，编号从1开始，同时给定关系数组vector,其中元素为一些二元组，第一个元素为一次比较中较重的钻石的编号，第二个元素为较轻的钻石的编号。最后给定之前的比较次数n。请返回这两颗钻石的关系，若g1更重返回1，g2更重返回-1，无法判断返回0。输入数据保证合法，不会有矛盾情况出现。
	测试样例：
	2,3,[[1,2],[2,4],[1,3],[4,3]],4
	返回: 1
	
	思路：1.找出所有比g1重的钻石编号构成集合A和比g1轻的钻石编号构成集合B
		2.如果A中包含g2，则返回-1;
		     如果B中包含g2，则返回1;
		     如果A,B中都不包含g2，则比较关系不足，无法判断;
			
 ***/
public class JianBaoShi{
	public static void main(String[] args){  
        // TODO Auto-generated method stub  
        int[][] records = { { 1, 2 }, { 2, 4 }, { 1, 3 }, { 4, 3 } };  
        System.out.println(cmp(2, 3, records, 4));  
    }  
  
    public static int cmp(int g1, int g2, int[][] records, int n){  
    	HashSet<Integer> max = new HashSet<>(); //记录比g1重的编号 
        HashSet<Integer> min = new HashSet<>(); //记录比g1轻的编号 
        /*记录与g1比较过的编号，并按照是否比g1重进行记录*/
        for (int i = 0; i < n; i++){  
            if (records[i][0] == g1){  
                min.add(records[i][1]);  
            }  
            if (records[i][1] == g1){  
                max.add(records[i][0]);  
            }  
        }  
        /*记录没有与g1比较过的编号，并按照是否比g1重进行记录*/
        for (int i = 0; i < n; i++){  
            if (records[i][0] != g1 && records[i][1] != g1){  
                if(max.contains(records[i][1])){  
                    max.add(records[i][0]);  
                }  
                if(min.contains(records[i][0])){  
                    min.add(records[i][1]);  
                }  
            }  
        }  
  
        if (max.contains(g2) && !min.contains(g2)) {  
            return -1;  
        } else if (!max.contains(g2) && min.contains(g2)) {  
            return 1;  
        } else  
            return 0;  
    }
}
  
