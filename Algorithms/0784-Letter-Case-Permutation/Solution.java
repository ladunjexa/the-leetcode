class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();

        letterCasePermutation(s, "", 0, result);
        
        return result;
    }

    private void letterCasePermutation(String source, String current, int i, List<String> result) {
        if(i == source.length()) {
            result.add(current);
            return ;
        }

        char ch = source.charAt(i);

        if(!Character.isDigit(ch)) {
            letterCasePermutation(source, current + Character.toUpperCase(ch), i + 1, result);
            letterCasePermutation(source, current + Character.toLowerCase(ch), i + 1, result);
        } else
            letterCasePermutation(source, current + ch, i + 1, result);
    }
}
