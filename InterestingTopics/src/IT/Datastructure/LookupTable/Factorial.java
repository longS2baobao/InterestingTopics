package IT.Datastructure.LookupTable;
import java.util.HashMap;
public class Factorial {
	HashMap<Integer,Double> lookup = new HashMap<Integer,Double>();
	public Factorial(){
	}
	
	public double compute(int n)
	{
		if(n ==0) return 1;
		else if(lookup.containsKey(n)) return lookup.get(n);
		else
		{
			double fac = compute(n-1) * n;
			if (!lookup.containsKey(n)) lookup.put(n, fac);
			return fac;
		}
	}
	
	public double compute_nonLookup(int n)
	{
		if(n ==0) return 1;
		else
		{
			double fac = compute_nonLookup(n-1) * n;
			return fac;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Factorial fac = new Factorial();
		long time = System.nanoTime();
		double r = fac.compute(5);
		//double r = fac.compute_nonLookup(5);
		long time2 = System.nanoTime();
		
		double r2=fac.compute(100);
		//double r2 = fac.compute_nonLookup(100);
		long time3 = System.nanoTime();
		
		System.out.println("Result is "+ r);
		System.out.println("Time Elapsed "+ (time2-time));
		
		System.out.println("Result is "+ r2);
		System.out.println("Time Elapsed "+ (time3-time2));
	}
}
