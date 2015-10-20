package IT.Datastructure.TreeAndGraph;
import javax.swing.tree.TreeNode;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

// a balanced tree is defined to be a tree such that the height of the two subtrees of any node never differ by more than one
public class BalancedTree {

	public int getHeight(TreeNode root)
	{
		if(root==null) return 0;
		return Math.max(getHeight(root.getChildAt(0)), getHeight(root.getChildAt(1)))+1;
	}
	
	// time complexity O(n*log(n))
	public boolean isBalanced(TreeNode root)
	{
		if (root ==null) return true;
		int diff = Math.abs(getHeight(root.getChildAt(0)) - getHeight(root.getChildAt(1)));
		if (diff > 1) return false;
		else return isBalanced(root.getChildAt(0)) && isBalanced(root.getChildAt(1));
	}
	
	//efficient method. Check balanced when checking height
	public int checkHeight(TreeNode root)
	{
		if (root==null) return 0;	// 0 height
		int left = checkHeight(root.getChildAt(0));
		if (left ==-1) return -1;
		int right = checkHeight(root.getChildAt(1));
		if (right ==-1) return -1;
		if ( Math.abs(left - right) > 1) return -1;
		else
		{
			return Math.max(left,right)+1;
		}
	}
	// time complexity O(N), space complexity O(H) in which H is height of the tree
	public boolean isBalanced_efficient(TreeNode root)
	{
		if(checkHeight(root)==-1)  return false;
		else return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode tree = new DefaultMutableTreeNode();
		tree.add(new DefaultMutableTreeNode(5));
	}

}
