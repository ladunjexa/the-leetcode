class Solution {
    public int thirdMax(int[] nums) {
        Integer st = null, nd = null, rd = null;

        for(Integer k : nums) {
            if(k.equals(st) || k.equals(nd) || k.equals(rd))
                continue;
            
            if(st == null || k > st) {
                rd = nd;
                nd = st;
                st = k;
            } else if(nd == null || k > nd) {
                rd = nd;
                nd = k;
            } else if(rd == null || k > rd)
                rd = k;
        }

        return (rd == null) ? st : rd;
    }
}
