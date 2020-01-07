import java.util.PriorityQueue;

/**
 * leetcode 23
 * 合并K个有序链表
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 *
 * 输出: 1->1->2->3->4->4->5->6
 */
public class MergeKLists {
    /**
     * 方法1：优先队列
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length < 1) {
            return null;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        //把每个链表都放入一个优先队列里
        for (ListNode listNode : lists) {
            while (listNode != null) {
                queue.add(listNode.value);
                listNode = listNode.next;
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        while (!queue.isEmpty()) {
            ListNode tmp = new ListNode(queue.poll());
            result.next = tmp;
            result = result.next;
        }
        return dummy.next;
    }
}
