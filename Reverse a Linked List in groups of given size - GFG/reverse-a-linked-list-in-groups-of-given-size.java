//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class ReverseInSize
{
    static Node head;
    
    public static void main (String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            Node tail = head;
            for(int i = 1; i < n; i++)
            {
                int a = Integer.parseInt(s[i]);
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail =tail.next;
            }
            
            int k = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            Node res = ob.reverse(head, k);
            printList(res,out);
            out.println();
        }
        out.close();
    }
    
    public static void printList(Node node,PrintWriter out)
    {
        while(node != null)
        {
            out.print(node.data + " ");
            node = node.next;
        }
    }
    
}


// } Driver Code Ends


/*node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution
{
    public static Node reverse(Node node, int k){
        Node prev = null, head =null;
        Node curr = node;
        Stack<Node> st = new Stack<>();
        while(curr != null){
            
            if(st.size()<k){
                st.push(curr);
                curr = curr.next;
                continue;
            }
            
            if(head==null) head = st.peek();
            else prev.next = st.peek();
            
            while(st.size()>0){
                Node rem = st.pop();
                if(st.size()>0) rem.next = st.peek();
                else {
                    prev = rem;
                    rem.next = null;
                }
            }
            
            st.push(curr);
            curr = curr.next;
        }
            
            if(head==null) head = st.peek();
            else prev.next = st.peek();
            while(st.size()>0){
                Node rem = st.pop();
                // System.out.println(rem.data);
                if(st.size()>0) rem.next = st.peek();
                else rem.next = null;
            }
        return head;
    }
}

