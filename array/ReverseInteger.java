import sun.jvmstat.perfdata.monitor.PerfStringVariableMonitor;

/**
 * leetcode 7
 * 整数反转
 * 例子：
 * 123  321
 */
public class ReverseInteger {
    public static int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            ans = ans * 10 + pop;
            x = x / 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        int x = 123;
        System.out.println(reverse(x));
    }
}
