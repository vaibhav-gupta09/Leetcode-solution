//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int[] arr = new int[n];
            
            for (int i = 0; i < n; ++i)
                arr[i] = sc.nextInt ();

    		System.out.println (new Sol().search (arr, n));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static int search(int arr[], int n){
        int lo = 0, hi = n-1;
        
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(mid-1>=0 && arr[mid-1]==arr[mid]){
                if(mid%2==1) lo = mid + 1;
                else hi = mid-1;
            }else if(mid+1<n && arr[mid] == arr[mid+1]){
                if(mid%2==0) lo = mid+1;
                else hi = mid - 1;
            }else{
                return arr[mid];
            }
        }
        
        return -1;
    }
}