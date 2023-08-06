//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int findMaxSum(int arr[], int n) {
       int[]come = new int[n];
       int[]notCome = new int[n];
       
       come[0] = arr[0];
       
       for(int i=1; i<n; ++i){
           come[i] = Math.max(notCome[i-1] + arr[i], come[i-1]);
           notCome[i] = Math.max(notCome[i-1], come[i-1]);
       }
       
       return Math.max(come[n-1], notCome[n-1]);
    }
}