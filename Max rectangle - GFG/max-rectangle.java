//{ Driver Code Starts
import java.util.*;

class FindMinCost
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().maxArea(arr, n, m));
		t--;
		}
	}
}
// } Driver Code Ends


/*Complete the function given below*/
class Solution {
    public int maxArea(int mat[][], int n, int m) {
        int []arr = new int[m];
        int area = 0;
        for(int a[]: mat){
            for(int i=0; i<m; ++i){
                if(a[i]==1) arr[i]++;
                else arr[i] = 0;
            }
            // for(int val: arr) System.out.print(val + " ");
            // System.out.println();
            area = Math.max(area, maxRectangle(arr));
            
        }
        
        return area;
    }
    
    public int maxRectangle(int[]arr){
        int n = arr.length;
        int[] nser = new int[n];
        nser[n-1] = n;
        Stack<Integer> st = new Stack<>();
        st.push(n-1);
        
        for(int i=n-2; i>=0; --i){
            while(st.size()>0 && arr[i] <= arr[st.peek()]) st.pop();
            if(st.size()==0) nser[i] = n;
            else nser[i] = st.peek();
            st.push(i);
        }
        
        st = new Stack<>();
        int ans = nser[0]*arr[0]; 
        st.push(0);
        
        for(int i=1; i<n; ++i){
            while(st.size()>0 && arr[i] <= arr[st.peek()]) st.pop();
            if(st.size()==0){
                ans = Math.max(ans, (nser[i])*arr[i]);
            }else{
                ans = Math.max(ans, (nser[i] -st.peek() - 1)*arr[i]);
            }
            
            st.push(i);
        }
        
        return ans;
    }
}