/**
 * 最短编辑距离
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 *
 */
public class MinDistance {
    public static int minDistance(String word1, String word2) {
            int m = word1.length(), n = word2.length();
            int[][] dp = new int[m + 1][n + 1];
            // base case
            for (int i = 1; i <= m; i++)
                dp[i][0] = i;
            for (int j = 1; j <= n; j++)
                dp[0][j] = j;
            // 自底向上求解
            for (int i = 1; i <= m; i++)
                for (int j = 1; j <= n; j++)
                    if (word1.charAt(i-1) == word2.charAt(j-1))
                        dp[i][j] = dp[i - 1][j - 1];
                    else
                        dp[i][j] = min(
                                dp[i - 1][j] + 1,
                                dp[i][j - 1] + 1,
                                dp[i-1][j-1] + 1
                        );
            // 储存着整个 s1 和 s2 的最小编辑距离
            return dp[m][n];
        }

    static int min(int a, int b, int c) {
            return Math.min(a, Math.min(b, c));
        }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        int mindDintance = minDistance(word1, word2);
        System.out.println(mindDintance);
    }
}
