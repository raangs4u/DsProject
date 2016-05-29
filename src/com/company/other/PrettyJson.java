package com.company.other;

import java.util.ArrayList;

/**
 * Created by RANGA on 3/12/2016.
 */
public class PrettyJson {
    public static void main(String[] args) {
        System.out.println(prettyJSON("{\"attributes\":[{\"nm\":\"ACCOUNT\",\"lv\":[{\"v\":{\"Id\":null,\"State\":null},\"vt\":\"java.util.Map\",\"cn\":1}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":13585},{\"nm\":\"PROFILE\",\"lv\":[{\"v\":{\"Party\":null,\"Ads\":null},\"vt\":\"java.util.Map\",\"cn\":2}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":41962}]}"));
    }

    public static ArrayList<String> prettyJSON(String a) {
        int currentIndent = 0;
        StringBuilder currentLine = new StringBuilder();
        ArrayList<String> res = new ArrayList<String>();
        for (int i = 0; i <a.length() ; i++) {
            if (a.charAt(i) == '[' || a.charAt(i) == '{') {
                if (currentLine.length() > 0) {
                    res.add(currentLine.toString());
                    currentLine = new StringBuilder();
                    for (int j = 0; j <currentIndent ; j++) {
                        currentLine.append('\t');
                    }
                    currentIndent++;
                    currentLine.append(a.charAt(i));
                    res.add(currentLine.toString());
                    currentLine = new StringBuilder();
                } else {
                    for (int j = 0; j < currentIndent; j++) {
                        currentLine.append('\t');
                    }
                    currentLine.append(a.charAt(i));
                    res.add(currentLine.toString());
                    currentIndent++;
                    currentLine = new StringBuilder();

                }
            } else if (a.charAt(i) == ','){
                currentLine.append(a.charAt(i));
                res.add(currentLine.toString());
                currentLine = new StringBuilder();
            } else if (a.charAt(i) == ']' || a.charAt(i) == '}') {
                if (currentLine.length() > 1) {
                    res.add(currentLine.toString());
                    currentIndent--;
                    currentLine = new StringBuilder();
                    for (int j = 0; j < currentIndent; j++) {
                        currentLine.append('\t');
                    }
                    currentLine.append(a.charAt(i));
                    if (i<a.length()-1 && a.charAt(i+1) == ',') {
                        currentLine.append(',');
                        i++;
                    }
                    res.add(currentLine.toString());
                    currentLine = new StringBuilder();
                } else {
                    currentIndent--;
                    for (int j = 0; j < currentIndent; j++) {
                        currentLine.append('\t');
                    }
                    currentLine.append(a.charAt(i));
                    if (i<a.length()-1 && a.charAt(i+1) == ',') {
                        currentLine.append(',');
                        i++;
                    }
                    res.add(currentLine.toString());
                    currentLine = new StringBuilder();
                }
            } else {
                if (a.charAt(i) != ' ' ) {
                    if (currentLine.length() == 0) {
                        for (int j = 0; j < currentIndent; j++) {
                            currentLine.append('\t');
                        }
                    }
                    currentLine.append(a.charAt(i));
                }
            }
        }

        return res;
    }

}
