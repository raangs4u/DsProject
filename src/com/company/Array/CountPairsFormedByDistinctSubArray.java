package com.company.Array;

/**
 * @author rmandada
 */
public class CountPairsFormedByDistinctSubArray {
    public static void main(String[] args) {
        int arr[] = {1, 4, 2, 4, 3, 2};
        System.out.println(countPairs(arr));
    }

    public static int countPairs(int[] arr) {
        int n = arr.length;
        int left=0, right = 0;

        int[] visited = new int[n];

        int count = 0;

        while (right < n) {
            while (right<n && visited[arr[right]]==0) {
                count += (right-left);
                visited[arr[right]] = 1;
                right++;
            }

            while (left < right && (right != n && visited[arr[right]]==1)) {
                visited[arr[left]] = 0;
                left++;
            }
        }

        return count;
    }
}
