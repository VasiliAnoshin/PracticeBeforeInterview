package ds;

public class BinarySearchTree {
	
	public static  TNode root;
	
	public BinarySearchTree(){
		this.root = null;
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
					current = current.right;					
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

}
