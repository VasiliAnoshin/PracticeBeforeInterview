package Trees;
/**
 *  Given a binary tree, determine if it is height-balanced.
 *  Height-balanced binary tree : is defined as a binary tree in which the 
 *  depth of the two subtrees of every node never differ by more than 1. 
 *	Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 * @author anoshin45
 *
 */
public class TreeDepth {	
	int balanced = 1;	
	//First Approach
	public static int getHeight(TreeNode root){
		if(root == null){
			return 0;
		}
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}	
	public static boolean isBalanced(TreeNode root){
		if(root == null){
			return true;
		}		
		int heightDiff = getHeight(root.left) - getHeight(root.right);		
		if(Math.abs(heightDiff) > 1){
			return false;
		}else{
			return isBalanced(root.left) && isBalanced(root.right);
		}
	}
	//Another Solution 
	public int isBalancedLaunch(TreeNode root){
		isBalancedSecondTry(root);
		return balanced; 
	}
	 
	public int isBalancedSecondTry(TreeNode root){
		if (root == null){
			return 0;
		}		
		int left  = 1 + isBalancedSecondTry(root.left);
		int right = 1 + isBalancedSecondTry(root.right);		
		if(Math.abs(left - right) > 1){
			balanced = 0;
		}
		return Math.max(left, right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}
