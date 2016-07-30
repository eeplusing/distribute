 
package linkedlist;  
/**  
 * @ClassName:Node   
 * @Date:     2016年7月30日 下午8:40:22  
 * @Author    CAOPENG  
 * @Version   1.0 
 * @Since     JDK 1.8.0_45-b15 
 * @Right     Copyright (c) 2016, lixuan.com All Rights Reserved.   
 * @Todo      this java target 
 */
public class Node {
	//数据域
	public long data;
	//指针域
	public Node next;
	
	public Node(long value){
		this.data = value;
	}
	public void dispaly(){
		System.out.print(data + " ");
	}
}
  
