package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraverse {
	//Iterative solution
	public ArrayList<Integer> inorderTraversal(TreeNode a) {
		ArrayList<Integer> list = new ArrayList<Integer>();

	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode cur = a;

	    while(cur!=null || !stack.empty()){
	        while(cur!=null){
	            stack.add(cur);
	            cur = cur.left;
	        }
	        cur = stack.pop();
	        list.add(cur.val);
	        cur = cur.right;
	    }

	    return list;
	}
	//recursive solution
	public ArrayList<Integer> inorderTraversal2(TreeNode a) {			
		ArrayList<Integer> result = new ArrayList<>();
		return helper(a,result);
	}
	//Recoursive approach
	public ArrayList<Integer> helper(TreeNode a, ArrayList<Integer> help){
		if(a.left !=null){
			helper(a.left,help);
		}
		
		help.add(a.val);
		
		if(a.right!= null){
			helper(a.right,help);
		}
		return help;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InorderTraverse order = new InorderTraverse();
		TreeNode tree = new TreeNode(7);
		tree.left = new TreeNode(5);
		tree.right = new TreeNode(9);
		tree.left.left = new TreeNode(4);
		tree.left.right = new TreeNode(6);
		tree.right.left = new TreeNode(1);
		ArrayList<Integer> arr = order.inorderTraversal2(tree);
		for(int i =0; i < arr.size(); i++){
			System.out.println(arr.get(i));
		}
	}
}
