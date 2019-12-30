/**
 * 快排  时间复杂度 O(nlogn)
 */
public class QuickSort {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length-1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int[] p = partion(arr, l, r);
            quickSort(arr, l, p[0]);
            quickSort(arr, p[0] + 1, r);
        }
    }

    public static int[] partion(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        swap(arr, more, r);
        return new int[]{less, more};
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 8, 4, 3, 5, 7, 6};
        quickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
