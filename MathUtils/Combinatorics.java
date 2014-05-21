package iensen.MathUtils;

/**
 * Created with IntelliJ IDEA.
 * User: iensen
 * Date: 1/13/13
 * Time: 7:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class Combinatorics
{
    public static int[][] getBinomCoefs(int maxn) {
        int C[][]=new int[maxn+1][maxn+1];
        for (int n=0; n<=maxn; ++n) {
            C[n][0] = C[n][n] = 1;
            for (int k=1; k<n; ++k)
                C[n][k] = C[n-1][k-1] + C[n-1][k];
        }
        return C;
    }

    public static long[][] getBinomCoefsModulo(int maxn,int modulo) {
        long C[][]=new long[maxn+1][maxn+1];
        for (int n=0; n<=maxn; ++n) {
            C[n][0] = C[n][n] = 1%modulo;
            for (int k=1; k<n; ++k)
                C[n][k] = (C[n-1][k-1] + C[n-1][k])%modulo;
        }
        return C;
    }

    public static boolean next_permutation(int[] p) {
        for (int a = p.length - 2; a >= 0; --a)
            if (p[a] < p[a + 1])
                for (int b = p.length - 1;; --b)
                    if (p[b] > p[a]) {
                        int t = p[a];
                        p[a] = p[b];
                        p[b] = t;
                        for (++a, b = p.length - 1; a < b; ++a, --b) {
                            t = p[a];
                            p[a] = p[b];
                            p[b] = t;
                        }
                        return true;
                    }
        return false;
    }

}
