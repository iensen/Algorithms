package iensen.Graphs;

import iensen.Misc.Pair;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 * User: iensen
 * Date: 1/13/13
 * Time: 7:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class Djikstra
{
    long []vertexWeights;
    public Djikstra(long []vertexWeights) {
       this.vertexWeights=vertexWeights;
    }


    public long[] run(Graph g, int source,int to)
    {
        long distance[]=new long[g.getVertexCount()];
        Arrays.fill(distance,Long.MAX_VALUE);
        // start vertex
        PriorityQueue<Pair<Long,Integer>> Q=new PriorityQueue<Pair<Long, Integer>>();
        distance[source] = 0;
        Q.add(new Pair(0L,source));

        while(!Q.isEmpty()) {
            // fetch the closest to start element
            // from “queue” organized via set
            Pair<Long,Integer> top = Q.poll();
            int v = top.second;
            long d=top.first;
            if(v==to) break;

              if(distance[v]!=d) continue;;
              for (Edge e:g.getIncidentEdges(v)) {
                int v2 = e.to;
                long weight = e.weight;
                if(vertexWeights!=null) {
                    weight+=vertexWeights[v]-vertexWeights[v2];
                }
                if(distance[v2] > distance[v] + weight) {
                    distance[v2] = distance[v] + weight;
                    Q.add(new Pair(distance[v2], v2));
                }
            }
        }
        return distance;
    }
}
