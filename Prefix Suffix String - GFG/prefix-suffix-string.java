//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

public class code1 
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            String s1[]=in.readLine().trim().split(" ");
            String s2[]=in.readLine().trim().split(" ");

            Solution ob=new Solution();
            int ans=ob.prefixSuffixString(s1,s2);
            out.println(ans);

        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public class Node{
        Node[] arr;
        boolean isEnd;
        
        Node(){
            arr = new Node[26];
        }
    }
    public int prefixSuffixString(String s1[],String s2[]){
        Node front = new Node();
        Node back = new Node();
        
        for(String str: s1){
            fillTrieFront(front, str);
            fillTrieBack(back, str);
        }
        
        int ans = 0;
        
        for(String str: s2){
            if(isExistFront(front, str) || isExistBack(back, str)){
            ans++;
            }
        }
        return ans;
    }
    
    public void fillTrieFront(Node par, String s){
       for(int i=0; i<s.length(); ++i){
         char ch = s.charAt(i);
         if(par.arr[ch-'a']==null) par.arr[ch-'a'] = new Node();
         par = par.arr[ch-'a'];
       }
       
       par.isEnd = true;
    }
    
    public void fillTrieBack(Node par, String s){
       for(int i=s.length()-1; i>=0; --i){
         char ch = s.charAt(i);
         if(par.arr[ch-'a']==null) par.arr[ch-'a'] = new Node();
         par = par.arr[ch-'a'];
       }
       
       par.isEnd = true;
    }
    
    public boolean isExistFront(Node par, String s){
        for(int i=0; i<s.length(); ++i){
            char ch = s.charAt(i);
            if(par.arr[ch-'a']==null) return false;
            par = par.arr[ch-'a'];
        }
        
        return true;
    }
    public boolean isExistBack(Node par, String s){
        for(int i=s.length()-1; i>=0; --i){
            char ch = s.charAt(i);
            if(par.arr[ch-'a']==null) return false;
            par = par.arr[ch-'a'];
        }
        
        return true;
    }
}