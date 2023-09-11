class WordDictionary {
    public class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord = false;
    }
    
    public TrieNode root = new TrieNode();

    /** Initialize your data structure here. */
    public WordDictionary() {
        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode node = root;
        Queue<TrieNode> queue = new LinkedList<>();
        queue.offer(node);
        int level = 0;
        while (!queue.isEmpty() && level <= word.length()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TrieNode current = queue.poll();
                
                if (level == word.length()) {
                    if (current.isWord) {
                        return true;
                    } else {
                        continue;
                    }
                }
                
                char c = word.charAt(level);
                
                if (c == '.') {
                    for (TrieNode t : current.children) {
                        if (t != null) {
                            queue.offer(t);
                        }
                    }
                } else if (current.children[c - 'a'] != null) {
                    queue.offer(current.children[c - 'a']);
                }
            }
            level++;
        }
        return false;
    }
}