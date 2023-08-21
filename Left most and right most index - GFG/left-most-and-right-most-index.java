//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            long k = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            pair ans = obj.indexes(a, k);
            if (ans.first == -1 && ans.second == -1)
                System.out.println(-1);
            else
                System.out.println(ans.first+" "+ans.second);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

/*
class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}
*/

class Solution {
    
    public pair indexes(long arr[], long x){
        int left = findLeft(arr, x);
        int right = findRight(arr, x);
        pair p = new pair(left, right);
        return p;
    }
    
    public int findLeft(long[]arr, long x){
        int lo = 0, hi = arr.length-1;
        int st = -1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(arr[mid]<x){
                lo = mid+1;
            }else{
                if(arr[mid] == x) st = mid;
                hi = mid-1;
            }
        }
        return st;
    }
    
    public int findRight(long[]arr, long x){
        int lo = 0, hi = arr.length-1;
        int st = -1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(arr[mid]<=x){
                if(arr[mid] == x) st = mid;
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        return st;
    }
}