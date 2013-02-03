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
    public static void setBit(int number, int bitIdx,boolean bit) {
        if(bit) {
            number|= (1 << bitIdx);
        }
        else {
            number&=~(1<<bitIdx);
        }
    }

    public static boolean getBit(int number,int bitIdx) {
        return (number & (1 << bitIdx))>0;
    }
}
