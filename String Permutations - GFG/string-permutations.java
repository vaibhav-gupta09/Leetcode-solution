//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public ArrayList<String> permutation(String s){
        ArrayList<String> list = new ArrayList<>();
        boolean[] visited = new boolean[s.length()];
        helper(s, 0, "", list, visited);
        Collections.sort(list);
        return list;
    }
    
    public void helper(String s, int count, String asf, ArrayList<String>list, boolean[]visited){
        if(count==s.length()){
            list.add(asf);
            return;
        }
        
        for(int i=0; i<s.length(); ++i){
            if(visited[i]) continue;
            visited[i] = true;
            helper(s, count+1, asf + s.charAt(i), list, visited);
            visited[i] = false;
        }
    }
	   
}
