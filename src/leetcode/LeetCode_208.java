package leetcode;


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
class LeetCode_208 {
    public class Trie{
        public class TrieNode {
            public int pass;
            public int end;
            TrieNode[] nexts;
            public TrieNode() {
                pass = 0;
                end = 0;
                nexts = new TrieNode[26];
            }
        }

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if (word == null) return;
            char[] chs = word.toCharArray();
            TrieNode node = root;
            node.pass++;
            int index;
            for(int i = 0;i<chs.length;i++) {
                index = chs[i] -'a';
                if (node.nexts[index] == null) {
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.pass++;
            }
            node.end++;
        }

        public boolean search(String word) {
            if(word == null) return false;
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index;
            for(int i=0;i<chs.length;i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] ==null){
                    return false;
                }
                node = node.nexts[index];
            }
            return node.end > 0;
        }

        public boolean startsWith(String prefix) {
            if(prefix == null) return false;
            char[] chs = prefix.toCharArray();
            TrieNode node = root;
            int index;
            for(int i=0;i<chs.length;i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] ==null){
                    return false;
                }
                node = node.nexts[index];
            }
            return node.pass > 0;
        }
    }

}


