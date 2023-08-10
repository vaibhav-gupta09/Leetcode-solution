//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int n, int arr[], int sum){
       boolean[]curr = new boolean[sum+1];
       boolean[]prev = new boolean[sum+1];
       prev[0] = true;
       for(int val: arr){
           for(int i=0; i<=sum; ++i){
               if(i<val){
                curr[i] = prev[i];
                continue;
               }
               if(prev[i-val]==true) curr[i] = true;
               else curr[i] = prev[i];
           }
           
           prev = new boolean[sum+1];
           for(int i=0; i<=sum; ++i){
            //   System.out.print(curr[i] + " "); 
               prev[i] = curr[i];
           }
       }
       
       return prev[sum];
    }
    
    // static Boolean helper(int[]arr, int i, int n, int sum){
    //     if(sum==0) return true;
    //     if(i==n) return false;
        
    //     return helper(arr, i+1, n, sum-arr[i]) || helper(arr, i+1, n, sum);
    // }
}