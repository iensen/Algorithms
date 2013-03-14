package iensen.Geometry;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * Created with IntelliJ IDEA.
 * User: iensen
 * Date: 3/10/13
 * Time: 11:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class LineUtils
{

    // return line of the form AX+BY=C
    public static double getA(Line2D l) {
        return l.getY2()-l.getY1();
    }

    public static double getB(Line2D l) {
        return l.getX1()-l.getX2();
    }

    public static double  getC(Line2D l) {
        return getA(l)*l.getX1()+getB(l)*l.getY1();
    }

    public static Point2D getIntersection(Line2D l1,Line2D l2) {
        double det = getA(l1)*getB(l2) - getA(l2)*getB(l1);
        if(det == 0){
            return null;
        }else{
            double x = (getB(l2)*getC(l1) - getB(l1)*getC(l2))/det;
            double y = (getA(l1)*getC(l2) - getA(l2)*getC(l1))/det;
            return new Point2D.Double(x,y);
        }

    }

    public static double getLength(Line2D l) {
        return Math.sqrt( (l.getX1()-l.getX2())*(l.getX1()-l.getX2())+(l.getY1()-l.getY2())*(l.getY1()-l.getY2()) );
    }
}
