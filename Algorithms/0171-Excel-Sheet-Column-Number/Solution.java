class Solution {
    public int titleToNumber(String columnTitle) {
        int N = columnTitle.length(), out = 0;

        if(N == 0 || columnTitle == null)
            return out;
        
        for(int i = 0; i < N; i++) {
            char c = Character.toUpperCase(columnTitle.charAt(i));
            out *= 26;
            out += c - 'A' + 1;
        }

        return out;
    }
}
