class Solution {
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        Deque<String> wordStack = new ArrayDeque<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                wordStack.addFirst(word);
            }
        }

        return String.join(" ", wordStack);
    }
}
