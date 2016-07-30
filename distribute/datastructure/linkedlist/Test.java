 
package linkedlist;  
/**  
 * @ClassName:Test   
 * @Date:     2016年7月30日 下午9:06:05  
 * @Author    CAOPENG  
 * @Version   1.0 
 * @Since     JDK 1.8.0_45-b15 
 * @Right     Copyright (c) 2016, lixuan.com All Rights Reserved.   
 * @Todo      this java target 
 */
public class Test {
	public static void main(String[] args) {
		LinkList linkList = new LinkList();
		linkList.insertFirst(12);
		linkList.insertFirst(13);
		linkList.insertFirst(14);
		linkList.insertFirst(17);
		/*linkList.display();
		linkList.deleteFirst();
		linkList.deleteFirst();
		linkList.deleteFirst();
		linkList.deleteFirst();*/
		/*linkList.display();
		System.out.println();
		linkList.find(13).dispaly();
		System.out.println();
		linkList.delete(13);
		System.out.println();
		linkList.display();
		System.out.println();*/
		
		FirstLastLinkList flls = new FirstLastLinkList();
		/*flls.insertFirst(34);
		flls.insertFirst(35);
		flls.insertFirst(36);
		flls.insertFirst(37);
		flls.display();
		System.out.println();
		flls.deleteFirst();
		flls.display();*/
		
		/*flls.insertLast(84);
		flls.insertLast(85);
		flls.insertLast(86);
		flls.insertLast(87);
		flls.display();
		System.out.println();
		flls.deleteFirst();
		flls.display();
		flls.insertFirst(37);*/
		
		DoubleLinkList dll = new DoubleLinkList();
		dll.insertFirst(35);
		dll.insertFirst(45);
		dll.insertFirst(55);
		dll.insertFirst(65);
		dll.display();
		System.out.println();
		/*dll.deleteFirst();
		dll.deleteLast();*/
		//dll.display();
		
		while(!dll.isEmpty()){
			dll.deleteLast();
			dll.display();
			System.out.println();
		}
		
		
		
	}

}
  
