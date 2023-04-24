//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int[n];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(str[i]);
			Solution ob = new Solution();
			int [] ans = ob.nearestSmallestTower(arr);
			for(int i = 0; i < n; i++)
				System.out.print(ans[i]+" ");
			System.out.println();
		}
		
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution{
	int [] nearestSmallestTower(int [] arr){
	   int n = arr.length;
	   int[]left = nsel(arr);
	   int[]right = nser(arr);
	   
	   int ans[] = new int[n];
	   for(int i=0; i<n; ++i){
	       if(left[i]==-1 && right[i]==-1){
	           ans[i] = -1;
	           continue;
	       }
	       else if(left[i]==-1){
	           ans[i] = right[i];
	       }else if(right[i]==-1){
	           ans[i] = left[i];
	       }else{
	           int distl = Math.abs(i-left[i]);
	           int distr = Math.abs(i-right[i]);
	           
	           if(distl<distr){
	               ans[i] = left[i];
	           }else if(distr < distl){
	               ans[i] = right[i];
	           }else{
	               if(arr[left[i]] <= arr[right[i]]){
	                  ans[i] = left[i];
	               }else{
	                  ans[i] = right[i];
	               }
	           }
	       }
	   }
	   
	   return ans;
	}
	
	int [] nsel(int[]arr){
	    int n = arr.length;
	    int[]left = new int[n];
	    left[0] = -1;
	    Stack<Integer> st = new Stack<>();
	    st.push(0);
	    
	    for(int i=1; i<n; ++i){
	        while(st.size()>0 && arr[st.peek()]>=arr[i]) st.pop();
	        if(st.size()==0) left[i] = -1;
	        else left[i] = st.peek();
	        st.push(i);
	    }
	    
	    return left;
	}
	
	int [] nser(int[]arr){
	    int n = arr.length;
	    int[]right = new int[n];
	    right[n-1] = -1;
	    Stack<Integer> st = new Stack<>();
	    st.push(n-1);
	    
	    for(int i=n-2; i>=0; --i){
	        while(st.size()>0 && arr[st.peek()]>=arr[i]) st.pop();
	        if(st.size()==0) right[i] = -1;
	        else right[i] = st.peek();
	        st.push(i);
	    }
	    
	    return right;
	}
}