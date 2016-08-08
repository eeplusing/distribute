 
package hashtable;

import java.math.BigInteger;

/**  
 * @ClassName:HashTable   
 * @Date:     2016年8月7日 下午7:46:40  
 * @Author    CAOPENG  
 * @Version   1.0 
 * @Since     JDK 1.8.0_45-b15 
 * @Right     Copyright (c) 2016, lixuan.com All Rights Reserved.   
 * @Todo      this java target 
 */
public class HashTable {
	private Info[] arr;
	
	public HashTable(){
		arr = new Info[100];
	}
	
	public HashTable(int maxSize){
		arr = new Info[maxSize];
	}
	
	public void insert(Info info){
		String key = info.getKey();
		int hashVal = hashCode(key);
		while(arr[hashVal] != null && arr[hashVal].getName() != null){
			++hashVal;
			hashVal %= arr.length;
		}
		arr[hashVal] = info;
	}
	
	public Info find(String key){
		int hashVal = hashCode(key);
		while(arr[hashVal] != null){
			if(arr[hashVal].getKey().equals(key)){
				return arr[hashVal];
			}
			++hashVal;
			hashVal %= arr.length;
		}
		return null;
	}
	
	/***
	 * 删除数据
	 */
	public Info delete(String key){
		int hashVal = hashCode(key);
		while(arr[hashVal] != null){
			if(arr[hashVal].getKey().equals(key)){
				Info temp = arr[hashVal];
				arr[hashVal].setName(null); 
				return temp;
			}
			++hashVal;
			hashVal %= arr.length;
		}
		return null;
	}
	

	public int hashCode(String key){
		BigInteger hashVal = new BigInteger("0");
		BigInteger pow27 = new BigInteger("1");
		
		for(int i = key.length() - 1; i > 0; i--){
			int letter = key.charAt(i) - 96;
			BigInteger letterBI = new BigInteger(String.valueOf(letter));
			hashVal = hashVal.add(letterBI.multiply(new BigInteger(String.valueOf(27))));
			pow27 = pow27.multiply(new BigInteger(String.valueOf(27)));
		}
		return hashVal.mod(new BigInteger(String.valueOf(arr.length))).intValue();
	}
	
	
	
	
}
  
