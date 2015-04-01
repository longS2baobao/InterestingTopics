package IT.Datastructure.StackAndQueue;
import java.util.Stack;
//recursive thinking
public class Hanoi {
	/*
	public void moveDisks(int n, Tower origin, Tower destination, Tower buffer)
	{
		// base case
		if (n<=0) return;
		// move top n-1 disks from origin to buffer, using destination tower as buffer
		moveDisks(n-1,origin,buffer,destination);
		// move bottom disk to destination
		moveTop(origin,destination);
		// move top n-1 disks from buffer to destination
		moveDisks(n-1,buffer,destination,origin);
	}
	*/
	
	public class Tower{

		private Stack<Integer> disks;
		private int index;
		public Tower(int n)
		{
			disks = new Stack<Integer>();
			index = n;
		}
		
		public int index()
		{
			return index;
		}
		
		/**
		 * add a disk to the top of the tower
		 * @param d  disk index
		 */
		public boolean add(int d)
		{
			if (disks.isEmpty()||disks.peek()>d)
			{
				disks.push(d);
				return true;
			}
			else
			{
				System.out.println("Error: Can't stack big disk over smaller one");
				return false;
			}
		}
		
		/**
		 * move top disk to the other tower
		 * @param t the index of the other tower
		 */
		public void moveTopto(Tower t)
		{
			int top_disk = this.disks.peek();
			if(t.add(top_disk) )
			{
				this.disks.pop();
			}
		}
		
		public void moveDisk(int n, Tower buffer,Tower destination)
		{
			if(n>0)
			{
				// use destination tower as buffer, move all disks from this tower to buffer tower
				moveDisk(n-1,destination,buffer);
				//move base disk to destination tower
				moveTopto(destination);
				//move this tower as buffer, move all disks from buffer tower to destination tower
				buffer.moveDisk(n-1, this, destination);
			}
		}
		
		public void showStack()
		{
			if(!disks.isEmpty())
			{
				for(int i=disks.size()-1;i>=0;i--)
				{
					System.out.print(" " + disks.elementAt(i) +" ");
				}
				System.out.println();
			}
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n =5;
		Tower[] towers = new Tower[3];
		Hanoi han = new Hanoi();
		for(int i =0;i<towers.length; i++)
		{
			towers[i] = han.new Tower(i);
		}
		
		for(int i =n-1;i>=0;i--)
		{
			towers[0].add(i);
		}
		
		System.out.println("Tower1: ");
		towers[0].showStack();
		
		towers[0].moveDisk(n, towers[1], towers[2]);
		
		System.out.println("Tower3: ");
		towers[2].showStack();
		
		
	}

}

