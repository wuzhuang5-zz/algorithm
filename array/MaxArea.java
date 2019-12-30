/**
 * leetcode 11
 * 乘最多水的容器
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while(i < j){
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]):
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }
}
