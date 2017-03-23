package Trees;
/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.	
 *	Example :
 *	Given the below binary tree and sum = 22,
 *
 *             5
 *            / \
 *           4   8
 *          /   / \
 *         11  13  4
 *        /  \      \
 *       7    2      1
 *	return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 *	Return 0 / 1 ( 0 for false, 1 for true ) for this problem	
 * @author anoshin45
 *
 */
public class HasPathSum {
	
	public int hasPathSum(TreeNode a, int b) {		
		return isExist(a, b)?1:0;
	}
	public boolean isExist(TreeNode a , int b ){
		if(a == null){
			return (b == 0);
		}else{
			boolean ans = false;
			int sum = b - a.val;
			if(sum == 0 && a.left == null && a.right ==null){
				return true;
			}
			if(a.left != null){
				ans = ans || isExist(a.left,sum);
			}if(a.right != null){
				ans = ans || isExist(a.right, sum);
			}
			return ans;
		}		
	}
			
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(7);
		tree.left = new TreeNode(5);
		tree.right = new TreeNode(9);
		tree.left.left = new TreeNode(4);
		tree.left.right = new TreeNode(6);
		tree.right.left = new TreeNode(1);
		
		hasPathSum hp = new hasPathSum();
		System.out.println(hp.hasPathSum(tree,17));
	}

}

