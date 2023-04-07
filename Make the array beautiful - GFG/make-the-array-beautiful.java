//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {

        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[] arr = IntArray.input(br, n);

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.makeBeautiful(arr);
            for (int e : res) out.print(e + " ");
            out.println();
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> makeBeautiful(int[] arr) {
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);
        for(int i=1; i<arr.length; ++i){
            if(st.size()==0){
                st.push(arr[i]);
                continue;
            }
            
            if( (arr[i]<0 && st.peek()>=0) || (arr[i]>=0 && st.peek()<0) ){
                st.pop();
            }else{
                st.push(arr[i]);
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        while(st.size() > 0){
            int val = st.pop();
            list.add(val);
        }
        Collections.reverse(list);
        return list;
    }
}
