package trie;

public class Trie {
    public TrieNode start;

    public  class TrieNode{
        TrieNode[] child;
        boolean[] end;

        TrieNode(){
            child = new TrieNode[26];
            end = new boolean[26];
        }

    }

    public Trie() {
        start = new Trie.TrieNode();
    }

    public void insert(String word) {
        TrieNode current = start;
        for(int i = 0;i<word.length();i++){
            int nextChar = word.charAt(i)-'a';
            if((i+1)==word.length()){
                current.end[nextChar] = true;
            } else{
                if(current.child[nextChar]==null){
                    current.child[nextChar] = new TrieNode();
                }
                current = current.child[nextChar];
            }
        }
    }

    public boolean search(String word) {
        TrieNode current = this.start;
        for(int i = 0;i<word.length();i++){
            int nextChar = word.charAt(i)-'a';
            if((i+1==word.length() && current.end[nextChar]!=true) ||( i+1<word.length() &&
                    current.child[nextChar]==null)) {
                return false;
            }
            current = current.child[nextChar];
        }
        return true;
    }



    public boolean startsWith(String prefix) {
        TrieNode current = start;
        for(int i = 0;i<prefix.length();i++){
            int nextChar = prefix.charAt(i)-'a';
            if(i+1<prefix.length() && current.child[nextChar]==null ){
                return false;
            } else if(i+1==prefix.length() && !((current.end[nextChar]==true ||
                    current.child[nextChar]!=null))){
                return false;
            }
            current = current.child[nextChar];
        }
        return true;
    }

    public static void main(String ... s){
        Trie abc = new Trie();
        abc.insert("apple");
        System.out.println(abc.search("apple"));
        System.out.println(abc.startsWith("app"));
        System.out.println(abc.search("app"));
    }
}
