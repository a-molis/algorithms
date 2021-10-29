import java.util.Arrays;

public class SubsetSums {
    static int[] weights = new int[] {2, 2, 2, 5};
    static int W = 6;

    public static void main(String[] args) {
        int[][] OPT = new int[weights.length][W];
        for (int[] row: OPT) {
            Arrays.fill(row, 0);
        }
        System.out.println(knapsackOPT(weights.length - 1, W, OPT));
    }

    private static int knapsackOPT(int i, int W, int[][] OPT) {
        if (i < 0) {
            return 0;
        }
        if (weights[i] > W) {
            return OPT[i-1][W - 1];
        } else {
            if (OPT[i][W - 1] == 0) {
                OPT[i][W - 1] = Math.max(knapsackOPT(i-1, W, OPT),
                        knapsackOPT(i-1, W - weights[i], OPT) + weights[i]);
            }
        }
        return OPT[i][W - 1];
    }

    private static int knapsack(int i, int W) {
        if (i < 0) {
            return 0;
        }
        if (weights[i] > W) {
            return knapsack(i-1, W);
        } else {
            return Math.max(knapsack(i-1, W),
                    knapsack(i-1, W - weights[i]) + weights[i]);
        }
    }
}
