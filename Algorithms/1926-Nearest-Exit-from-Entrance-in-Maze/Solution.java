class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int M = maze.length, N = maze[0].length, out = 0;
        Deque<int[]> q = new ArrayDeque<>();

        q.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        
        int[] directions = {-1, 0, 1, 0, -1};
        
        while(!q.isEmpty()) {
            ++out;

            for (int k = q.size(); k > 0; --k) {
                int[] p = q.poll();
                int i = p[0], j = p[1];

                for (int l = 0; l < 4; ++l) {
                    int x = i + directions[l], y = j + directions[l + 1];
                    if (x >= 0 && x < M && y >= 0 && y < N && maze[x][y] == '.') {
                        if (x == 0 || x == M - 1 || y == 0 || y == N - 1)
                            return out;
                        
                        q.offer(new int[] {x, y});
                        maze[x][y] = '+';
                    }
                }
            }
        }
        return -1;
    }
}
