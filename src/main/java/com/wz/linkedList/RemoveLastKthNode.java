package com.wz.linkedList;

/**
 * leetcode 19
 * 删除链表倒数第k个结点
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class RemoveLastKthNode {

        public ListNode removeNthFromEnd(ListNode head, int k) {
                ListNode dummy = new ListNode(0);
                dummy.next = head;
                int length  = 0;
                ListNode first = head;
                while (first != null) {
                    length++;
                    first = first.next;
                }
                length -= k;
                first = dummy;
                while (length > 0) {
                    length--;
                    first = first.next;
                }
                first.next = first.next.next;
                return dummy.next;
            }

        public ListNode removeNthFromEnd2(ListNode head, int k) {
                ListNode dummy = new ListNode(0);
                dummy.next = head;
                ListNode first = dummy;
                ListNode second = dummy;
                // Advances first pointer so that the gap between first and second is n nodes apart
                for (int i = 1; i <= k + 1; i++) {
                    first = first.next;
                }
                // Move first to the end, maintaining the gap
                while (first != null) {
                    first = first.next;
                    second = second.next;
                }
                second.next = second.next.next;
                return dummy.next;
            }
}
