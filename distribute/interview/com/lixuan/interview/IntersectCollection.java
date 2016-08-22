 
package com.lixuan.interview;
import java.util.ArrayList;
import java.util.List;
public class IntersectCollection {
	static List<Range> listResultRange = new ArrayList<Range>();
	public static void main(String[] args){
		String str1 = "{[4,8],[9,13]}";
		String str2 = "{[6,12]}";
		String[] arr1 = str1.replace("{", "").replace("}", "").replace("[", "").replace("]", "").split(",");
		String[] arr2 = str2.replace("{", "").replace("}", "").replace("[", "").replace("]", "").split(",");
		System.out.println(arr1.length);
		process(arr1, arr2);
		if(listResultRange.size() > 0){
			for(Range r:listResultRange){
				System.out.print(r);
			}
		}
	}

	/**  
	 *
	 */
	private static void process(String[] arrA, String[] arrB) {
		Range tempA;
		Range tempB;
		for(int i = 0; i < arrA.length; i += 2){
			tempA = new Range(Integer.parseInt(arrA[i]), Integer.parseInt(arrA[i + 1]));
			for(int j = 0; j < arrB.length; j += 2){
				tempB = new Range(Integer.parseInt(arrB[j]), Integer.parseInt(arrB[j + 1]));
				if(null != Range.intersect(tempA, tempB)){
					listResultRange.add(Range.intersect(tempA, tempB));
				}
			}
		}
	}
}

class Range{
    public int start;  
    public int end;
    public Range(int start, int end){
         this.start = start;
         this.end = end;  
    }
   
	@Override
	public String toString() {
		return "[" + start + "," + end + "]";
	}

	public Range(){}
	public static Range intersect(Range a, Range b){
        if(b.start <= a.start){
            if(b.end <= a.start){
                return null;                
            }
            if(b.end >= a.start && b.end <= a.end){
                return new Range(a.start, b.end);
            }
            if(b.end >= a.end){
                return a;
            }
            return null;
        }
        
        if(b.start > a.start && b.start < a.end){  
        	if(b.end <=  a.end){
        		return b;    
        	}else{
        		return new Range(b.start, a.end);
        	}
        }
        
        if(b.start >= a.end){
        	return null;
        }
        return null;
    }
}
