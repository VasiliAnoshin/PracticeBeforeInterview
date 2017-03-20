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
	//
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
