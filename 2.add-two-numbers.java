/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 *
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (30.78%)
 * Total Accepted:    803K
 * Total Submissions: 2.6M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example:
 * 
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * 
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    // 方案二
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = l1.val + l2.val;
        ListNode head = new ListNode(sum % 10);
        ListNode l3N = head;
        ListNode n1 = l1.next;
        ListNode n2 = l2.next;
        // 相比方案一少做进位的循环判断
        while (n1 != null || n2 != null) {
            int a = n1 == null ? 0 : n1.val;
            int b = n2 == null ? 0 : n2.val;
            sum = a + b + sum / 10;
            int val = sum % 10;
            //去掉Node的引用，节省空间（多次提交，内存消耗不一样，因此感觉LeetCode内存计算不准确）
            l3N.next = new ListNode(val);
            l3N = l3N.next;
            if (n1 != null)
                n1 = n1.next;
            if (n2 != null)
                n2 = n2.next;
        }

        if (sum / 10 > 0)
            l3N.next = new ListNode(sum / 10);

        return head;
    }
}





// class Solution {
//     //首先想到的方案就是一位一位相加
//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//         int sum = l1.val + l2.val;
//         //保留队列头
//         ListNode head = new ListNode(sum % 10);
//         ListNode l3N = head;
//         ListNode n1 = l1.next;
//         ListNode n2 = l2.next;
//         //有任何一个列表还有元素或者有进位都需要再往后进行加操作
//         while (n1 != null || n2 != null || sum / 10 > 0) {
//             //队列没有元素的话，设为0
//             int a = n1 == null ? 0 : n1.val;
//             int b = n2 == null ? 0 : n2.val;
//             //sum/10等于十位数，也就是进位的值
//             sum = a + b + sum / 10;
//             ListNode l3Next = new ListNode(sum % 10);
//             l3N.next = l3Next;
//             //为下一个循环做准备
//             l3N = l3Next;
//             if (n1 != null)
//                 n1 = n1.next;
//             if (n2 != null)
//                 n2 = n2.next;
//         }

//         return head;
//     }
// }
