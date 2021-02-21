class Trie {

    Trie []child = new Trie[26];
        boolean isEnd = false;
        /** Initialize your data structure here. */
        public Trie() {
    
        }
        
        /** Inserts a word into the trie. */
        public void insert(String word) {
            Trie t = find(word,true);
            t.isEnd = true;
        }
        
        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie t = find(word,false);
            return t!=null && t.isEnd;
        }
        
        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Trie t = find(prefix,false);
            return t!=null;
        }
    
        private Trie find(String word, boolean insertMode){
            Trie t = this;
            for(int i = 0; i < word.length(); i++){
                int index = word.charAt(i)-'a';
                if(t.child[index]==null){
                    if(insertMode){
                        t.child[index] = new Trie();
                    }else{
                        return null;
                    }
                }
                t = t.child[index];
            }
            return t;
        }
    }
    
    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */