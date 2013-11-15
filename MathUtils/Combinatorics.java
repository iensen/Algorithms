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

}
