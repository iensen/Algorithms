package iensen.Geometry;

import java.awt.geom.Point2D;

/**
 * Created with IntelliJ IDEA.
 * User: iensen
 * Date: 3/10/13
 * Time: 11:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class PointUtils
{
    public static double getAlpha(Point2D p) {
        double alpha=Math.atan2(p.getY(),p.getX());
        if(alpha<0) alpha= Math.PI*2-Math.abs(alpha);
        return alpha;
    }
}
