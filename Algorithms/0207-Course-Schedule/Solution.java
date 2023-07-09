class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());
        
        for(int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }

        HashSet<Integer> visited = new HashSet<Integer>();

        return (BFS(inDegree, adj) == numCourses);
    }

    private int BFS(int[] inDegree, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> queue = new ArrayDeque<>();
        int out = 0;

        for(int i = 0; i < inDegree.length; i++)
            if(inDegree[i] == 0)
                queue.add(i);
        
        while(!queue.isEmpty()) {
            int dequedElement = queue.remove();

            for(int i : adj.get(dequedElement))
                if(--inDegree[i] == 0)
                    queue.add(i);
            
            out++;
        }

        return out;
    }
}
