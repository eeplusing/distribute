 
package linkedlist;  
/**  
 * @ClassName:LinkList   
 * @Date:     2016年7月30日 下午8:55:10  
 * @Author    CAOPENG  
 * @Version   1.0 
 * @Since     JDK 1.8.0_45-b15 
 * @Right     Copyright (c) 2016, lixuan.com All Rights Reserved.   
 * @Todo      this java target 
 */
public class LinkList {
	private Node first;
	public LinkList(){
		first = null;
	}
	/*//插入一个结点，在头结点后插入
	public void insertFirst(long value){
		Node node = new Node(value);
		if(first == null){
			first = node;
		}else{
			node.next = first.next;
			first.next = node;
		}
	}*/
	/*//删除一个结点,在头结点后删除
	public Node deleteFirst()
	{
		if(first.next == null){
			Node node = first;
			first = null;
			return node;
		}else{
			Node node = first.next;
			first = node;
			return node;
		}
	}*/
	//插入一个结点，在头结点前插入
	public void insertFirst(long value){
		Node node = new Node(value);
		node.next = first;//将新节点指向头结点
		first = node;    //更新头结点
	}
	//删除一个结点,删除头结点
	public Node deleteFirst()
	{
		Node node = first;
		first = node.next;
		return node;
	}
	public Node delete(int value)
	{
		Node current = first;
		Node previous = first;
		while(current.data != value){
			if(current.next == null){
				return null;
			}
			previous = current;
			current = current.next;
		}
		if(current.equals(first)){
			first = first.next;
		}else{
			previous.next = current.next;
		}
		return current;
	}
	
	public Node find(int value){
		Node current = first;
		while(current.data != value){
			if(current.next == null){
				return null;
			}
			current = current.next;
		}
		return current;
	}
	
	public void display(){
		Node current = first;
		while(current != null){
			current.dispaly();
			current = current.next;
		}
	}
}
  
