class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiantQueue = new LinkedList<Integer>();
        Queue<Integer> direQueue = new LinkedList<Integer>();

        int N = senate.length();

        for(int i = 0; i < N; i++) {
            if(senate.charAt(i) == 'R')
                radiantQueue.offer(i);
            else
                direQueue.offer(i);
        }

        while(!radiantQueue.isEmpty() && !direQueue.isEmpty()) {
            int i = radiantQueue.poll(),
                j = direQueue.poll();
            
            if(i < j)
                radiantQueue.offer(i + N);
            else
                direQueue.offer(j + N);
        }
        
        return radiantQueue.isEmpty() ? "Dire" : "Radiant";
    }
}
