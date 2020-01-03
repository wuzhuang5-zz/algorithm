import java.util.Arrays;

/**
 * leetcode 135
 * 分发糖果     贪心算法
 *
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 * 示例1：
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 */
public class Candy {

    //暴力枚举  时间复杂度O(n*n)
    public static int candy(int[] ratings) {
            int[] candies = new int[ratings.length];
            Arrays.fill(candies, 1);
            boolean flag = true;
            int sum = 0;
            while (flag) {
                flag = false;
                for (int i = 0; i < ratings.length; i++) {
                    if (i != ratings.length - 1 && ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                        candies[i] = candies[i + 1] + 1;
                        flag = true;
                    }
                    if (i > 0 && ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
                        candies[i] = candies[i - 1] + 1;
                        flag = true;
                    }
                }
            }
            for (int candy : candies) {
                sum += candy;
            }
            return sum;
    }
    // 用两个数组
    public static int candy2(int[] ratings) {

        return 0;
    }

    public static void main(String[] args) {
        int[] ratings = new int[]{1, 0, 2};
        int result = candy(ratings);
        System.out.println(result);
    }
}
