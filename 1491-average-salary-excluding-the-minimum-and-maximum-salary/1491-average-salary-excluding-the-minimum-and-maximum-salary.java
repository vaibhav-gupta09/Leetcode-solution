class Solution {
    public double average(int[] salary) {
        double sum = 0;
        int max = 0, min = Integer.MAX_VALUE;
        for(int sal: salary){
            sum += (double)sal;
            max = Math.max(max, sal);
            min = Math.min(min, sal);
        }
        
        double avg = (sum - (double)max - (double)min)/(salary.length-2);
        return avg;
    }
}