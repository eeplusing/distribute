 
package com.lixuan.huaweiJiShi;  
import java.util.*;
public class Main2{	
	
	static int maxMatchNum=0;  
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String tstr=in.nextLine();
        int tnum = Integer.parseInt(tstr.split("\\s")[0]);
		 while(tnum-- > 0){  
		        int m,n;  
		        String mnstr=in.nextLine();
		        m = Integer.parseInt(mnstr.split("\\s")[0]);
		        n = Integer.parseInt(mnstr.split("\\s")[1]);
		        
		        Vector<Point> black;  
		        Vector<Point> white;  
		        String tempStr;
		        for(int i = 0; i < m; i++){  
		        	Point point = new Point();  
		        	tempStr=in.nextLine();
		        	point.x = Integer.parseInt(tempStr.split("\\s")[0]);
		        	point.y = Integer.parseInt(tempStr.split("\\s")[1]);
		            black.add(point);  
		        }  
		        for(int i=0;i<n;i++){  
		        	Point point = new Point();  
		        	tempStr=in.nextLine();
		        	point.x = Integer.parseInt(tempStr.split("\\s")[0]);
		        	point.y = Integer.parseInt(tempStr.split("\\s")[1]);
		            white.add(point);  
		        }  
		        countTheBestMatchNum(black,white);  
		        cout<<maxMatchNum<<endl;  
		        maxMatchNum=0;  
		    }  
	}
	
	public static void backHandle(int t){//用递归来实现回溯，t代表第t天
	    
	}
	
	
	
	public static int countTheMatchNum(Vector<Point> black, Vector<Point> white){  
		if(black.size()>=white.size())  
	        Permutation(black, white, 0, black.size() - 1);  
	    else   
	        Permutation(black,white, 0, white.size() - 1);  
		
		/* int matchNum=0;  
	    int size1=black_chess.size();  
	    int size2=white_chess.size();  
	    int len=size1<size2?size1:size2;  
	    for(int i=0;i<len;i++){  
	    if(black_chess.get(i).x <= white_chess.get(i).x && black_chess.get(i).y <= white_chess.get(i).y)  
	        matchNum++;  
	    }  
	    return matchNum;  */
	}  
	void Permutation(Vector<Point> black_chess,Vector<Point> white_chess,int begin, int end){  
	    if(begin==end){  
	        int matchNum = countTheMatchNum(black_chess,white_chess);  
	        if(maxMatchNum < matchNum){  
	            maxMatchNum = matchNum;  
	            return;  
	        }  
	    }  
	    else{  
	          
	        for(int i = begin; i < end; i++){  
	        	Point temp = *itr;  
	            *itr = *begin;  
	            *begin = temp;  
	            Permutation(black_chess,white_chess,begin+1,end);  
	            temp =*itr;  
	            *itr = *begin;  
	            *begin = temp;  
	        }  
	  
	    }  
	}  
	void countTheBestMatchNum(Vector<Vector> black,Vector<Vector> white){  
	    if(black.size()>=white.size())  
	    	 Permutation(black, white, 0, black.size() - 1);
	        Permutation(black,white,black.begin(),black.end());  
	    else   
	        Permutation(black,white,white.begin(),white.end());  
	}  
	
	
}
  
class Point{
	public int x;
	public int y;
}
