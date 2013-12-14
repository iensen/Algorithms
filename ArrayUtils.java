package iensen;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: iensen
 * Date: 2/24/13
 * Time: 10:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class ArrayUtils
{
        public static void shuffle(Object[] a) {
            int n = a.length;
            Random random = new Random();

            for (int i = 0; i < n; i++) {
                int change = i + random.nextInt(n - i);
                swap(a, i, change);
            }
        }

        private static void swap(Object[] a, int i, int changeIdx) {
            Object temp = a[i];
            a[i] = a[changeIdx];
            a[changeIdx] = temp;
        }
     public static void reverse(int []a)
     {
      for(int i = 0; i < a.length; i++)
      {
        int temp = a[i];
        a[i] = a[a.length - i - 1];
        a[a.length - i - 1] = temp;
      }
     }
}
