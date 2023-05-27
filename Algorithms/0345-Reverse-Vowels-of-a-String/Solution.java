class Solution {
    public String reverseVowels(String s) {
        int low = 0, high = s.length() - 1;
        
        while(low < high) {
            while(low < high && !isVowelCharacter(s.charAt(low)))
                low++;
            while(low < high && !isVowelCharacter(s.charAt(high)))
                high--;

            if (low < high)
                s = s.substring(0, low) + s.charAt(high) + s.substring(low + 1, high) + s.charAt(low) + s.substring(high + 1);

            low++;
            high--;
        }

        return s;
    }

    private boolean isVowelCharacter(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
