class Solution {
    public String reverseWords(String s) {
        List<String> words = new ArrayList<String>();

        for(int i = 0, p = 0; i < s.length(); i++, p = i) {
            if(s.charAt(i) == ' ')
                continue;
            
            while(i < s.length() && s.charAt(i) != ' ')
                i++;
            
            words.add(s.substring(p, i));
        }

        String result = words.get(words.size() - 1);

        for(int i = words.size() - 2; i >= 0; i--)
            result += " " + words.get(i);
        
        return result;
    }
}
