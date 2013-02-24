package iensen.Misc;

/**
 * Created with IntelliJ IDEA.
 * User: iensen
 * Date: 1/26/13
 * Time: 8:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class BitUtils
{
    public static void setBit(long number, int bitIdx,boolean bit) {
        if(bit) {
            number|= (1l << bitIdx);
        }
        else {
            number&=~(1l<<bitIdx);
        }
    }

    public static boolean getBit(long number,int bitIdx) {
        return (number & (1l << bitIdx))>0;
    }

    public static int countBits(long number) {
        int cur=1;
        int count=0;
        for(int i=0;i<63;i++) {
            if((number&cur)>0)++count;
            cur*=2;
        }
        return count;
    }
}
