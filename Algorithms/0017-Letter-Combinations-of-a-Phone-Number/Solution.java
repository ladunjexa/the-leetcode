class Solution {

    String[] map = {null, "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> combinations = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return combinations;

        letterCombinations(digits, 0, "");
        return combinations;
    }

    private void letterCombinations(String digits, int index, String c) {
        if(index == digits.length()) {
            combinations.add(c);
            return;
        }

        String opt = map[digits.charAt(index) - '0'];
        
        for(int i = 0; i < opt.length(); i++)
            letterCombinations(digits, index + 1, c + opt.charAt(i));
    }
    
}