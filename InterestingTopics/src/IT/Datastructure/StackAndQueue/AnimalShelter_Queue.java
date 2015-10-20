package IT.Datastructure.StackAndQueue;
import java.util.LinkedList;
//use linked list to represent a shelter which performs dequeue cat, dequeue dog and dequeue any (returns the oldest)
public class AnimalShelter_Queue {
	
	public LinkedList<Dog> l_d;
	public LinkedList<Cat> l_c;
	int order;
	public AnimalShelter_Queue()
	{
		l_d = new LinkedList<Dog>();
		l_c = new LinkedList<Cat>();
		order =0;
	}
	
	public void enqueue(Animal a)
	{
		a.setOrder(order);
		order++;
		
		if(a instanceof Dog) l_d.addLast((Dog)a);
		else if(a instanceof Cat) l_c.addLast((Cat) a);
	}

	public Animal dequeueAny()
	{
		if(l_d.isEmpty()) return dequeueCat();
		else if(l_c.isEmpty()) return dequeueDog();
		else
		{
			Cat c = l_c.getFirst();
			Dog d = l_d.getFirst();
			if (c.isOlderThan(d))
			{
				l_c.removeFirst();
				return c;
			}
			else
			{
				l_d.removeFirst();
				return d;
			}
		}
	}
	
	public Animal dequeueCat()
	{
		Cat c= l_c.getFirst();
		l_c.removeFirst();
		return c;
	}
	
	public Animal dequeueDog()
	{
		Dog d = l_d.getFirst();
		l_d.removeFirst();
		return d;
	}
	
	public void print()
	{
		System.out.println("Dogs: ");
		for(Dog d : l_d)
		{
			System.out.print(d.getName() + ":" + d.getOrder()+" " );
		}
		System.out.println();
		System.out.println("Cats: ");
		for(Cat c : l_c)
		{
			System.out.print(c.getName() + ":"+c.getOrder()+" ");
		}
		System.out.println();
		
	}
	/**
	 * Animal abstract class 
	 * @author lzl19_000
	 *
	 */
	public abstract class Animal
	{
		private int order;
		private String s_name;
		public Animal(String name)
		{
			s_name = name;
		}
		
		public void setOrder(int n)
		{
			order = n;
		}
		
		public int getOrder()
		{
			return this.order;
		}
		
		public String getName()
		{
			return s_name;
		}
		public boolean isOlderThan(Animal b)
		{
			return this.order < b.getOrder();
		}
	}
	
	public class Dog extends Animal
	{
		public Dog(String n){
			super(n);		// Must invoke parent's constructor explicitly
		}
	}
	
	public class Cat extends Animal
	{
		public Cat(String n)
		{
			super(n);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnimalShelter_Queue shelter = new AnimalShelter_Queue();
		Dog d1 = shelter.new Dog("a");
		Dog d2 = shelter.new Dog("b");
		Cat c3 = shelter.new Cat("c");
		Dog d4 = shelter.new Dog("d");
		Cat c5 = shelter.new Cat("e");
		
		shelter.enqueue(d1);
		shelter.enqueue(d2);
		shelter.enqueue(c3);
		shelter.enqueue(d4);
		shelter.enqueue(c5);
		
		shelter.print();
		
		shelter.dequeueAny();
		shelter.print();
		
	}

}
