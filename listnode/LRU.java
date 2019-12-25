/**
 * LRU缓存机制
 */
public class LRU {

    /**
     * 双向链表
     */
    static class Node {
        private int key, val;
        public Node next, prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
