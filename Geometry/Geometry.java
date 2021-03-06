package iensen.Geometry;

import java.awt.geom.Point2D;

/**
 * Created with IntelliJ IDEA.
 * User: iensen
 * Date: 3/10/13
 * Time: 10:56 AM
 * To change this template use File | Settings | File Templates.
 */
public class Geometry
{
    public static double getAlpha(Point2D p) {

      double alpha=Math.atan2(p.getY(),p.getX());
      if(alpha<0) alpha= Math.PI*2-Math.abs(alpha);
      return alpha;
    }

    public static boolean cw (Point2D a, Point2D b, Point2D c) {
        return a.getX()*(b.getY()-c.getY())+b.getX()*(c.getY()-a.getY())+c.getX()*(a.getY()-b.getY()) < 0;
    }
    public static boolean ccw (Point2D a, Point2D b, Point2D c) {
        return a.getX()*(b.getY()-c.getY())+b.getX()*(c.getY()-a.getY())+c.getX()*(a.getY()-b.getY()) > 0;
    }
}
