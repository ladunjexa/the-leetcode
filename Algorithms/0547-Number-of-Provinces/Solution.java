class Solution {
    public int findCircleNum(int[][] isConnected) {
        int N = isConnected.length, p = 0;
        boolean[] v = new boolean[N];

        for(int i = 0; i < N; i++) 
            if(!v[i]) {
                p++;
                DFS(isConnected, v, i);
            }

        return p;
    }

    private void DFS(int[][] m, boolean[] v, int node) {
        v[node] = true;
        for(int j = 0; j < m.length; j++) {
            if(m[node][j] == 1 && !v[j])
                DFS(m, v, j);
        }
    }
}
