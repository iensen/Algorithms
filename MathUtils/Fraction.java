package iensen.MathUtils;

/**
 * Created with IntelliJ IDEA.
 * User: iensen
 * Date: 2/23/13
 * Time: 11:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class Fraction implements Comparable<Fraction>
{
    public long getNum()
    {
        return num;
    }

    public void setNum(long num)
    {
        this.num = num;
    }

    public long getDenom()
    {
        return denom;
    }

    public void setDenom(long denom)
    {
        this.denom = denom;
    }

    long num;
    long denom;
    public Fraction(long num,long denom ) {
         long gcd=GCD.gcd(num,denom);
         num/=gcd;
         denom/=gcd;
        this.num=num;
        this.denom=denom;
    }

    public Fraction multiply(int k) {
      long newNum=k*num;
      long newDenom=denom;
      return new Fraction(newNum,newDenom);
    }

    public Fraction divide(int k) {
        long newNum=num;
        long newDenom=k*denom;
        return new Fraction(newNum,newDenom);
    }

    @Override
    public int compareTo(Fraction fraction)
    {
       long res= num*fraction.denom-denom*fraction.num;
       if(res>0)return 1;
       if(res==0)return 0;
       return -1;
    }
}
