//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node next;
    public Node(int data)
    {
        this.data=data;
    }
}
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            int n=Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            Node head=new Node(Integer.parseInt(s[0]));
            Node copy=head;
            for(int i=1;i<n;i++){
                Node temp=new Node(Integer.parseInt(s[i]));
                copy.next=temp;
                copy=copy.next;
            }
            Solution ob=new Solution();
            Node ans=ob.modifyTheList(head);
            while(ans!=null){
                out.print(ans.data+" ");
                ans=ans.next;
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public static Node modifyTheList(Node head){
      Node node = head;
      Stack<Node> st = new Stack<>();
      Node slow = head, fast = head;
      while(fast!=null && fast.next!=null){
          slow = slow.next;
          fast = fast.next.next;
      }
      if(fast!=null) slow = slow.next;
    //   System.out.println(slow.data);
      while(slow!=null){
          st.push(slow);
          slow = slow.next;
      }
      
      while(st.size()>0){
          int temp = node.data;
          Node last = st.pop();
          node.data = last.data - temp;
          last.data = temp;
          node = node.next;
      }
      
      return head;
    }
}