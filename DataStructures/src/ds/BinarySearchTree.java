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
	//Delete Node from BST
	public boolean delete(int node){
		TNode previous = root;
		TNode current = root;
		boolean isLeftChild = false;
		//Find deleted Node
		while(current.data!= node){
			previous = current;
			if(current.data > node){
				isLeftChild = true;
				current = current.left;
			}else{
				isLeftChild = false;
				current = current.right;
			}
			if(current == null){
				return false;
			}
		}
		//Case 1 if current node don't have childrens 
		if(current.left == null && current.right == null){
			if(current == null){
				root = null;
			}
			if(isLeftChild == true){
				previous.left = null;			
			}else{
				previous.right = null;				
			}
			return true;				
		}
		//Case2 : If current have one childs
		if(current.left == null || current.right == null){
			if(current == root){
				if(current.right == null){
					current.data = current.left.data;
					current.left = current.left.left;
					current.right = current.left.right;
				}else{
					current.data = current.right.data;
					current.left = current.right.left;
					current.right = current.right.right;
				}
			}
			if(isLeftChild == true){								
				if(current.left == null){
					previous.left = current.right;
				}else{
					previous.left = current.left;
				}				
			}else{
				if(current.right == null){
					previous.right = current.left;
				}else{
					previous.right = current.right;
				}
			}
		}
		//Case if current have 2 childs 
		if(current.left !=null && current.right != null){
			TNode successor = getSuccessor(current);			
			TNode nextLeft  = null;
			TNode nextRight = null;
			if (current == root){
				current = successor;
				current.left  = root.left;
				current.right = root.right;
			}else{
				nextLeft = current.left;
				nextRight =current.right;
				current.data = successor.data;
				current.right = nextRight;
				current.left  = nextLeft;
				return true;
			}			
		}
		
		return isLeftChild;
	}	
	public TNode getSuccessor(TNode node){
		TNode tempNode = node.right;
		TNode parent = node;
		while(tempNode.left!=null){
			parent = tempNode;
			tempNode = tempNode.left;		
		}
		if (node.right != tempNode){
			if(tempNode.right != null){
				parent.left = tempNode.right;
			}else{
				parent.left = null;
			}
		}else{
			parent.right = null;
		}
		return tempNode;
	}
}