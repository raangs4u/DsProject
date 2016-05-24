package com.company.Algos.Greedy;

import java.util.Arrays;
import java.util.List;

/**
 * @author rmandada
 */
public class GasStation {

    public static void main(String[] args) {
        List<Integer> gas = Arrays.asList(new Integer[]{959, 329, 987, 951, 942, 410, 282, 376, 581, 507, 546, 299, 564, 114, 474, 163, 953, 481, 337, 395, 679, 21, 335, 846, 878, 961, 663, 413, 610, 937, 32, 831, 239, 899, 659, 718, 738, 7, 209});
        List<Integer> cost = Arrays.asList(new Integer[]{862, 783, 134, 441, 177, 416, 329, 43, 997, 920, 289, 117, 573, 672, 574, 797, 512, 887, 571, 657, 420, 686, 411, 817, 185, 326, 891, 122, 496, 905, 910, 810, 226, 462, 759, 637, 517, 237, 884});
        System.out.println(canCompleteCircuit(gas,cost));
    }

    public static int canCompleteCircuit(final List<Integer> gas, final List<Integer> cost) {
        int n = gas.size();
        for (int k = 0; k <n ;) {
            int i =k;
            int gasav = 0;
            int costt = 0;
            int count = n;
            do {
                gasav = gasav+ gas.get(i);
                costt = costt + cost.get(i);
                if (gasav-costt <0) {
                   // k=i;
                    if (i<k) {
                        return -1;
                    }
                    k=i;
                    break;
                }
                i= (i+1)%n;
                count--;
            } while (gasav-costt>=0 && count!=0 );
            /*if (k==i) {
                return -1;
            }*/
            if(count<=0) {
                return k;
            }
            //k=i+1;
            k++;
        }

        return -1;
    }
}
