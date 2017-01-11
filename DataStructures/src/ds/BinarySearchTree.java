package ds;

public class BinarySearchTree {
	
	public static  TNode root;
	
	public BinarySearchTree(){
		this.root = null;
	}
	//find and return this element
	public int find(int data){
		TNode node = root;
		
		while(node != null){
			if (node.data > data){
				node = node.left;
			}else if(node.data < data){
				node = node.right;
			}else{
				return node.data;
			}
		}
		
		return -1;
	}
	
	public void delete(int data){
		
	}
	
	//Insert based on < > without duplicated nodes . 
	public boolean insert(int data){
		TNode current = root;
		TNode previous = root;
		TNode node ;
		
		if(BinarySearchTree.root == null){
			node = new TNode(data);
			root = node;
			return true;
		}else{
			while(current != null){
				if(current.data < data){
					previous = current;
					current = current.right;
				}else if(current.data > data){
					previous = current;
					current = current.left;					
				}else{
					return false;
				}
			}
			
			node = new TNode(data);
		
		if(previous.data > node.data){
			previous.left = node;
		}else{
			previous.right =node;
		}
		return true;
		
		}			
	}
	//Display all the nodes in increasing order 
	public void display(TNode root){
		if(root!=null){
			display(root.left);
			System.out.print(" " + root.data);
			display(root.right);
		}
	}
}
