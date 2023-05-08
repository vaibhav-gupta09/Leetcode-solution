class Solution {
    public int diagonalSum(int[][] mat) {
        int n= mat.length, sum = 0;
        for(int i=0; i<n; i++){
            sum += mat[i][i] + (i==(n-i-1)?0:mat[i][n-i-1]);
        }
        
        return sum;
    }
}