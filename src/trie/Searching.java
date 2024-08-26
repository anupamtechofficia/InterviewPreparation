package trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Searching {

    public  class TrieNode{
        Searching.TrieNode[] child;
        boolean[] end;

        TrieNode(){
            child = new Searching.TrieNode[26];
            end = new boolean[26];
        }

    }

    public void insert(String word, Searching.TrieNode start) {
        Searching.TrieNode current = start;
        for(int i = 0;i<word.length();i++){
            int nextChar = word.charAt(i)-'a';
            if((i+1)==word.length()){
                current.end[nextChar] = true;
            } else{
                if(current.child[nextChar]==null){
                    current.child[nextChar] = new Searching.TrieNode();
                }
                current = current.child[nextChar];
            }
        }
    }

    public List<String> search(TrieNode node, String prefix, int size) {
        List<String> temp = new ArrayList<>();
        boolean childfound = false;
        for(int i = 0;i<node.end.length;i++){
            if(node.child[i] !=null){
                childfound = true;
            }
            if(node.end[i]==true && temp.size()<size){
                char c = (char)((int)'a' + i);
                    temp.add(prefix+c);
            }
        }
        if(temp.size()==3 || !childfound){
            return temp;
        }
        for(int i = 0 ;i< node.child.length;i++){
            if(node.child[i]!=null){
                char c = (char)((int)'a' + i);
                List<String> childs = search(node.child[i], "", size);
                for (String child : childs){
                    if(temp.size()<size){
                        temp.add(prefix + c + child);
                    }
                    if(temp.size() == size){
                        return temp;
                    }
                }
            }
        }
        return temp;
    }

    public Searching.TrieNode startsWith(String prefix, Searching.TrieNode start) {
        Searching.TrieNode current = start;
        for(int i = 0;i<prefix.length();i++){
            int nextChar = prefix.charAt(i)-'a';
            if(i+1<prefix.length() && current.child[nextChar]==null ){
                return null;
            } else if(i+1==prefix.length() && !((current.end[nextChar]==true ||
                    current.child[nextChar]!=null))){
                return null;
            } else if(i+1==prefix.length()){
                break;
            }
            current = current.child[nextChar];
        }
        return current;
    }


    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Searching.TrieNode start = new Searching.TrieNode();
        for(String s : products){
            insert(s, start);
        }
        List<List<String>> ans = new ArrayList<>();

        for (int i = 0 ; i< searchWord.length();i++){
            TrieNode endNode = startsWith(searchWord.substring(0,i+1), start);
            List<String> matched = new ArrayList<>();
            if(endNode!=null){
                if(endNode.end[searchWord.charAt(i)-'a']==true){
                    matched.add(searchWord.substring(0,i+1));
                }
                if(endNode.child[searchWord.charAt(i) - 'a']!=null) {
                    matched.addAll(search(
                            endNode.child[searchWord.charAt(i) - 'a'], searchWord.substring(0, i + 1),
                            3-matched.size()));
                }
                Collections.sort(matched);
            }
            ans.add(matched);

        }

        return ans;
    }

    public static void main(String ... s){
        Searching a = new Searching();
        String[] abc = new String[1];
        abc[0] = "havana";
        System.out.println(a.suggestedProducts(abc, "havana"));
    }
}
