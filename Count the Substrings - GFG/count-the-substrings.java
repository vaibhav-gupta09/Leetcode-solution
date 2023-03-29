//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.countSubstring(S);
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int countSubstring(String s) 
    { 
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        int count = 0, ans = 0;
        
        for(char ch: s.toCharArray()){
            if(ch>='a' && ch<='z'){
                count++;
            }else{
                count--;
            }
            
            ans += map.getOrDefault(count, 0);
            map.put(count, map.getOrDefault(count, 0)+1);
        }
        
        return ans;
    }
} 
