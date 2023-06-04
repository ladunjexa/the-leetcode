class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int N = rooms.size();
        boolean[] visited = new boolean[N];

        travelRooms(rooms, 0, visited);

        for(int i = 0; i< N; i++)
            if(!visited[i])
                return false;

        return true; 
    }

    private void travelRooms(List<List<Integer>> rooms, int r, boolean[] v) {
        v[r] = true;
        
        for(int key : rooms.get(r))
            if(!v[key])
                travelRooms(rooms, key, v);
    }
}
