package IT.Datastructure.TreeAndGraph;
import java.util.ArrayList;
import java.util.Arrays;
public class BinarySearchTree {
	BinaryTreeNode root;
	
	public BinarySearchTree()
	{
		root = null;
	}
	
	public BinaryTreeNode InsertNode(BinaryTreeNode rootNode, BinaryTreeNode newNode)
	{
		if(rootNode==null) rootNode = newNode;
		else if(newNode.value < rootNode.value)
		{
			rootNode.leftChild = InsertNode(rootNode.leftChild,newNode);	// add new node as left child
		}
		else
		{
		 	rootNode.rightChild= InsertNode(rootNode.rightChild, newNode);	// add new node as right child
		}
		return rootNode;
	}
	
	public void InsertBST(BinaryTreeNode the_root)
	{
		root = InsertNode(root,the_root);
	}
	
	//********* TRAVERSAL ****************//
	//Depth First Search 
	//inorder traversal. left -> middle->right
	public void inorderDFS(BinaryTreeNode node)
	{
		if(node!=null)
		{
			inorderDFS(node.leftChild);
			node.show();
			inorderDFS(node.rightChild);
		}
	}
	
	public void inorderBST()
	{
		inorderDFS(root);
	}
	
	//DFS
	//pre-order traversal. mid -> left -> right
	public void preorderDFS(BinaryTreeNode node)
	{
		if(node!=null)
		{
			node.show();
			preorderDFS(node.leftChild);
			preorderDFS(node.rightChild);
		}
	}
	
	public void preorderBST()
	{
		preorderDFS(root);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree bst = new BinarySearchTree();
		ArrayList<Integer> node_list = new ArrayList<Integer>(Arrays.asList(5,2,3,6,4,9,1,7,8));
		for(int i=0; i< node_list.size();i++)
		{
			BinaryTreeNode tempNode = new BinaryTreeNode(node_list.get(i));
			bst.InsertBST(tempNode);
		}
		
		//bst.inorderBST();
		bst.preorderBST();
	}

}
