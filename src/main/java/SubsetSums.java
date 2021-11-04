import java.util.Arrays;

public class SubsetSums {

  public static void main(String[] args) {
    int[] items = {3, 7, 10, 13, 19};
    int weight = 25;
    int[][] OPT = new int[items.length + 1][weight + 1];
    for (int[] a: OPT) {
      Arrays.fill(a, Integer.MIN_VALUE);
    }
    int sums = subsetSums(items.length - 1, weight, items, OPT);
    System.out.println(sums);
  }

  private static int subsetSums(int i, int weight, int[] bag, int[][] OPT) {
    int wi = bag[i];
    if (weight <= 0) {
      return Integer.MIN_VALUE;
    } else if (i == 1) {
      if (weight >= wi) {
        return wi;
      } else {
        return 0;
      }
    } else if (i == 0) {
      return 0;
    }

    if (OPT[i][weight] == Integer.MIN_VALUE) {
      OPT[i][weight] = Math.max(subsetSums(i - 1, weight - wi, bag, OPT) + wi,
                                subsetSums(i - 1, weight, bag, OPT));
    }
    return OPT[i][weight];
  }
}
