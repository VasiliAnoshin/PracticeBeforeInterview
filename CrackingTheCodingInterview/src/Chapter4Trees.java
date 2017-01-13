import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Chapter4Trees {
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
	        //==============================================
	        TreeNode node2 = new TreeNode(74);
	        node.left = null;
	        node2.right = new TreeNode(153);
	        node2.right.right = new TreeNode(1);
	        node2.right.right.right = new TreeNode(1);
	        node2.right.right.left = new TreeNode(1);
	        int a = tree.isValidBST(node2);
	        System.out.println(a);
	        
	        TreeNode node3 = new TreeNode(11);
	        node3.right = new TreeNode(2);
	        //node3.right.right = new TreeNode(3);
	        node3.right.left = new TreeNode(3);
	        //node3.right.right.right = new TreeNode(-1);
	        //node3.right.right.left = new TreeNode(-1);
	        node.left = new TreeNode(3);
	        node.left.left = new TreeNode(4);
	        node.left.right =new TreeNode(1);
	        //node.left.left.left = new TreeNode(1);
	        //node.left.left.right = new TreeNode(3);
	        
	        int b = tree.isValidBST(node2);
	        System.out.println(b);
	}

}
