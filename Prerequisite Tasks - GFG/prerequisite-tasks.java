//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,P,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isPossible(int n,int p, int[][] prerequisites){
       int []indegree = new int[n];
       ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; ++i)
            adj.add(new ArrayList<>());
       
       for(int []pre: prerequisites){
           indegree[pre[0]]++;
           adj.get(pre[1]).add(pre[0]);
       }
       
       Queue<Integer> que = new ArrayDeque<>();
       for(int i=0; i<n; ++i){
           if(indegree[i] == 0) que.add(i);
       }
       
       while(que.size() > 0){
           int rem = que.remove();
           
           for(int nbr: adj.get(rem)){
               indegree[nbr]--;
               if(indegree[nbr] == 0) que.add(nbr);
           }
       }
       
       for(int i=0; i<n; ++i){
           if(indegree[i]!=0) return false;
       }
       
       return true;
    }
    
}