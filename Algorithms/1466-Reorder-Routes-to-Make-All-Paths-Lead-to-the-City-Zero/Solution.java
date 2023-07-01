class Solution {
    int changes = 0;

    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<List<Integer>>> adj = new HashMap<>();

        for(int[] c : connections) {
            adj.computeIfAbsent(c[0], k -> new ArrayList<List<Integer>>()).add(Arrays.asList(c[1], 1));
            adj.computeIfAbsent(c[1], k -> new ArrayList<List<Integer>>()).add(Arrays.asList(c[0], 0));
        }

        DFS(0, -1, adj);

        return changes;
    }

    private void DFS(int node, int parent, Map<Integer, List<List<Integer>>> adj) {
        if(!adj.containsKey(node))
            return;
        
        for(List<Integer> neigh : adj.get(node)) {
            int child = neigh.get(0), sgn = neigh.get(1);
            if(child != parent) {
                changes += sgn;
                DFS(child, node, adj);
            }
        }
    }
}
