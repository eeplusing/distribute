 
package linkedlist;  
public class TreeTest {
	public static void main(String[] args) {
		BinarryTree tree = new BinarryTree();
		tree.insert(23, "kobe");
		tree.insert(12, "newton12");
		tree.insert(67, "mayun");
		tree.insert(70, "小明");
		tree.insert(72, "小明");
		tree.insert(56, "老王");
		tree.insert(9, "老王3");
		tree.insert(34, "老王5");
		tree.insert(18, "老王7");
		tree.insert(68, "老王68");
		/*System.out.println(tree.root.data);
		System.out.println(tree.root.leftChild.leftChild.data);
		TreeNode find;
		find = tree.find(12);
		System.out.println(find.data + ":" + find.name);
		System.out.println("前序遍历：");
		tree.frontOrder(tree.root);
		System.out.println("中序遍历：");
		tree.middleOrder(tree.root);
		System.out.println("后序遍历：");
		tree.endOrder(tree.root);*/
		
		//删除叶子节点
		System.out.println("删除前：");
		tree.frontOrder(tree.root);
		tree.delete(12);
		System.out.println("删除后：");
		tree.frontOrder(tree.root);
	}
}
  
