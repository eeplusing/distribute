 
package linkedlist;  
/**  
 *二叉树结点
 */
public class TreeNode {
	public long data;
	public String name;
	public TreeNode leftChild;
	public TreeNode rightChild;
	public TreeNode(long data){
		this.data = data;
	}
	public TreeNode(long data, String name){
		this.data = data;
		this.name = name;
	}
	/**  
	 * TODO  
	 * @see java.lang.Object#toString()  
	 */
	@Override
	public String toString() {
		return "TreeNode [data=" + data + ", name=" + name + "]";
	}
	
}
  
