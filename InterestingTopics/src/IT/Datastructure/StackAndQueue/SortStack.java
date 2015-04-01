package IT.Datastructure.StackAndQueue;
import java.util.Stack;
//Sort Stack in ascending order (big number on top) with the use of one extra stack
public class SortStack {
	Stack<Integer> originStack;
	Stack<Integer> sortedStack;
	public SortStack(Stack<Integer> s_o )
	{
		originStack = s_o;
		sortedStack = new Stack<Integer>();
	}
	
	
	public void sort()
	{
		while(!originStack.isEmpty())
		{
			sortOneElement();
		}
	}
	
	public void print()
	{
		for(int i =0;i<sortedStack.size();i++)
		{
			System.out.print(" "+sortedStack.elementAt(i));
		}
		System.out.println();
	}
	
	//sort strategy. 1 pop the top element from originStack. 2 put it to the "right place" in sortedStack. 
	//time complexity O(n^2)
	private void sortOneElement()
	{
		int current = originStack.pop();
		
		while(!sortedStack.isEmpty()&&sortedStack.peek()>current)
		{
			originStack.push(sortedStack.pop());
		}

		sortedStack.push(current);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> s = new Stack<Integer>();
		s.push(10);
		s.push(1);
		s.push(5);
		s.push(3);
		
		SortStack ss = new SortStack(s);
		ss.sort();
		ss.print();
	}

}
