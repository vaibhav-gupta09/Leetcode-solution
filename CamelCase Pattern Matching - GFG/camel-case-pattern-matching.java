//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String[] Dictionary=read.readLine().split(" ");
            String Pattern=read.readLine();
            Solution ob = new Solution();
            ArrayList <String> ans=ob.CamelCase(N,Dictionary,Pattern);
            for(String u:ans)
             System.out.print(u+" ");
            System.out.println(); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    ArrayList<String> CamelCase(int n,String[] Dictionary,String Pattern){
       ArrayList<String> ans = new ArrayList<>();
       for(String dict: Dictionary){
           StringBuilder sb = new StringBuilder();
           for(char ch: dict.toCharArray()){
               if(ch>='A' && ch<='Z'){
                   sb.append(ch);
               }
               if(sb.length()==Pattern.length()){
                   if(sb.toString().equals(Pattern)) ans.add(dict);
                   break;
               }
           }
       }
       Collections.sort(ans);
       if(ans.size()==0) ans.add("-1");
       return ans;
    }
}