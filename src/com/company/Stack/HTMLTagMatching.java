package com.company.Stack;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by RANGA on 1/15/2015.
 */
public class HTMLTagMatching {

    public static final int CAPACITY = 1000;
    public static String stripEnds(String t) {
        if (t.length()<=2) return null;
        return t.substring(1,t.length()-1);
    }

    public static boolean isOpeningTag(String tag) {
        return (tag.length() == 0 || tag.charAt(0)!='/');
    }

    public static boolean areMatchingTags(String tag1, String tag2) {
        return tag1.equals(tag2);
    }

    public static String[] parseHTML(Scanner scanner) {
        String[] tags = new String[CAPACITY];
        int count =0;
        String token;
        while (scanner.hasNextLine()) {
            while ((token = scanner.findInLine("<[^>]*>"))!=null){
                tags[++count] = stripEnds(token);
            }
            scanner.nextLine();
        }
        return tags;
    }

    public static boolean isHTMLMatching(String[] tags) {
        Stack<String> stack = new NodeStack<String>();

        for (int i = 0; i <tags.length ; i++) {
            String tag = tags[i];
            if (isOpeningTag(tag)) {
                stack.push(tag);
            } else {
                if(stack.isEmpty()){
                    return false;
                }
                if (!areMatchingTags(stack.pop(),tag)) return false;
            }
        }
        if(stack.isEmpty()) return true;
        else return false;
    }

    public static void main(String[] args) throws IOException{
        if(isHTMLMatching(parseHTML(new Scanner(System.in)))) {
            System.out.println("The Input is a matched input");
        } else {
            System.out.println("The input is not a matched HTML");
        }
    }

}
