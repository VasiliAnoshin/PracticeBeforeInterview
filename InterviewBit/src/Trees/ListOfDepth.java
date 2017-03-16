package Trees;
import java.util.ArrayList;
import java.util.List;
/**
 * Given a binary tree, design an algorithm which creates a linkedList of 
 * all elements of all nodes at each depth.
 */

import LinkedList.ListNode;

public class ListOfDepth {
	public ArrayList<ListNode> listOfDepth(TreeNode root , ArrayList<ListNode> _list , int level){
		if(root == null){
			return _list;
		}
		ListNode node = null;
		if(_list.size() == level){
			node = new ListNode(root.val);
			_list.add(node);
		}else{
			node = _list.get(level);
			while(node.next!=null){
				node = node.next;
			}
			node.next = new ListNode(root.val);
		}
		
		listOfDepth(root.left,_list,level+1);
		listOfDepth(root.right, _list, level+1);				
		return _list;	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode tree = new TreeNode(7);
		tree.left = new TreeNode(5);
		tree.right = new TreeNode(9);
		tree.left.left = new TreeNode(4);
		tree.left.right = new TreeNode(6);
		tree.right.left = new TreeNode(1);				
		List<ListNode> list = new ArrayList();
		ListOfDepth list1 = new ListOfDepth();	
		//list.add(new ListNode(tree.val));
		list1.listOfDepth(tree, (ArrayList<ListNode>) list,0);
	}	
}
