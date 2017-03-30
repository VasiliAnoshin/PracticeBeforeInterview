package Trees;

import java.util.ArrayList;
import java.util.Stack;
/**
 * Given a binary tree, return the preorder traversal of its nodes’ values.
 *
 *	Example :
 *	Given binary tree
			   1
			    \
			     2
			    /
			   3
 * return [1,2,3].
 *
 * Using recursion is not allowed.
 * @author anoshin45
 *
 */
public class PreOrder {
	
	public ArrayList<Integer> preorderTraversal(TreeNode a) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> rights = new Stack<TreeNode>();
		while(a != null) {
			list.add(a.val);
			if (a.right != null) {
				rights.push(a.right);
			}
			a = a.left;
			if (a == null && !rights.isEmpty()) {
				a = rights.pop();
			}
		}
	    return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
