//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String findOrder(String [] dict, int n, int k){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<k; ++i) adj.add(new ArrayList<>());
        for(int idx=0; idx<dict.length-1; ++idx){
            String str1 = dict[idx];
            String str2 = dict[idx+1];
            
            int i = 0, j = 0;
            while(i<str1.length() && j<str2.length() && str1.charAt(i) == str2.charAt(j)){
                i++;
                j++;
            }
            
            if(i==str1.length() || j==str2.length()) continue;
            
            adj.get(str1.charAt(i) - 'a').add(str2.charAt(j) - 'a');
        }
        
        int []indegree = new int[k];
        
        for(ArrayList<Integer> list: adj){
            for(int val: list)
                indegree[val]++;
        }
        
        StringBuilder sb = new StringBuilder();
        Queue<Integer> que = new ArrayDeque<>();
        
        for(int i=0; i<k; ++i){
            if(indegree[i] == 0)
                que.add(i);
        }
        
        while(que.size() > 0){
            int rem = que.remove();
            sb.append((char)('a' + rem));
            for(int nbr: adj.get(rem)){
                indegree[nbr]--;
                if(indegree[nbr]==0) que.add(nbr);
            }
        }
        
        return sb.toString();
    }
}