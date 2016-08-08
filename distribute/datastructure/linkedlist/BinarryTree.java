 
package linkedlist;  
/**  
 * @ClassName:BinarryTree   
 * @Date:     2016年8月6日 下午9:31:54  
 * @Author    CAOPENG  
 * @Version   1.0 
 * @Since     JDK 1.8.0_45-b15 
 * @Right     Copyright (c) 2016, lixuan.com All Rights Reserved.   
 * @Todo      this java target 
 */
public class BinarryTree {
	//根节点
	public TreeNode root;
	
	//插入节点
	public void insert(long value, String name){
		//构造节点
		TreeNode node = new TreeNode(value, name);
		//当前节点（初始的当前节点为根节点）
		TreeNode current = root;
		//父节点
		TreeNode parent;
		if(null == root){
			root = node;
			return;
		}else{
			while(true){
				//父节点指向当前节点
				parent = current;
				if(current.data > value){
					current = current.leftChild;
					if(null == current){
						parent.leftChild = node;
						return;
					}
				}else{
					current = current.rightChild;
					if(current == null){
						parent.rightChild = node;
						return;
					}
				}
			}
			
		}
	}
	
	
	//删除节点
	public boolean delete(long value){
		//引用当前节点从根节点开始
		TreeNode current = root;
		//引用当前节点的父节点
		TreeNode parent = root;
		//是否为左节点
		boolean isLeftChild = true;
		while(current.data != value){
			/*比较查找值与当前节点的值的大小*/
			parent = current;
			if(current.data > value){
				current = current.leftChild;
				isLeftChild = true;
			}else{
				current = current.rightChild;
				isLeftChild = false;
			}
			if(null == current){
				return false;
			}
		}
		
		/*如果要删除的节点是叶子节点*/
		if(null == current.leftChild && null == current.rightChild){
			if(current == root){
				root = null;
			}else if(isLeftChild){ 		/*如果是左子节点*/
				parent.leftChild = null;
			}else{
				parent.rightChild = null;
			}
		}else if(null == current.rightChild){ /*如果要删除的节点只有左子节点*/
			if(current == root){
				root = current.leftChild;
			}else if(isLeftChild){
				parent.leftChild = current.leftChild;
			}else{
				parent.rightChild = current.leftChild;
			}
		}else if(null == current.leftChild){ /*如果要删除的节点只有右子节点*/
			if(current == root){
				root = current.rightChild;
			}else if(isLeftChild){
				parent.leftChild = current.rightChild;
			}else{
				parent.rightChild = current.rightChild;
			}
		}else{                         /*如果要删除的节点既有左子节点也有右子节点*/
			TreeNode successor = getSuccessor(current);
			if(current == root){
				root = successor;
			}else if(isLeftChild){
				parent.leftChild = successor;
			}else{
				parent.rightChild = successor;
			}
			successor.leftChild = current.leftChild;
		}
		
		return true;
		
		
	}
	//查找节点
	public TreeNode find(long value){
		TreeNode current = root;
		while(current.data != value){
			if(current.data > value){
				current = current.leftChild;
			}else{
				current = current.rightChild;
			}
			if(null == current){
				return null;
			}
		}
		return current;
	}
	
	/**
	 * 前序遍历
	 * */
	public void frontOrder(TreeNode localNode){
		if(localNode != null){
			System.out.println(localNode.data + ":" + localNode.name);
			//前续遍历左子树
			frontOrder(localNode.leftChild);
			//前续遍历右子树
			frontOrder(localNode.rightChild);
		}
	}
	/**
	 * 中序遍历
	 * */
	public void middleOrder(TreeNode localNode){
		if(localNode != null){
			//前续遍历左子树
			middleOrder(localNode.leftChild);
			//打印中间节点
			System.out.println(localNode.data + ":" + localNode.name);
			//前续遍历右子树
			middleOrder(localNode.rightChild);
		}
	}
	/**
	 * 后序遍历
	 * */
	public void endOrder(TreeNode localNode){
		if(localNode != null){
			//前续遍历左子树
			endOrder(localNode.leftChild);
			//前续遍历右子树
			endOrder(localNode.rightChild);
			System.out.println(localNode.data + ":" + localNode.name);
		}
	}
	
	/**
	 * 查找中序后继节点
	 * */
	public TreeNode getSuccessor(TreeNode deleteNode){
		TreeNode successor = deleteNode;
		TreeNode successorParent = deleteNode;
		TreeNode current = deleteNode.rightChild;
		
		/*查找中序后继节点*/
		while(current != null){
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}
		
		if(successor != deleteNode.rightChild){
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = deleteNode.rightChild;
		}
		System.out.println(successor);
		return successor;
	}
	
}
  
