package com.company.Tree;

/**
 * @author rmandada
 */
public class SumRootToLeafNumbers {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n3.right = n4;
        n3.left = n2;
        n2.left = n1;
        n2.right = n6;
        n4.left = n7;
        n4.right = n5;
        System.out.println(sumNumbers(n3));
    }
    public static int sumNumbers(TreeNode a) {
        Answer answer = new Answer();
        sumNumbersUtil(a, answer);
        return answer.finalAns;
    }

    static class Answer{
        int finalAns = 0;
        int temp = 0;
    }

    public int sumNumbersUtil1(TreeNode a, int val) {
        if (a == null) {
            return 0;
        }

        val = (10 * val) %1003 + a.val;
        if (a.left == null && a.right == null) {
            return ((val%1003)+1003)%1003;
        }

        return ((((sumNumbersUtil1(a.left, val)%1003)+(sumNumbersUtil1(a.right, val)%1003))%1003)+1003)%1003;
    }
    public static void sumNumbersUtil(TreeNode a, Answer answer) {
        if (a==null) {
            return;
        }
        answer.temp *= 10;
        answer.temp += a.val;
        if (a.left == null && a.right == null) {
            answer.finalAns += answer.temp;
            answer.temp /= 10;
            return;
        }
        sumNumbersUtil(a.left, answer);
        sumNumbersUtil(a.right, answer);
        answer.temp /= 10;
    }
}
