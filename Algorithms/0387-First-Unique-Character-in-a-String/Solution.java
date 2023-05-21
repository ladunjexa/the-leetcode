class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int N = s.length();

        for(int i = 0; i < N; i++)
            map.put(
                s.charAt(i), 
                (map.containsKey(s.charAt(i)) ? map.get(s.charAt(i)) : 0) + 1 );

        for(int i = 0; i < N; i++)
            if(map.get(s.charAt(i)) == 1)
                return i;

        return -1;
    }
}
