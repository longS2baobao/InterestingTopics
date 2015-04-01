package IT.Algorithms.Sorting;

public class QuickSort {
	private int[] number2sort = new int[100];
	private int[] numberSorted = new int[100];
	public QuickSort()
	{
		number2sort= new int[]{11, 5, 17,17 ,200,12,510};
	}
	public QuickSort(int[] ia){
		number2sort= ia;
	} 
	public int[] getSortedArray()
	{
		return numberSorted;
	}
	
	public void sort()
	{
		quicksort(number2sort,0,number2sort.length-1);	
		numberSorted =number2sort;
	}
	
	private void quicksort(int[] ia, int left, int right)
	{
		//select "left" number as base number
		int baseNum = ia[left];
		int i = left;
		int j = right;
		
		if (left > right) return;
		
		//start from right pointer
		while(i != j)
		{
			while (ia[j] >= baseNum && i <j)
			{
				j--;
			}
			
			while (ia[i] <= baseNum && i < j)
			{
				i++;
			}
			
			if(i<j)
			{
				swap(ia,i,j);
			}
		}
		
		//swap base number and middle number (left = right = middle)
		swap (ia, left,i);
		
		if(i-1 >=0)
		{
			quicksort(ia,left,i-1);
		}
		if(i+1< ia.length)
		{
			quicksort(ia,i+1,right);
		}
		
	}
	
	private void swap(int[] ia, int i, int j)
	{
		int temp = ia[i];
		ia[i] = ia[j];
		ia[j] = temp;
	}
	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		qs.sort();
		for ( int i : qs.getSortedArray())
		{
			System.out.println(i);
		}

	}

}
