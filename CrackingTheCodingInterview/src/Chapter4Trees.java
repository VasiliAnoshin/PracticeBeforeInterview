import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.Collections;


public class Chapter4Trees {
	//For checkPoint
	private Hashtable<Integer,Integer>  messagesList = new Hashtable<Integer,Integer>();
	private static final int  counter = 1;
	public enum condition {
		True (1) , 
		False(0);
		public int value;
		
		private condition(int value){
			this.value = value;
		}
	}
	// 4.1 Route between nodes : given a directed graph , design an algorithm to find out whether 
	//the is a root between two nodes : 
	public static class DiGraph<T>{
		HashMap<T,List<T>> map = new HashMap<T,List<T>>(); 
	
		public void addVertex(T vertex){
			if (map.containsKey(vertex)){
				return ;
			}
			map.put(vertex, new ArrayList());
		}
		 /**
	     * String representation of graph.
	     */
	    public String toString () {
	        StringBuffer s = new StringBuffer();
	        for (T v: map.keySet()) s.append("\n    " + v + " -> " + map.get(v));
	        return s.toString();                
	    }
	    /**
	     * Add an edge to the graph; if either vertex does not exist, it's added.
	     * This implementation allows the creation of multi-edges and self-loops.
	     */
	    public void add (T from, T to) {
	        this.addVertex(from); this.addVertex(to);
	        map.get(from).add(to);
	    }
	}
	
	/**4.2  Balanced tree : a height-balanced binary tree is defined as a binary 
	tree in which the depth of the two subtrees of every node never differ by more than 1
	- write an algorithm to create a binary search tree with minimal height from array. 
	*/
	public TreeNode sortedArrayToBST(final List<Integer> a) {
			return getTreeNode(a, 0 , a.size()-1);
		}
		public TreeNode getTreeNode(List<Integer> arr ,int start , int end){		
			if(end < start){
				return null;
			}
			
			int middle = (start + end ) / 2;
			TreeNode root = new TreeNode(arr.get(middle));
			root.left  = getTreeNode(arr, start, middle - 1);
			root.right = getTreeNode(arr, middle + 1, end);
			return root;
	}
	/**https://www.interviewbit.com/problems/flatten-binary-tree-to-linked-list/
	  #Given a binary tree, flatten it to a linked list in-place.
	      1
         / \
        2   5
       / \   \
      3   4   6
      
      The flattened tree should look like:
       
       1
	    \
	     2
	      \
	       3
	        \
	         4
	          \
	           5
	            \
	             6
	 */
		public TreeNode flatten(TreeNode a) {			    
			    Queue<TreeNode> queue = new LinkedList<TreeNode>();
			    preorder(queue, a);			    
			    if (queue.isEmpty())
			        return a;			    
			    TreeNode node = queue.remove();
			    TreeNode next;
			    a = node;			    
			    while (!queue.isEmpty()) {
			        next = queue.remove();
			        node.left = null;
			        node.right = next;
			        next.left = null;
			        node = next;
			    }			    
			    return a;			    
			}						
		public void preorder(Queue<TreeNode> queue, TreeNode node) {
		    
		    if (node == null)
		        return;
		    
		    queue.add(node);
		    preorder(queue, node.left);
		    preorder(queue, node.right);
		    
		}
		/**#4.5
		 Given a binary tree, determine if it is a valid binary search tree (BST).
		 Assume a BST is defined as follows:
		 The left subtree of a node contains only nodes with keys less than the node’s key.
		 The right subtree of a node contains only nodes with keys greater than the node’s key.
		 Both the left and right subtrees must also be binary search trees.
		 Example :			
		 Input : 
		   1
		  /  \
		 2    3			
		Output : 0 or False				
		Input : 
		  2
		 / \
		1   3			
		Output : 1 or True  		 
		 */
		public int isValidBST(TreeNode a) {			
			return isValid(a,null , null) ;
		}
		public int isValid(TreeNode rootT,TreeNode min, TreeNode max){
			//Stop condition 
			if(rootT == null) { 
				return 1;
				}
			if((min !=null && rootT.val <= min.val) || (max != null && rootT.val > max.val)){
				return 0;
			}
			if( isValid(rootT.left, min , rootT) != 1 || isValid(rootT.right, rootT, max) != 1 ){
				return 0;
			}		
			return 1;
		}
		//============== Second Approach by interviewbit.com preorder solution .
		public int isValidBST2(TreeNode A) {
		    
		    if (A == null)
		        return 0;
		        
		    ArrayList<Integer> inorder = new ArrayList<>();
		    Stack<TreeNode> stack = new Stack<>();
		    
		    TreeNode node = A;
		    addNodes(node, stack);
		    
		    while (!stack.isEmpty()) {
		        node = stack.pop();
		        inorder.add(node.val);
		        node = node.right;
		        addNodes(node, stack);
		    }		    
		    for (int i = 1; i < inorder.size(); i++) {
		        int val = inorder.get(i);
		        int prev = inorder.get(i - 1);
		        if (val <= prev)
		            return 0;
		    }		    
		    return 1;		    
		}		
		private void addNodes(TreeNode node, Stack<TreeNode> stack) {
		    while (node != null) {
		        stack.push(node);
		        node = node.left;
		    }
		}
		/***
		 * checkPoint preparation question , you should check if sender or reciever adress existing in the system
		 * 
		 */
		public condition isVirusExist(TreeNode node , int sender , int reciever){
			if(isExist(node ,sender) || isExist(node ,reciever)){
				return condition.False;
			}else
				return condition.True;
		} 
		private boolean isExist(TreeNode node , int adress){
			if(node == null){
				return false;
			}
			while(node!=null){
				if (adress == node.val){
					return true;
				}
				if(adress > node.val){
					node = node.right;
				}
				if(adress < node.val){
					node = node.left;
				}
			}
			return false;
		}
		//#4 question : 
		private void getMessage(Message msg){
			try{	
			//if(msg.message!= null && msg !=null){							
					if(messagesList.containsKey(msg.sender)){
					   messagesList.put(msg.sender , messagesList.get(msg.sender)+1);
					}
					else{
						messagesList.put(msg.sender, counter);
					}				
				//}
			}catch(NullPointerException ex){
				System.out.println("There is no mesage" + ex.getMessage());
			}
		}
		public ArrayList getAdressList(){
			ArrayList senderList = new ArrayList();
			Enumeration<Integer> enumKey = messagesList.keys();
			while(enumKey.hasMoreElements()) {
			    Integer key = enumKey.nextElement();
			    Integer val = messagesList.get(key);
			    if(val / messagesList.size() >= 0.1){
			    	senderList.add(key);
			    }
			}
			return senderList;
		}
		public ArrayList getAdressListIteratorApproach(){
			ArrayList senderList = new ArrayList();
			 for(Integer key : messagesList.keySet()){
				 Integer value = messagesList.get(key);
				 if(value / messagesList.size() >= 0.1){
				    	senderList.add(key);
				    }
			 }
			 return senderList;
		}
		
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			DiGraph<Integer> graph = new DiGraph<Integer>();
	        graph.add(0, 1); graph.add(0, 2); graph.add(0, 3);
	        graph.add(1, 2); graph.add(1, 3); graph.add(2, 3);
	        graph.add(2, 4); graph.add(4, 5); graph.add(5, 6);    // Tetrahedron with tail
	        System.out.println("The current graph: " + graph);
	        
