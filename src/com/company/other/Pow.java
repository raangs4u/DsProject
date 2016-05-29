package com.company.other;

/**
 * Created by RANGA on 2/23/2016.
 */
public class Pow {
    public static void main(String[] args) {
        System.out.println(isPower(536870912));
    }
    public static boolean isPower(int a) {
        if(a<=1){
            return true;
        }
        for(int i=2; i< 32; i++){
            /*double x = Math.log(a)/Math.log(i);
            if(x == Math.floor(x)){
                return true;

            }*/

            int j = 2;
            int k = a;
            while(j<=k){
                long mid = (j+k)/2;
                int p = (int)Math.pow(mid,i);
                if(p==a){
                    return true;
                } else if(p<a){
                    j = (int)mid+1;
                } else{
                    k = (int)mid-1;
                }

            }


           /* int p = i;
            while(p<=a){
                p *= i;
                if(p==a){
                    return true;
                }
            }*/
        }
        return false;
    }
}

