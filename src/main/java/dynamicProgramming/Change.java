package dynamicProgramming;

import java.util.Arrays;

public class Change {
  public static void main(String[] args) {
    changeCoin(new int[]{1,5,10},61);
  }

  public static void changeCoin(final int[] coinKinds, final int amount) {
    final int coinKindsLen = coinKinds.length;

    final int[] dp = new int[amount + 1];
    final int[] lastBestCoinKindIndexes = new int[amount + 1];

    Arrays.fill(dp, Integer.MAX_VALUE);

    dp[0] = 0;

    for (int i = coinKinds[0]; i <= amount; ++i) {
      int min = Integer.MAX_VALUE - 1;

      for (int c = 0; c < coinKindsLen; ++c) {
        final int coinKind = coinKinds[c];

        if (i < coinKind) {
          break;
        }

        final int remainAmount = i - coinKind;

        if (min > dp[remainAmount]) {
          min = dp[remainAmount];

          lastBestCoinKindIndexes[i] = c;
        }
      }

      dp[i] = min + 1;
    }

    for (int a = 0; a <= amount; ++a) {
      final int minCount = dp[a];

      if (minCount == Integer.MAX_VALUE) {
        System.out.printf("For amount {}, there is no solution.%n", a);

        continue;
      }

      final int[] coinKindsCounts = new int[coinKindsLen];

      int n = a;

      while (n > 0) {
        final int lastBestCoinKindIndex = lastBestCoinKindIndexes[n];
        final int lastBestCoinKind = coinKinds[lastBestCoinKindIndex];

        ++coinKindsCounts[lastBestCoinKindIndex];
        n -= lastBestCoinKind;
      }

      System.out.printf(
          "For amount %d, the minimum number of coins is %d. %s%n",
          a, minCount, Arrays.toString(coinKindsCounts));
    }
  }
}
