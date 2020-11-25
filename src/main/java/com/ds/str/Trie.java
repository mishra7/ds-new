package com.ds.str;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }


    public void add(String word) {
        int wSize = word.length();
        TrieNode current = root;
        for (int i = 0; i < wSize; i++) {
            Character ch = word.charAt(i);
            TrieNode curentTrie = current.getChild().get(ch);
            if (null == curentTrie) {
                TrieNode newTrie = new TrieNode();
                current.getChild().put(ch, newTrie);
                curentTrie = newTrie;

            }
            current = curentTrie;
        }
        current.setWordEnd(true);
    }

    public boolean isWordAvailable(String word) {
        int wSize = word.length();
        TrieNode current = root;
        for (int i = 0; i < wSize; i++) {

            Character ch = word.charAt(i);
            TrieNode currentTrie = current.getChild().get(ch);
            if (null == currentTrie) {
                return false;
            } else {
                current = currentTrie;
                if (wSize == i + 1) {
                    return current.isWordEnd() ? true : false;
                }
            }
        }
        return false;
    }

    public void search(String word) {
        int wSize = word.length();
        List<String> words = new ArrayList<>();
        TrieNode current = root;
        for (int i = 0; i < wSize; i++) {

            Character ch = word.charAt(i);
            TrieNode currentTrie = current.getChild().get(ch);
            if (null != currentTrie) {
                current = currentTrie;
                if (wSize == i + 1) {
                    if (current.getChild().isEmpty() && current.isWordEnd()) {
                        System.out.println(word);
                    } else {
                        System.out.println(search(current.getChild(), word, new ArrayList<>(), false));
                    }
                }
            }
        }

    }


    private List<String> search(Map<Character, TrieNode> trieMap, String prefix, List<String> listStr, boolean flag) {

        if (flag) {
            System.out.println();
            listStr.add(prefix);
            if (trieMap.isEmpty()) {
                return listStr;
            }
        }

        for (Map.Entry<Character, TrieNode> trieNode : trieMap.entrySet()) {
            search(trieNode.getValue().getChild(), prefix + trieNode.getKey(), listStr, trieNode.getValue().isWordEnd());
        }
        return listStr;

    }
}