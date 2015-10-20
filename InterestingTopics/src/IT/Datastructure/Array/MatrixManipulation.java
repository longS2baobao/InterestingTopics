package IT.Datastructure.Array;
import java.util.ArrayList;

//write an algorithm such that if an M*N matrix is 0, its entire row and column are set to 0
public class MatrixManipulation {
	private int[][] matrix;
	
	public MatrixManipulation(int[][] m)
	{
		matrix = m;
	}
	
	// Notice: if we set row and column to 0 whenever we meet a 0, all the matrix will be 0
	// Strategy: thus we need to mark row/column and change it later on.
	public void setZeros()
	{
		//use two array list to keep track of the rows and columns need to be set to 0.
		ArrayList<Integer> m_row = new ArrayList<Integer>();
		ArrayList<Integer> m_col = new ArrayList<Integer>();
		
		//mark
		for (int y =0; y < matrix[0].length;y ++)
		{
			for (int x=0;x<matrix.length;x++)
			{
				if(matrix[x][y]==0)
				{
					if(!m_row.contains(x)) m_row.add(x);
					if(!m_col.contains(y)) m_col.add(y);
				}
			}
		}
		
		//set
		for(int x:m_row)
		{
			for(int y=0;y<matrix[0].length;y++)
			{
				matrix[x][y] = 0;
			}
		}
		
		for(int y:m_col)
		{
			for(int x=0;x<matrix.length;x++)
			{
				matrix[x][y] = 0;
			}
		}
	}
	
	public void print()
	{
		for (int x =0;x<matrix.length;x++)
		{
			
			for(int y=0;y<matrix[0].length;y++)
			{
				System.out.print(matrix[x][y]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = new int[][]{{1,2,3,4,0,5},
								{3,4,0,1,2,3},
								{2,3,1,1,5,7}};
		
		MatrixManipulation mm = new MatrixManipulation(mat);
		mm.setZeros();
		mm.print();
		
	}
}
