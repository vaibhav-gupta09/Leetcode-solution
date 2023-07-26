//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        
        if(V!=res.length)
        return false;
        
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[]visited = new boolean[v];
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<v; ++i){
            if(visited[i]==false){
                dfs(adj, i, visited, st);
            } 
        }
        
        int[]ans = new int[v];
        int idx = 0;
        while(st.size() > 0){
            ans[idx++] = st.pop();
        }
        return ans;
    }
    
    static void dfs(ArrayList<ArrayList<Integer>> adj, int curr, boolean[]visited, 
    Stack<Integer> st){
        if(visited[curr]) return;
        
        visited[curr] = true;
        for(int nbr: adj.get(curr)){
            dfs(adj, nbr, visited, st);
        }
        
        st.push(curr);
    }
}
