package Trees;

import java.util.ArrayList;
//Find the maximum path from root to leaf
public class MaxHeightPath {

	public ArrayList<Integer> getMaxHeightPath(TreeNode root){
		if(root == null){
			return new ArrayList<Integer>();
		}
		
		if(root.left == null && root.right ==null){
			return new ArrayList<Integer>(root.val);
		}
		ArrayList<Integer> left = getMaxHeightPath(root.left);
		ArrayList<Integer> right =  getMaxHeightPath(root.right);
		
	    ArrayList<Integer> res = left.size() >= right.size() ?
                 left :
                 right;
	    res.add(root.val);
	    return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
