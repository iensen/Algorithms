package iensen.Graphs;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: iensen
 * Date: 2/2/13
 * Time: 1:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class Kuhn
{
    Graph g;
    int firstPartCount;
    int secondPartCount;
    public Kuhn(Graph g,int firstPartCount) {
       this.firstPartCount=firstPartCount;
       this.secondPartCount=g.getVertexCount()-firstPartCount;
       this.g=g;
    }
    boolean try_kuhn (int v,boolean []used,int[]matching) {
        if (used[v])  return false;
        used[v] = true;
        for (Edge e:g.getIncidentEdges(v)) {

            if (matching[e.to-firstPartCount] == -1 || try_kuhn (matching[e.to-firstPartCount],used,matching)) {
                matching[e.to-firstPartCount] = v;
                return true;
            }
        }
        return false;
    }

    public int[] run() {

        //matching[i] is equal to  pairs of right vertex
        int[] matching=new int[secondPartCount];
        Arrays.fill(matching,-1);
        //heuristics
        boolean []usedInHeuristics=new boolean[firstPartCount];
        for (int i=0; i<firstPartCount; ++i)
            for(Edge e:g.getIncidentEdges(i)) {
                if (matching[e.to-firstPartCount] == -1) {
                    matching[e.to-firstPartCount] = i;
                    usedInHeuristics[i] = true;
                    break;
                }
            }

        for (int i=0; i<firstPartCount; ++i) {
            if (usedInHeuristics[i])  continue;
            boolean []used=new boolean[firstPartCount];
            try_kuhn (i,used,matching);
        }
        return matching;
    }
}
