//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
       
    Comparator <Job> idprofitComparator = new Comparator<Job>(){
           public int compare(Job j1, Job j2){
               if(j1.profit!=j2.profit) return j2.profit - j1.profit;
               else return j1.deadline - j2.deadline;
           };
        };
       
       boolean[]visited = new boolean[n+1];
       Arrays.sort(arr, idprofitComparator);
       int count = 0, money = 0;
       for(int i=0; i<n; ++i){
           int time = arr[i].deadline;
           if(visited[time]==false){
               count++;
               money += arr[i].profit;
               visited[time] = true;
           }else{
               for(int j=time-1; j>=1; --j){
                   if(visited[j]==false){
                       count++;
                       money += arr[i].profit;
                       visited[j] = true;
                       break;
                   }
               }
           }
       }
       
       return new int[]{count, money};
    }
}