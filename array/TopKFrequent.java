import java.util.*;

/**
 * leetcode 347
 * 前K个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 */
public class TopKFrequent {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        //统计每个数出现的频率   k->数  v->出现次数
        for (int n : nums) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }
        //优先队列（堆）
        //keep k top frequent elements in the heap
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(countMap::get));
        for (int n : countMap.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        List<Integer> topK = new LinkedList<>();
        while (!heap.isEmpty()) {
            topK.add(heap.poll());
        }
        Collections.reverse(topK);
        return topK;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 3, 1, 2, 2, 1, 1,1};
        List<Integer> result = topKFrequent(nums,2);
        System.out.println(result);
    }
}
