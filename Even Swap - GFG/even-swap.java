//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int[n];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(str[i]);
			}
			Solution obj = new Solution();
			int [] b = obj.lexicographicallyLargest(arr, n);
			for(int x: b) {
				System.out.print(x+" ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	int [] lexicographicallyLargest(int [] arr, int n) {
		int prev = 0;
		Integer[]a = new Integer[n+1];
		for(int i=0; i<n; ++i){
		    a[i] = arr[i];
		}
		for(int i=1; i<n; ++i){
		    if((arr[i]+arr[i-1])%2==0) continue;
		    
		    Arrays.sort(a, prev, i, Collections.reverseOrder());
		    prev = i;
		}
		
		Arrays.sort(a, prev, n, Collections.reverseOrder());
		
		for(int i=0; i<n; ++i){
		    arr[i] = a[i];
		}
		
		return arr;
	}
}