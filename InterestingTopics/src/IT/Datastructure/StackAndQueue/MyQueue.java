package IT.Datastructure.StackAndQueue;
import java.util.Stack;
//use two stacks to simulate a queue
public class MyQueue<T> {
	//strategy. save all elements to s2. When dequeue needed,pop all elements from s2 to s1 to reverse the order
	Stack<T> s1;
	Stack<T> s2;
	
	public MyQueue()
	{
		s1 = new Stack<T>();
		s2 = new Stack<T>();
	}
	
	public void enQueue(T node)
	{
		s2.push(node);
	}
	
	public T deQueue()
	{
		shiftStacks();
		T result = s1.pop();
		shiftStacks();
		return result;
	}

	
	// peek the oldest elements
	public T peek()
	{
		shiftStacks();
		T top = s1.peek();
		shiftStacks();
		return top; 
	}
	
	private void shiftStacks()
	{
		if (s1.isEmpty())					//shift for pop / peek
		{
			while(!s2.isEmpty())
			{
				s1.push(s2.pop());
			}
		}
		else if (s2.isEmpty())				//shift back
		{
			while(!s2.isEmpty())
			{
				s2.push(s1.pop());
			}
		}
		else
		{
			System.out.println("Error: Both stacks contain element");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue<Integer> q = new MyQueue<Integer>();
		for (int i =0; i<10;i++)
		{
			q.enQueue(i);
		}
		
		for(int i = 0; i< 10; i++)
		{
			Integer temp = q.deQueue();
			System.out.println(temp);
		}
	}

}
