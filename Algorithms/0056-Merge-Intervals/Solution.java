class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        List<int[]> nonOverlapping = new ArrayList<>();

        int lo = intervals[0][0], hi = intervals[0][1]; 

        for(int i = 1; i < intervals.length; i++) {
            if(hi < intervals[i][0]) {
                nonOverlapping.add(new int[] { lo, hi });
                lo = intervals[i][0];
                hi = intervals[i][1];
            } else 
                hi = Math.max(hi, intervals[i][1]);
        }

        nonOverlapping.add(new int[] { lo, hi });

        return nonOverlapping.toArray(new int[nonOverlapping.size()][]);
    }
}
