package dynamicProgramming;

/** 記憶法 */
public class Memoization {
  static int fibonacciInner(final int[] dp, final int n) {
    switch (n) {
      case 0:
        return 0;
      case 1:
        return 1;
      default:
        if (dp[n] == 0) {
          dp[n] = fibonacciInner(dp, n - 1) + fibonacciInner(dp, n - 2);
        }

        return dp[n];
    }
  }

  public static int fibonacci(final int n) {
    final int[] dp = new int[n + 1];

    return fibonacciInner(dp, n);
  }
}
