class Solution {
    public int maxPoints(int[][] points) {
        int N = points.length, k = 1;

        for(int i = 0; i < N; i++) {
            int[] startPoint = points[i];

            for(int j = i + 1; j < N; j++) {
                int[] endPoint = points[j];
                int pointsOnLine = countPointsOnLine(startPoint[0], endPoint[0], startPoint[1], endPoint[1], points);
                if(k < pointsOnLine)
                    k = pointsOnLine;
            }
        }

        return k;
    }

    public int countPointsOnLine(int x1, int x2, int y1, int y2, int[][] points) {
        long dx = (x2 - x1), dy = (y2 - y1);
        int count = 0;

        for (int[] p : points) {
            long dxp = (p[0] - x1), dyp = (p[1] - y1);

            if (dx * dyp == dy * dxp)
                count++;
        }

        return count;
    }
}
