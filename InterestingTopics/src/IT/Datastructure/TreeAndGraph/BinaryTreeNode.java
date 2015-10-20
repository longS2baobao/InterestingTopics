package IT.Datastructure.TreeAndGraph;

public class BinaryTreeNode extends TreeNode{
	BinaryTreeNode leftChild;
	BinaryTreeNode rightChild;
	int value;
	public BinaryTreeNode(int value)
	{
		super(value);
		children.add(leftChild);
		children.add(rightChild);
		this.value = value;
	}
	
	public void show()
	{
		System.out.println(value);
	}
}
