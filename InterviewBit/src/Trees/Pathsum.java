package Trees;

import java.util.ArrayList;
import java.util.List;
/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path’s sum
 *  equals the given sum.
 *	For example:
 *	Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
	return
[
   [5,4,11,2],
   [5,8,4,5]
]
 * @author anoshin45
 *
 */
public class Pathsum {
	public List<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    if(root == null) 
	        return result;
	 
	    ArrayList<Integer> l = new ArrayList<Integer>();
	    l.add(root.val);
	    dfs(root, sum-root.val, result, l);
	    return result;
	}
	 
	public void dfs(TreeNode t, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> l){
	    if(t.left==null && t.right==null && sum==0){
	        ArrayList<Integer> temp = new ArrayList<Integer>();
	        temp.addAll(l);
	        result.add(temp);	    	
	    }
	 
	    //search path of left node
	    if(t.left != null){
	        l.add(t.left.val);
	        dfs(t.left, sum-t.left.val, result, l);
	        l.remove(l.size()-1);
	    }
	 
	    //search path of right node
	    if(t.right!=null){
	        l.add(t.right.val);
	        dfs(t.right, sum-t.right.val, result, l);
	        l.remove(l.size()-1);
	    }
	}
	
	public static void main(String[] args) {
		Pathsum ps = new Pathsum();
		TreeNode tree = new TreeNode(7);
		tree.left = new TreeNode(5);
		tree.right = new TreeNode(9);
		tree.left.left = new TreeNode(4);
		tree.left.right = new TreeNode(6);
		tree.right.left = new TreeNode(1);
		ps.pathSum(tree, 16);
		
	}
}
