class Solution {
    public int compress(char[] chars) {
        int size = 0, c = 1, N = chars.length;

        for(int i = 1; i < N + 1; i++) {

            if(i == N || chars[i] != chars[i - 1]) {
                chars[size++] = chars[i - 1];

                if(c > 1) {
                    String s = c + "";
                    for(int j = 0; j < s.length(); j++)
                        chars[size++] = s.charAt(j);
                }

                c = 1;
            } else
                c++;
                
        }

        return size;
    }
}
