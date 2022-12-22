package com.Trie;

public class TrieUse {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.add("SAMARTH");
        t.add("NITYA");
        System.out.println(t.search("SAMARTH"));
        System.out.println(t.search("NITYA"));
        System.out.println(t.search("SAM"));
        t.remove("NITYA");
        System.out.println(t.search("NITYA"));
    }



}
