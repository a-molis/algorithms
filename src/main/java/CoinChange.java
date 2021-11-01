public class CoinChange {
  public static void main(String[] args) {
    int[] coins = {1,2,5};
    int amount = 11;
    System.out.println(coinChange(coins, amount));
  }

  public static int coinChange(int[] coins, int amount) {
    if (amount < 1) return 0;
    return coinChange(coins, amount, new int[amount]);
  }

  private static int coinChange(int[] coins, int rem, int[] count) {
    if (rem < 0) return -1;
    if (rem == 0) return 0;
    if (count[rem - 1] != 0) return count[rem - 1];

    int min = Integer.MAX_VALUE;
    for (int coin : coins) {
      int res = coinChange(coins, rem - coin, count);
      if (res >= 0 && res < min) min = 1 + res;
    }
    if (min == Integer.MAX_VALUE) {
      min = -1;
    }
    count[rem - 1] = min;
    return count[rem - 1];
  }
}
