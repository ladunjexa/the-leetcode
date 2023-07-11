class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, total = 0;

        for(int i = 0, g = 0; i < gas.length; i++) {
            int diff = (gas[i] - cost[i]);

            if(g + diff < 0) {
                start = (i + 1);
                g = 0;
            } else
                g += diff;
            
            total += diff;
        }
        
        return (total < 0) ? -1 : start;
    }
}
