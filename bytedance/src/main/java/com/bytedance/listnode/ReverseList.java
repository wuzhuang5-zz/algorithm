package com.bytedance.listnode;

/**
 * leetcode 206
 * 反转链表
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;
    }
}