	        Chapter4Trees tree = new Chapter4Trees();
	        TreeNode node = new TreeNode(10);
	        node.left = new TreeNode(9);
	        node.left.left = new TreeNode(4);
	        node.left.right =new TreeNode(6);
	        node.right = new TreeNode(14);
	        node.right.right = new TreeNode(15);
	        node.right.left = new TreeNode(13);		
	        tree.flatten(node);
	        //=====================#4.5==========================
	        TreeNode node2 = new TreeNode(74);
	        node.left = null;
	        node2.right = new TreeNode(153);
	        node2.right.right = new TreeNode(1);
	        node2.right.right.right = new TreeNode(1);
	        node2.right.right.left = new TreeNode(1);
	        int a = tree.isValidBST(node2);
	        System.out.println("Check is valid BST 0 or 1 should return as validation : " + a);
	        
	        TreeNode node3 = new TreeNode(11);
	        node3.right = new TreeNode(2);
	        node3.right.left = new TreeNode(3);
	        node3.left = new TreeNode(3);
	        node3.left.left = new TreeNode(2);
	        node3.left.right =new TreeNode(1);
	        
	        int b = tree.isValidBST2(node3);
	        System.out.println("Check is valid BST 0(f) or 1(t) should return as validation : " + b);	        
	        Message msg = new Message(123,124,"BlaBla");
	        Message msg1 =new Message(125,126,"BiBi");
	        Message msg3 = new Message(127,128,"HeyHey");
	        Message msg4 = new Message(123,124,"Baba");
	        //====================CheckPoint preparation ==============================
	        Chapter4Trees checkPoint = new Chapter4Trees();
	        checkPoint.getMessage(null);
	        checkPoint.getMessage(msg4);
	        checkPoint.getMessage(msg1);
	        checkPoint.getMessage(msg3);
	        checkPoint.getMessage(msg4);
	        checkPoint.getMessage(msg);
	        
	        checkPoint.getAdressListIteratorApproach();
	        	        
	}
}
