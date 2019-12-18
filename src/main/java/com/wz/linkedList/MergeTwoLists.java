package com.wz.linkedList;

/**
 * leetcode 21
 * 合并两个有序链表
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
                // maintain an unchanging reference to node ahead of the return node.
                ListNode prehead = new ListNode(-1);

                ListNode prev = prehead;
                while (l1 != null && l2 != null) {
                    if (l1.value <= l2.value) {
                        prev.next = l1;
                        l1 = l1.next;
                    } else {
                        prev.next = l2;
                        l2 = l2.next;
                    }
                    prev = prev.next;
                }

                // exactly one of l1 and l2 can be non-null at this point, so connect
                // the non-null list to the end of the merged list.
                prev.next = l1 == null ? l2 : l1;
                return prehead.next;
            }
}
