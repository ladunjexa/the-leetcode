class Solution {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> mergedIntervals = new ArrayList<>();
        int N = intervals.length, i = 0;

        // Add intervals before newInterval
        while(i < N && intervals[i][1] < newInterval[0])
            mergedIntervals.add(intervals[i++]);
        
        // Merge overlapping intervals
        while(i < N && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i++][1]);
        }

        mergedIntervals.add(newInterval);
        
        // Add remaining intervals
        while(i < N)
            mergedIntervals.add(intervals[i++]);
        
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
