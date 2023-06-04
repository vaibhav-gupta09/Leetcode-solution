//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        while(t-- > 0)
        {
            String s;
            s = in.readLine().trim();
            
            Solution ob = new Solution();
            
            out.println(ob.reverseEqn(s));    
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
   
    String reverseEqn(String s){
        StringBuilder sb = new StringBuilder();
        int i = s.length()-1;
        Stack<Character> st = new Stack<>();
        while(i>=0){
            char ch = s.charAt(i);
            if(ch>='0' && ch<='9'){
                st.push(ch);
            }else{
                while(st.size()!=0){
                    sb.append(st.pop());
                }
                sb.append(ch);
            }
            i--;
        }
        while(st.size()!=0){
                sb.append(st.pop());
        }
        return sb.toString();
    }
}