class Solution {
    public void reverseString(char[] s) {
        int k = s.length - 1;
        for(int i = 0; i < ((k + 1) / 2); i++)
            if(s[i] != s[k - i]) 
                swap(s, i, k - i);
    }

    private void swap(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
}
