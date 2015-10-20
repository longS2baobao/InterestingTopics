package IT.Datastructure.Array;

import java.util.*;

//question is here
//https://www.hackerrank.com/challenges/java-1d-array

public class Game {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner (System.in);;
        int tc = sc.nextInt();
        for(int i=0;i<tc;i++)
        {
            int size = sc.nextInt();
            int jump = sc.nextInt();
            int[] array = new int[size];
            for (int j=0;j<size;j++)
            {
                array[j] = sc.nextInt();
            }
            boolean[] visited = new boolean[size];
            
            if(findPath(array,visited,jump,0)) 
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        sc.close();
        
    }
    
    public static boolean findPath(int[] ia,boolean[] visited, int jump, int currentIndex)
    {
        if(currentIndex > (ia.length - jump-1)|| currentIndex == (ia.length-1))
        {
            return true;
        }
        else
        {
            //mark as visited
            visited[currentIndex] = true;

            for(int adjIndex : getAdjacent(ia,jump,currentIndex))
            {
                if(!visited[adjIndex])
                {
                    if( findPath(ia,visited,jump,adjIndex)) return true;
                }

            }
        }
        return false;
    }
    public static int[] getAdjacent(int[] ia, int jump, int index)
    {
        int[] adj = new int[3];
        if((index+1)<=(ia.length-1))
        {
            if(ia[index+1]==0)
            {
                adj[0] = index+1;
            }
        }
        if((index-1)>=0)
        {
            if(ia[index-1]==0)
            {
                adj[1]=index-1;
            }
        }
        if((index+jump)<= (ia.length-1))
        {
            if(ia[index+jump]==0)
            {
                adj[2] =index+jump;
            }
        }
        return adj;
    }
}
