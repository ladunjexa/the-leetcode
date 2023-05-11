class Solution {
    public String reverseWords(String s) {
        int len = s.length(), dest = 0;
        char[] res = s.toCharArray();

        for(int i = 0; i < len; i++) {
            if(res[i] != ' ' && i != len - 1) continue;
            reverseInsert(res, dest, (i < len - 1)? i - 1 : i);
            dest = (i + 1);
        }

        return String.valueOf(res);
    }

    private void reverseInsert(char[] c, int low, int high) {
        char ch = ' ';
        while(low < high) {
            ch = c[low];
            c[low++] = c[high];
            c[high--] = ch;
        }
    }
}
