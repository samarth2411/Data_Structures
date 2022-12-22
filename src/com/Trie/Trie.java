package com.Trie;

class TrieNode{

    char data;
    boolean isTerminal;
    TrieNode[] children; // to store the reference of the child nodes every node can store upto 26 letters as reference in the form of tree

    int childCount; // use in delete function chound the number of childs of every node
    public TrieNode(char data){
       this.data = data;
       this.isTerminal = false;
       this.children = new TrieNode[26]; // as every node can store reference to all the 26 characters .
        this.childCount = 0;
    }
}
public class Trie {

    private TrieNode root;

    public Trie(){
        root = new TrieNode('\0'); // \0 indicates a null character

        // initially the root node is pointing to null character , isTerminal is false and we have array referencing to the root node and all
        // the node values here are referencing to null and same for every such child nodes that we will be adding to the root node
    }

    private void addHelper(TrieNode root , String word){

        if(word.length()==0){
            root.isTerminal = true; // once we are at the terminal now the root is pointing to the last character of the string word make that
                                    // root node as terminal and return
            return;
        }

        int childIndex  = word.charAt(0)-'A'; // index of word we have to search for
        TrieNode child = root.children[childIndex]; // storing the character present on the childindex into a trieNode
        if(child==null){ // if there is no character present at childIndex than we will add that character
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;  // adding the child node to the childIndex of the aaray poitning by the root node i.e children array
            root.childCount++; // at the child index eg--> B will be stored at 2 index , C at 3 in 26 size children array and so on.
        }
        addHelper(child,word.substring(1)); // recursively doing this process again and again and making the node we added as the root
                                                     // as once the child node is added it will start adding from the child node not from the starting (rootNode)
    }

    public void add(String word){
        addHelper(root,word);
    }

    private boolean searchHelper(TrieNode root , String word){
        if(word.length()==0){
            return root.isTerminal; // if the word is there check whether it the last word id the terminal word or not if true return true else false
                                    // becoz it is possible that the word is not present as whole it may be present as a substring of some other word
                                    // example --> not is present in nothing also and not as well
        }

        int childIndex = word.charAt(0)-'A';
        TrieNode child = root.children[childIndex];
        if(child==null){ // if the child node is not present than return false there only
            return false;
        }
        return searchHelper(child,word.substring(1));
    }
    public boolean search(String word){
        return searchHelper(root,word);
    }


    private void removeHelper(TrieNode root , String word){
        if(word.length()==0){
            root.isTerminal = false;
            return;
        }
        int childIndex = word.charAt(0)-'A';
        TrieNode child = root.children[childIndex];
        if(child==null){
            return;
        }
        removeHelper(child,word.substring(1));
        if(!child.isTerminal && child.childCount==0){ // now we are deleting if the word left after deletion has a meaning or not if no meaning than delete the whole word
                                                     // i.e if the child left is not a terminal node and also the child left does not have any further child nodes
            root.children[childIndex] = null;
            root.childCount--;
        }
    }
    public void remove(String word){
        removeHelper(root,word);
    }


}
