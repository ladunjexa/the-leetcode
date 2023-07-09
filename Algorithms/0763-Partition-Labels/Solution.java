class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];

        for(int i = 0; i < s.length(); i++)
            last[s.charAt(i) - 'a'] = i;
        
        int j = 0, anchor = 0;

        List<Integer> out = new ArrayList<Integer>();

        for(int i = 0; i < s.length(); i++) {
            j = Math.max(j, last[s.charAt(i) - 'a']);
            if(i == j) {
                out.add(i - anchor + 1);
                anchor = i + 1;
            }
        }

        return out;
    }
}
