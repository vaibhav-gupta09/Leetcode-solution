//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            int A[] = new int[n];
            String s[]=in.readLine().trim().split(" ");
            for (int i = 0;i < n;i++)
            {
                A[i] = Integer.parseInt(s[i]);
            }
            int key = Integer.parseInt(in.readLine().trim());
            
            out.println(new Solution().search(A, 0, n - 1, key));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int search(int arr[], int lo, int hi, int key){
        
        int pivot = -1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(arr[0] <= arr[mid]){
                lo = mid+1;
            }else{
                pivot = mid;
                hi = mid-1;
            }
        }
       if(pivot == -1) return binary(arr, 0, arr.length-1, key);
       
        int res1 = binary(arr, 0, pivot-1, key);
        int res2 = binary(arr, pivot, arr.length-1, key);
        
        return Math.max(res1, res2);
    }
    
    public int binary(int[]arr, int lo, int hi, int key){
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(arr[mid] == key) return mid;
            
            if(key < arr[mid]){
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        
        return -1;
    }
}