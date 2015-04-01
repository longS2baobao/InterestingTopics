package IT.Algorithms.Sorting;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BubbleSort {

	private int[] number2sort = new int[100];
	private int[] numberSorted = new int[100];
	
	public BubbleSort()
	{
		number2sort= new int[]{11, 5, 17,17 ,200,12,510};
	}
	public BubbleSort(int[] ia){
		number2sort= ia;
	} 
	
	public int[] getSortedArray()
	{
		return numberSorted;
	}
	public int[] sort()
	{
		for (int i =0; i< number2sort.length; i++)
		{
			for(int j = i; j< number2sort.length-1;j++)
			{
				if(number2sort[j] > number2sort[j+1])
				{
					swap(number2sort,j+1,j);
				}
			}
		}
		numberSorted = number2sort.clone();
		return numberSorted;
	}
	
	private void swap(int[] ia, int i, int j)
	{
		int temp = ia[i];
		ia[i] = ia[j];
		ia[j] = temp;
	}
	
	public static void main(String[] args) {
		
		//get input
		/* get input from console
		int a[] = new int[100];
		
		System.out.println("Enter numbers to sort split by space:");
		try{
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			String s = bufferRead.readLine();
			String[] sa = s.split(" ");
			for(int i=0; i < sa.length; i++)
			{
				a[i] = Integer.parseInt(sa[i]);
			}
		}catch(IOException e)
		{
			e.printStackTrace();
		}*/
		
		//BubbleSort bs = new BubbleSort(a);
		BubbleSort bs = new BubbleSort();
		int[] iout = bs.sort();
		for(int i : iout)
		{
			System.out.println(i);
		}
	}
	

	

}
