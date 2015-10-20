package IT.Datastructure.TreeAndGraph;
import java.util.ArrayList;
public class TreeNode {
	ArrayList<TreeNode> children;
	Object value;
	public TreeNode(Object value)
	{
		children = new ArrayList<TreeNode>();
		this.value = value;
	}
}
