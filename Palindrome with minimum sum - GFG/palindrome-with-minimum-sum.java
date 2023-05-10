//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            int res = obj.minimumSum(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int minimumSum(String s) {
        int i = 0,  j = s.length()-1, ans = 0;
        Stack<Character> st = new Stack<>();

        while(i<=j){
            char left = s.charAt(i);
            char right = s.charAt(j);
            if(left=='?' && right=='?') st.push('?');
            else if(left=='?') st.push(right);
            else if(right=='?') st.push(left);
            else{
                if(left!=right) return -1;
                else st.push(left);
            }
            i++;
            j--;
        }
        char prev = ' ';
        while(st.size() > 0){
            while(st.size()>0 && st.peek()=='?') st.pop();
            if(st.size()==0) break;
            
            char rem = st.pop();
            if(prev!=' ') ans += Math.abs(rem-prev)*2;
            prev = rem;
        }
        
        return ans;
    }
}
