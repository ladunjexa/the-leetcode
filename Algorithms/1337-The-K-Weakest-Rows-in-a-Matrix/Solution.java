class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int N = mat.length, M = mat[0].length;
        int[][] rowAndSoldiers = new int[N][2];

        for(int i = 0; i < N; i++)
            rowAndSoldiers[i] = new int[] { countSoldiers(mat[i]), i};

        Arrays.sort(rowAndSoldiers, (x, y) ->
            (x[0] == y[0]) ? Integer.compare(x[1], y[1]) : Integer.compare(x[0], y[0]));

        int[] kWeakestRows = new int[k];

        for(int i = 0; i < k; i++)
            kWeakestRows[i] = rowAndSoldiers[i][1];
        
        return kWeakestRows;
    }

    private int countSoldiers(int[] v) {
        int low = 0, high = v.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(v[mid] > 0)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return low;
    }
}
