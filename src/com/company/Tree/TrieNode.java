package com.company.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author rmandada
 */
public class TrieNode {

    public static void main(String[] args) {
        List<String> s = Arrays.asList(new String[]{"zebra", "dog", "duck", "dove"});
        findPrefix(s);
    }

    TrieNode[] children;
    int frequency;

    public TrieNode() {
        children = new TrieNode[26];
        for (int i = 0; i <26 ; i++) {
            children[i] = null;
            frequency = 1;
        }
    }

    public static void insert(TrieNode root, String str) {
        int len = str.length();
        TrieNode temp = root;
        for (int i = 0; i <len ; i++) {
            int idx = str.charAt(i)-97;
            if (temp.children[idx] == null) {
                temp.children[idx] = new TrieNode();
            } else {
                temp.children[idx].frequency++;
            }

            temp = temp.children[idx];
        }
    }

    public static ArrayList<String> findPrefix(List<String> a) {
        TrieNode root = new TrieNode();
        root.frequency = 0;
        for (int i = 0; i <a.size() ; i++) {
            insert(root, a.get(i));
        }
        ArrayList<String> res = new ArrayList<>();
        /*findPrefixUtil(root, res,new StringBuilder());
        return res;*/
        for (int i = 0; i <a.size() ; i++) {
            res.add(query(root,a.get(i)));
        }
        return res;
    }

    public static String query(TrieNode root, String str) {
        int len = str.length();
        StringBuilder sb = new StringBuilder();
        int i=0;
        while (i<len) {
            int c = str.charAt(i)-'a';
            sb.append(str.charAt(i));
            if (root.children[c].frequency == 1) {
                return sb.toString();
            }

            root = root.children[c];
            i++;
        }
        return null;
    }

    public static void findPrefixUtil(TrieNode root, ArrayList<String> res, StringBuilder temp) {
        if (root == null) {
            return;
        }

        if (root.frequency == 1) {
            res.add(temp.toString());
            temp.deleteCharAt(temp.length()-1);
            return;
        }

        for (int i = 0; i <26 ; i++) {
            if (root.children[i] != null) {
                char c = (char) (97+i);
                temp = temp.append(c);
                findPrefixUtil(root.children[i], res, temp);
            }
        }
        if (temp.length()>0) {
            temp.deleteCharAt(temp.length()-1);
        }
    }
}
