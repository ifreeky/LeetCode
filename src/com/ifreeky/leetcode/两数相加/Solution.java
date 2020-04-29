package com.ifreeky.leetcode.两数相加;

/**
 * 题目：https://leetcode-cn.com/problems/add-two-numbers/
 * 思路：
 * <p>
 * 因为数据的两个链表都是逆序的，这就让题目的难度简单了许多，不需要特地处理进位和位数不相等的情况，直接按位加
 * 2 -> 4 -> 3
 * 5 -> 6 -> 4
 * 7 -> 0 -> 8
 * </p>
 *
 * @author ifreeky
 * @since 29 四月 2020
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode current = result;
        int n1;
        int n2;
        int sum;
        boolean carry = false;
        while (null != l1 || null != l2) {
            n1 = null != l1 ? l1.val : 0;
            n2 = null != l2 ? l2.val : 0;
            sum = (n1 + n2) + (carry ? 1 : 0);
            carry = false;
            if (sum > 9) {
                sum = sum - 10;
                carry = true;
            }
            current.next = new ListNode(sum);
            current = current.next;
            l1 = null == l1 ? null : l1.next;
            l2 = null == l2 ? null : l2.next;
        }
        if (carry){
            current.next = new ListNode(1);
        }
        return result.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(5);


        ListNode l2 = new ListNode(5);

        ListNode result = solution.addTwoNumbers(l1, l2);
        while (result!=null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
