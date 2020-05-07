import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * leetcode 215
 * 数组中第K个最大的元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，
 * 你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 示例:
 * 输入:[3,2,1,5,6,4]  k=2
 * 输出: 5
 */
class FindKthLargest {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        // keep k largest elements in the heap
        for (int n: nums) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 5, 9, 11, 10, 8};
        int result = findKthLargest(nums, 3);
        System.out.println(result);
    }
}
