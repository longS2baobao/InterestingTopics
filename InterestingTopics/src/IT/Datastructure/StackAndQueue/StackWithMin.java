package IT.Datastructure.StackAndQueue;
import java.util.Stack;

// implement a stack with minimum function running in O(1) 
public class StackWithMin extends Stack<Integer> {
	Stack<Integer> stack4min;
	
	public StackWithMin()
	{
		stack4min = new Stack<Integer>();
		
	}
	
	public void push(int value)
	{
		if(!stack4min.isEmpty())
		{
			if(value < stack4min.peek())
			{
				stack4min.push(value);
			}
		}
		else
		{
			stack4min.push(value);
		}
		super.push(value);
	}
	
	public Integer pop()
	{
		int top = super.pop();
		if (top == stack4min.peek())
		{
			stack4min.pop();
		}
		return top;
	}
	
	
	public Integer getMin()
	{
		if(stack4min.isEmpty())
		{
			return Integer.MAX_VALUE;
		}
		return stack4min.peek();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackWithMin swm = new StackWithMin();
		// print Max integer when Stack is empty
		System.out.println(swm.getMin());
		//push in values and get minimum value
		swm.push(5);
		System.out.println(swm.getMin());
		swm.push(6);
		System.out.println(swm.getMin());
		swm.push(1);
		System.out.println(swm.getMin());

	}

}
