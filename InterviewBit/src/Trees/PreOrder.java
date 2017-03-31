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
	//recoursive approach
	public ArrayList<Integer> preorderTraverse(TreeNode a) {			
		ArrayList<Integer> result = new ArrayList<>();
		return helper(a,result);
	}
	//Recoursive approach
	public ArrayList<Integer> helper(TreeNode a, ArrayList<Integer> help){
		help.add(a.val);
		if(a.left !=null){
			helper(a.left,help);
		}						
		if(a.right!= null){
			helper(a.right,help);
		}
		return help;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		PreOrder order = new PreOrder();
		TreeNode tree = new TreeNode(7);
		tree.left = new TreeNode(5);
		tree.right = new TreeNode(9);
		tree.left.left = new TreeNode(4);
		tree.left.right = new TreeNode(6);
		tree.right.left = new TreeNode(1);
		ArrayList<Integer> arr = order.preorderTraverse(tree);
		for(int i =0; i < arr.size(); i++){
			System.out.println(arr.get(i));
		}
	}
}
