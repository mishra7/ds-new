package com.ds.str;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    private Map<Character, TrieNode> child;

    private boolean isWordEnd;

    @Override
    public String toString() {
        return "TrieNode{" +
                "child=" + child +
                ", isWordEnd=" + isWordEnd +
                '}';
    }

    public TrieNode() {
        this.child = new HashMap<>();
        isWordEnd = false;
    }

    public boolean isWordEnd() {
        return isWordEnd;
    }

    public void setWordEnd(boolean wordEnd) {
        isWordEnd = wordEnd;
    }

    public Map<Character, TrieNode> getChild() {
        return child;
    }

    public void setChild(Map<Character, TrieNode> child) {
        this.child = child;
    }

}
