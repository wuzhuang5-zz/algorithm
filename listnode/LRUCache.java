import java.util.HashMap;
import java.util.Hashtable;

/**
 * LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，
 * 它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间
 *
 *
 /**
 * LRUCache 对象会以如下语句构造和调用:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

public class LRUCache {

    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int capacity;

    private LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new DoubleList();
        this.map = new HashMap<>();
    }

    /**
     * get方法
     * @param key
     * @return
     */
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key).value;
        // 利用 put 方法把该数据提前
        put(key, val);
        return val;
    }

    public void put(int key, int value) {
        Node x = new Node(key, value);
        if (map.containsKey(key)) {
            cache.remove(map.get(key));
            cache.addFirst(x);
            map.put(key, x);
        } else {
            if (capacity == cache.size) {
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            cache.addFirst(x);
            map.put(key, x);
        }
    }
    class Node {
        private int key, value;
        private Node next;
        private Node prev;

        public Node(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }
    class DoubleList {
        private Node head, tail;
        private int size;

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        //在链表头部后添加x
        public void addFirst(Node x) {
            x.next = head.next;
            x.prev = head;
            head.next.prev = x;
            head.next = x;
            size++;
        }

        //删除链表中的x
        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        //删除链表中最后一个节点并返回
        public Node removeLast() {
            if (tail.prev == head) {
                return null;
            }
            Node last = tail.prev;
            remove(last);
            return last;
        }
    }
}
