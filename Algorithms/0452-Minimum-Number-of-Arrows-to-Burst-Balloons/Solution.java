class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> a[1] - b[1]);
        int N = points.length, arrows = 1, prev = points[0][1];

        for(int i = 0; i < N; i++) {
            if(prev >= points[i][0] && prev <= points[i][1])
                continue;
            
            arrows++;
            prev = points[i][1];
        }

        return arrows;
    }
}
