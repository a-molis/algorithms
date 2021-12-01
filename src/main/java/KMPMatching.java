public class KMPMatching {
  public static void main(String[] args) {
    char[] pattern = {'a', 'b', 'a', 'b', 'a'};
    char[] target = {'a', 'b', 'a', 'b', 'a', 'b', 'a', 'b'};
    int matches = kmpMatching(target, pattern);
    System.out.println(matches);
  }

  private static int[] computePi(char[] p) {
    int m = p.length;
    int[] pi = new int[m];
    pi[0] = 0;
    int k = -1;
    for (int q=1; q<m; q++) {
      while (k > 0 && p[k + 1] != p[q]) {
        k = pi[k];
      }
      if (p[k + 1] == p[q]) {
        k = k + 1;
        System.out.println(q);
      }

      pi[q] = k + 1;
    }
    return pi;
  }

  private static int kmpMatching(char[] T, char[] P) {
    int m = P.length;
    int n = T.length;
    int[] pi = computePi(P);
    int q = 0;
    int matches = 0;
    for (int i=0; i<n; i++) {
      while (q > 0 && P[q+ 1] != T[i]) {
        q = pi[q];
      }
      if (P[q + 1] == T[i]) {
        q = q + 1;
      }
      if (q == m) {
        System.out.println("Match found");
        matches++;
        q = pi[q];
      }
    }
    return matches;
  }


}
