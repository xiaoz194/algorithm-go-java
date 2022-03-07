package class06_trie_tree;

/**
 * @Classname Code01_TrieTree
 * @Description 前缀树板子  "abc","abe","ab","aed","aef"
 * @Date 2022/2/12
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code01_TrieTree {
    public static class TrieNode{
        /**
         * 字符串加入加入前缀树时，沿途的pass值++，结尾的end值++
         * 跟节点的p值表示一共加入了多少个字符串
         * **/
        public int pass;  //表示从起始位置到某节点位置的字串被当作多少次前缀
        public int end;  //表示某字符串被加入过多少次
        public TrieNode[] nexts;
        public TrieNode(){
            pass = 0;
            end = 0;
            //nexts[0] == null 没有走向a的路
            //nexts[0] != null 有走向a的路
            //nexts[25] != null 有走向z的路
            nexts = new TrieNode[26];
        }
    }

    public static class Trie{
        private TrieNode root;

        public Trie(){
            root = new TrieNode();
        }

        //前缀树的插入
        public void insert(String word){
            if(word == null) return;
            char[] chs = word.toCharArray();
            TrieNode node = root;
            node.pass++;
            int index = 0;
            for(int i=0;i<chs.length;i++){ //从左往右遍历字符
                index = chs[i] - 'a'; //字符对应走向哪条路 a对应的index为0，b对应的index为1，...
                if(node.nexts[index] == null){
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.pass++;
            }
            node.end++;
        }

        //查询word这个单词被加入过几次
        public int search(String word){
            if(word == null) return 0;
            TrieNode node = root;
            char[] chs = word.toCharArray();
            int index = 0;
            for(int i = 0;i<chs.length;i++){
                index = chs[i] - 'a';
                if(node.nexts[index] == null){
                    //如果走着走着没路了，即没找到word这个字符，如前缀树上只挂了"abc"，但是现在要查
                    //"abcde"，那么走到c的时候，就发现它的下一步没有路可走了，则说明"abcde"不存在，返回0
                    return 0;
                }
                node = node.nexts[index];
            }
            //否则，返回走到最后的那个节点的end值。
            return node.end;
        }

        //查询所有字串中，有几个是以pre这个字串作为前缀的
        public int prefixNumber(String pre){
            if(pre == null) return 0;
            TrieNode node = root;
            char[] chs = pre.toCharArray();
            int index = 0;
            for(int i=0;i<chs.length;i++){
                index = chs[i] - 'a';
                if(node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.pass;
        }

        //在前缀树中删除一个字符串：如果pass=0，则说明这个节点的后面已经没有节点了，
        // 则直接把后面所有节点删除，否则说明后面还有节点，让那个pass--，如果是字符串的最后一个字符end--
        public void delete(String word){
            if(search(word)>0){
                char[] chs = word.toCharArray();
                int index = 0;
                TrieNode node = root;
                node.pass--;
                for(int i=0;i<chs.length;i++){
                    index = chs[i] - 'a';
                    if(--node.nexts[index].pass==0){
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;

            }



        }


    }






}
