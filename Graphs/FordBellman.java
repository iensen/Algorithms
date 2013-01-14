package iensen.Graphs;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: iensen
 * Date: 1/13/13
 * Time: 7:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class FordBellman implements SingleSourceShortestPathAlgo
{
   public  long [] run(Graph g,int source)  {
       Edge []edges=new Edge[g.getEdgeCount()];
       int edgesCount=0;
       for(int i=0;i<g.getVertexCount();i++) {
         for(Edge e:g.getIncidentEdges(i)) {
             edges[edgesCount++]=e;
         }
       }
       long[]answer=new long[g.getVertexCount()];
       Arrays.fill(answer,Long.MAX_VALUE);
       answer[source]=0;
       for(int i=0;i<g.getVertexCount();i++) {
           boolean improved=false;
           for(int j=0;j<edgesCount;j++) {
               if((answer[edges[j].from]!=Long.MAX_VALUE)
                   && answer[edges[j].to]>answer[edges[j].from]+edges[j].weight) {
                   improved=true;
                   answer[edges[j].to]=answer[edges[j].from]+edges[j].weight;
               }
           }
           if(improved && i==g.getVertexCount()-1) {
               return null;
           }
       }
       return answer;
   }
}
