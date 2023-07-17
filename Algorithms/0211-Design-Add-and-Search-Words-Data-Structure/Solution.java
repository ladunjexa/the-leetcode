class Trie {
    Trie[] wordNode;
    boolean isWordEnd;

    public Trie() {
        wordNode = new Trie[26];
        isWordEnd = false;
    }
}

class WordDictionary {
    Trie root;

    public WordDictionary() {
        root = new Trie();
    }
    
    public void addWord(String word) {
        Trie node = root;
        for(char c : word.toCharArray()) {
            if(node.wordNode[c - 'a'] == null)
                node.wordNode[c - 'a'] = new Trie();
            node = node.wordNode[c - 'a'];
        }
        node.isWordEnd = true;
    }
    
    public boolean search(String word) {
        return advancedSearch(root, word, 0);
    }

    public boolean advancedSearch(Trie node, String word, int i) {
        if(i == word.length())
            return node.isWordEnd;
        
        char ch = word.charAt(i);

        if(ch == '.') {
            for(int j = 0; j < 26; j++)
                if(node.wordNode[j] != null && advancedSearch(node.wordNode[j], word, i + 1))
                    return true;
            return false;
        } else {
            if(node.wordNode[ch - 'a'] == null)
                return false;
            return advancedSearch(node.wordNode[ch - 'a'], word, i + 1);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
