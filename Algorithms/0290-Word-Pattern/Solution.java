class Solution {
    public boolean wordPattern(String pattern, String s) {
        String words[] = s.split(" ");
        if(words.length != pattern.length())
            return false;
        
        Map<Character, String> C2W = new HashMap<>();
        Map<String, Character> W2C = new HashMap<>();

        for(int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String w = words[i];

            C2W.put(c, w);

            if(W2C.containsKey(w)) {
                if(c != W2C.get(w))
                    return false;
            } else
                W2C.put(w, c);
        }
        
        return (W2C.size() == C2W.size());
    }
}
