/**
 * 二分法  时间复杂度 O(logn)
 */
public class BinarySearch {
    public static int binarySearch(int[] nums, int fromIndex, int toIndex, int k) {
        int low = fromIndex;
        int high = toIndex;
        while (low <= high) {
            int mid = (high - low)/2;
            if (nums[mid] < k) {
                low = mid + 1;
            } else if (nums[mid] > k) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
