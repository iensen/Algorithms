package iensen.MathUtils;

/**
 * Created with IntelliJ IDEA.
 * User: iensen
 * Date: 2/23/13
 * Time: 11:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class GCD
{
    public static long gcd (long a, long b) {
        if (b == 0)
            return a;
        else
            return gcd (b, a % b);
    }
}
