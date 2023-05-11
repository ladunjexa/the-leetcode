class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0 || s.length() % 2 != 0) return false;
        Map<Character, Character> cor = new HashMap<>();
        cor.put('(',')');
        cor.put('{','}');
        cor.put('[',']');

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(cor.containsKey(c))
                stack.push(c);
            else {
                if(stack.isEmpty()) return false;
                char lc = stack.pop();
                if(!(cor.get(lc) == c))
                    return false;
            }
        }

        return stack.isEmpty(); 
    }
}