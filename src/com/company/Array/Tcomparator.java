package com.company.Array;

import java.util.Comparator;

/**
 * Created by RANGA on 2/4/2016.
 */
public class Tcomparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        String n1 = String.valueOf(o1);
        String n2 = String.valueOf(o2);
        long xy = Long.parseLong(n1+n2);
        int yx = Integer.parseInt(n2+n1);
        if(xy >= yx) {
            return 1;
        } else {
            return -1;
        }
        /*return 0;
        int l1 = n1.length();
        int l2 = n2.length();
        int l = Math.max(l1,l2);
        for(int i=0;i<l;i++){
            char x = n1.charAt(i);
            char y = n2.charAt(i);

            if(x!=y) {
                return Character.getNumericValue(x)>Character.getNumericValue(y)?1:-1;
            } else {
                if(i==l1-1){
                    if(l1==l2){
                        return 0;
                    }
                    return Character.getNumericValue(x)>Character.getNumericValue(n2.charAt(i + 1))? 1:-1;
                }else if(i==l2-1){
                    return Character.getNumericValue(y)>Character.getNumericValue(n1.charAt(i + 1))? -1:1;
                }
            }
        }
        return 0;*/
    }
}
