//https://leetcode.com/problems/design-add-and-search-words-data-structure/description/?envType=problem-list-v2&envId=trie

class WordDictionary {
    static class TrieNode {
        private TrieNode [] children;
        private boolean isEndOfWord;

        TrieNode(){
            this.children = new TrieNode[26];
            this.isEndOfWord = false;
        }
    }
    private TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
        
    }
    
    public void addWord(String word) {
        TrieNode current = root;
        for(int i = 0 ; i < word.length();i++){
            int idx = word.charAt(i) - 'a';
            if(current.children[idx] == null) current.children[idx] = new TrieNode();
            current = current.children[idx];
        }
        current.isEndOfWord = true;
        
    }
    
    public boolean search(String word) {
        return dfs(word,0,root);
    }

    private boolean dfs(String word,int index,TrieNode node){
        if(index == word.length()){
            return node.isEndOfWord;
        }

        char c = word.charAt(index);

        //check wildcard is present
        if(c == '.'){
            for(TrieNode child : node.children){
                if(child != null && dfs(word,index+1 , child)){
                    return true;
                }
            }
            return false;

        } else {
            int idx = c - 'a';
            TrieNode next = node.children[idx];
            if (next == null) return false;
            return dfs(word, index + 1, next);
        }

    }
    
}
