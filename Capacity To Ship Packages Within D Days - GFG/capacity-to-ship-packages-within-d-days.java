//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            int D = Integer.parseInt(read.readLine());
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.leastWeightCapacity(arr,N,D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int leastWeightCapacity(int[] arr, int n, int d) {
        int hi = 0, lo = arr[0];
        for(int val: arr){
            hi += val;
            lo = Math.max(val, lo);
        }
        int ans = hi, sum = hi;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            
            int noOfDays = getNoOfDays(arr, mid);
            if(noOfDays<=d){
                ans = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        
        return ans;
    }
    
    static int getNoOfDays(int[]arr, int d){
        int count = 0, set = 0;
        for(int val: arr){
            if(count + val <= d){
                count += val;
            }else{
                count = val;
                set++;
            }
        }
        
        set++;
        return set;
    }
};