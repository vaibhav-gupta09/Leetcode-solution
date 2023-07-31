//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
// Position this line where user code will be pasted.

class GFG {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    int x = sc.nextInt();
                    temp.add(x);
                }
                adj.add(temp);
            }

            Solution obj = new Solution();
            System.out.println(obj.countPaths(n, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair {
    int node;
    long distance;
    
    Pair(int node, long distance) {
        this.node = node;
        this.distance = distance;
    }
}

class Solution {
    

    static int countPaths(int n, List<List<Integer>> roads) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n;i++) {
            ArrayList<Pair> temp = new ArrayList<>();
            adj.add(temp);
        }
        int m = roads.size();
        for(int i = 0; i < m;i++) {
            adj.get(roads.get(i).get(0)).add(new Pair(roads.get(i).get(1),roads.get(i).get(2)));
            adj.get(roads.get(i).get(1)).add(new Pair(roads.get(i).get(0), roads.get(i).get(2)));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> (int)(x.distance - y.distance));
        pq.add(new Pair(0,0));
        long[] dist = new long[n];
        int[] ways = new int[n];
        for(int i = 0; i < n;i++) {
            dist[i] = Long.MAX_VALUE;
            ways[i] = 0;
        }
        dist[0] = 0;
        ways[0] = 1;
        int mod = (int)(1e9 + 7);
        
        while(pq.size() != 0) {
            Pair ele = pq.peek();
            pq.remove();
            int node = ele.node;
            long distance = ele.distance;
            
            for(Pair pair:adj.get(node)) {
                int adjNode = pair.node;
                long adjDist = pair.distance;
                if(adjDist + distance < dist[adjNode]) {
                    dist[adjNode] = adjDist + distance;
                    ways[adjNode] = ways[node];
                    pq.add(new Pair(adjNode, adjDist + distance));
                }
                else if(adjDist + distance == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        return ways[n-1] % mod;
        
        
        // Your code here
    }
}
