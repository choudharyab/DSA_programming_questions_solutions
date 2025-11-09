//https://leetcode.com/problems/implement-trie-prefix-tree/description/?envType=problem-list-v2&envId=trie

class Trie {
    static class TrieNode {
        private TrieNode [] children;
        private boolean isEndofWord;

        TrieNode(){
            this.children = new TrieNode[26];
            this.isEndofWord = false;
        }


    }

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
        
    }
    
    public void insert(String word) {
        TrieNode current = root;
        for(int i = 0 ; i < word.length();i++){
            int idx = word.charAt(i) - 'a';
            if(current.children[idx] == null){
                current.children[idx] = new TrieNode();
            }
            current = current.children[idx];
        }
        current.isEndofWord = true; 
        
    }
    
    public boolean search(String word) {
        TrieNode current = root;
        for(int i = 0 ; i< word.length();i++){
            int idx = word.charAt(i) - 'a';
            if(current.children[idx] == null) return false;
            current = current.children[idx];
        }
        return current != null && current.isEndofWord;
        
    }
    
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        int i = 0 ;
        for(i = 0 ;  i < prefix.length();i++){
            int idx = prefix.charAt(i) - 'a';
            if(current.children[idx] == null) return false;
            current = current.children[idx];
        }
        return i == prefix.length();
        
    }
}

 