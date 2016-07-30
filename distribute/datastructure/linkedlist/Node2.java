 
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
public class Node2 {
	//数据域
	public long data;
	//前驱
	public Node2 previous;
	//后继
	public Node2 next;
	public Node2(long value){
		this.data = value;
	}
	public void dispaly(){
		System.out.print(data + " ");
	}
}
  
