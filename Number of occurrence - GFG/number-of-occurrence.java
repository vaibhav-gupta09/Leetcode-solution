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
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
       int left = findLeft(arr, x);
       int right = findRight(arr, x);
       if(left==-1) return 0;
       return right - left + 1;
       
    }
    
    public int findLeft(int[]arr, int x){
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
    
    public int findRight(int[]arr, int x){
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