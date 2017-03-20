package Trees;
/**
 * Given a binary tree, find its minimum depth.
 *  The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *	NOTE : The path has to end on a leaf node. 
 *	Example :
 *
 *          1
 *         /
 *       2
 * min depth = 2.
 * @author BenFranklin
 */
public class MinTreeDepth {
	public int minDepth(TreeNode a) {
	    //Case when you get a == null outside.
		if(a==null){
	        return 0;
	    }
	    //Stop condition , Base case: the situation when you reach the leaf
	    if(a.left == null && a.right ==null){
	        return 1;
	    }	    
	    if(a.left == null){
	        return 1 + minDepth(a.right);
	    }
	    if(a.right == null){
	        return 1 + minDepth(a.left);
	    }	    
	    return (1+Math.min(minDepth(a.left), minDepth(a.right)));
	}
}
