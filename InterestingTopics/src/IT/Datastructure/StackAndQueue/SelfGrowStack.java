package IT.Datastructure.StackAndQueue;
import java.util.Stack;
import java.util.ArrayList;
public class SelfGrowStack {
	private ArrayList<Stack<Integer>> setOfStack = new ArrayList<Stack<Integer>>();
	public static final int SINGLE_STACK_MAX = 2;
	
	public void push(int value)
	{
		Stack<Integer> lastStack = this.getLastStack();
		if(this.isFull(lastStack))
		{
			Stack<Integer> s_new = new Stack<Integer>();
			s_new.push(value);
			setOfStack.add(s_new);
		}
		else
		{
			lastStack.push(value);
		}
	}
	
	public void printStack()
	{
		for(int i =0; i <setOfStack.size(); i++)
		{
			Stack<Integer> currentStack = setOfStack.get(i);
			System.out.print("Stack " + i + " : ");
			for(int j = 0; j<currentStack.size();j++)
			{
				System.out.print(currentStack.get(j)+" ");
			}
			System.out.println();
		}
	}
	
	public Integer pop()
	{
		Stack<Integer> currentStack = this.getLastStack();
		if(currentStack.size()==0)
		{
			setOfStack.remove(currentStack);
			return this.getLastStack().pop();
		}
		else
		{
			return currentStack.pop();
		}
	}
	
	private boolean isFull(Stack<Integer> s)
	{
		if(s.size() >= SINGLE_STACK_MAX)
		{
			return true;
		}
		return false;
	}
	
	private Stack<Integer> getLastStack()
	{
		if(setOfStack.isEmpty())
		{
			Stack<Integer> s = new Stack<Integer>();
			setOfStack.add(s);
		}
		return setOfStack.get(setOfStack.size()-1);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SelfGrowStack sgs = new SelfGrowStack();
		for(int i =0;i< 8;i++)
		{
			sgs.push(i);
		}
		sgs.printStack();
		System.out.println();
		
		int total_stacks = sgs.setOfStack.size();
		for(int j =0 ; j< total_stacks*SINGLE_STACK_MAX; j++)
		{
			sgs.pop();
			sgs.printStack();
			System.out.println();
		}
	}

}
