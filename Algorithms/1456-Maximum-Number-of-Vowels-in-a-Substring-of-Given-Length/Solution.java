class Solution {
    public int maxVowels(String s, int k) {
        int curr = 0;

        for(int i = 0; i < k; i++)
            if(isVowelCharacter(s.charAt(i)))
                curr++;
        
        int max = curr;

        for(int i = k; i < s.length(); i++) {
            if(isVowelCharacter(s.charAt(i - k)))
                curr--;
            
            if(isVowelCharacter(s.charAt(i)))
                curr++;
            
            max = Math.max(max, curr);
        }

        return max;
    }

    private boolean isVowelCharacter(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}
