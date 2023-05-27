class TrieNode {
    private TrieNode[] children;
    private boolean isEnd;

    TrieNode() {
        this.children = new TrieNode[26];
        this.isEnd = false;
    }

    public boolean containsKey(char ch) {
        return (this.children[ch - 'a'] != null);
    }

    public void put(char ch, TrieNode node) {
        this.children[ch - 'a'] = node;
    }

    public TrieNode get(char ch) {
        return this.children[ch - 'a'];
    }

    public void setIsEnd() {
        this.isEnd = true;
    }

    public boolean getIsEnd() {
        return this.isEnd;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();    
    }
    
    public void insert(String word) {
        TrieNode current = root;

        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(!current.containsKey(ch))
                current.put(ch, new TrieNode());

            current = current.get(ch);
        }

        current.setIsEnd();
    }
    
    public boolean search(String word) {
        TrieNode current = root;
        
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(!current.containsKey(ch))
                return false;
            
            current = current.get(ch);
        }

        return current.getIsEnd();
    }
    
    public boolean startsWith(String prefix) {
        TrieNode current = root;

        for(int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if(!current.containsKey(ch))
                return false;

            current = current.get(ch);
        }

        return true;
    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
