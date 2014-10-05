package iensen.Geometry;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


/**
 * Created with IntelliJ IDEA.
 * User: iensen
 * Date: 11/30/13
 * Time: 8:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConvexHull {


    public static Point2D[] getConvexHull(Point2D[] points) {
       if(points.length==1) {
           return Arrays.copyOf(points,points.length);
       }
       // sort all the points by x,y
        Arrays.sort(points, new PointComparator());
        // take the first and the last point
        Point2D pointF = points[0];
        Point2D pointL = points[points.length-1];
        // create stacks for  the upper part and the lower parts
        ArrayList<Point2D> upper = new  ArrayList<Point2D>();
        ArrayList<Point2D> lower = new  ArrayList<Point2D>();
        //add the first point to both upper and lower parts
        upper.add(pointF);
        lower.add(pointF);
        // start iterating over other points
        for(int i = 1;i<points.length;++i) {
            if(i == points.length-1 || Geometry.cw(pointF,points[i],pointL)) {
                // consider the point as a new candidate
               while (upper.size()>=2 && !Geometry.cw(upper.get(upper.size()-2),upper.get(upper.size()-1),points[i])) {
                   upper.remove(upper.size()-1);

               }
                upper.add(points[i]);
            }
            if(i == points.length-1 || Geometry.ccw(pointF,points[i],pointL)) {
                while(lower.size()>=2 && !Geometry.ccw(lower.get(lower.size()-2),lower.get(lower.size()-1),points[i])) {
                    lower.remove(lower.size()-1);
                }
                lower.add(points[i]);

            }
        }

        Point2D[]  result = new Point2D[upper.size()+lower.size()-2];


        for (int i=0; i<upper.size(); ++i)
            result[i] = upper.get(i);
        int idx = upper.size();
        for (int i=lower.size()-2; i>0; --i)
            result[idx++]=lower.get(i);
        return result;

    }


    public static double getConvexHullLength(Point2D[] points) {
        Point2D[] convexHull = ConvexHull.getConvexHull(points);
        double dist = 0;
        for(int i=1;i<convexHull.length;i++) {
            dist += Math.hypot(convexHull[i].getX()-convexHull[i-1].getX(), convexHull[i].getY()-convexHull[i-1].getY());
        }
        dist += Math.hypot(convexHull[convexHull.length-1].getX()-convexHull[0].getX(), convexHull[convexHull.length-1].getY()-convexHull[0].getY());
        return dist;
    }
 }


class PointComparator implements Comparator<Point2D> {

    @Override
    public int compare(Point2D o1, Point2D o2) {
        final double eps = 1e-8;
        if(Math.abs(o1.getX()- o2.getX())>=eps) {
            return o1.getX()-o2.getX()>0?1:-1;
        }
        return o1.getY()-o2.getY()>0?1:-1;

    }
}
