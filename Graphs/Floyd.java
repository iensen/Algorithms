package iensen.Graphs;

/**
 * Created with IntelliJ IDEA.
 * User: iensen
 * Date: 1/22/13
 * Time: 10:34 AM
 * To change this template use File | Settings | File Templates.
 */
public class Floyd
{
    public static int[][] findDist(int [][] dist) {
        int [][]result=new int[dist.length][dist.length];
        for (int i = 0; i < dist.length; i++) {
            System.arraycopy(dist[i], 0, result[i], 0, dist[i].length);
        }

        for(int k=0;k<dist.length;k++) {
            for(int i=0;i<dist.length;i++) {
                for(int j=0;j<dist.length;j++) {
                    if(result[i][k]+result[k][j]<result[i][j])
                        result[i][j]=result[i][k]+result[k][j];
                }
            }
        }
        return result;
    }
}
