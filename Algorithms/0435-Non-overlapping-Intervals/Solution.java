class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);

        int j = intervals[0][1], c = 0;
        
        for(int k = 1; k < intervals.length; k++)
            if(intervals[k][0] >= j)
                j = Math.max(j, intervals[k][1]);
            else
                c++;

        return c;
    }
}
