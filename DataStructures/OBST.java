package iensen.DataStructures;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: iensen
 * Date: 1/3/13
 * Time: 7:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class OBST
{
     List<Double> frequencies;
     double [][]cost;
     public OBST(List<Double>frequencies) {
         this.frequencies=frequencies;
         cost=new double[frequencies.size()][frequencies.size()];
         for(int i=0;i<frequencies.size();i++) {
             Arrays.fill(cost[i],-1);
         }
     }
    int root;

    public double build(int leftId,int rightId) {
        double maxCost=3000000;
        if(leftId>rightId)return 0;
        if(leftId==rightId)
            return frequencies.get(leftId);
        if(cost[leftId][rightId]!=-1.0)
            return cost[leftId][rightId];
        double ss=.0;
        for(double s:frequencies.subList(leftId,rightId+1))
                   ss+=s;

        for(int i=leftId;i<=rightId;i++) {

            if(ss+build(leftId,i-1)+build(i+1,rightId)<maxCost ) {

                 maxCost=
                        ss+build(leftId,i-1)+build(i+1,rightId);
            }
        }
        return cost[leftId][rightId]=maxCost;
    }
}
