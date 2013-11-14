package iensen.Graphs;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: iensen
 * Date: 12/14/12
 * Time: 12:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class PrimsAlgorithms
{
   /* returns a tree which is an MST of given graph G*/
   public static Graph getMstUsingHeap(Graph g)
   {

       Graph mst=new SparseGraph(g.getVertexCount(),g.getEdgeCount());
       int n = g.edgeCount;
       boolean[] used = new boolean[n];
       int[] priority = new int[n];
       int[] prev=new int[g.getVertexCount()];
       Arrays.fill(priority, Integer.MAX_VALUE);
       Arrays.fill(prev,-1);
       priority[0] = 0;
       PriorityQueue<VertexInQueue> q = new PriorityQueue<VertexInQueue>();
       q.add(new VertexInQueue(0,0));
       while (!q.isEmpty()) {
           VertexInQueue v = q.poll();
           int u = (int) v.vertexId;
           if (used[u])
               continue;
           if(prev[u]!=-1)mst.addEdge(prev[u],u,v.minWeight);
           used[u] = true;
           for (Edge e : g.getIncidentEdges(u)) {
               int nextV = e.to;
               if (!used[nextV] && priority[nextV] > e.weight) {
                   priority[nextV] = e.weight;
                   prev[nextV]=u;
                   q.add(new VertexInQueue(nextV,priority[nextV]));
               }
           }
       }
       return mst;
   }

    public static long getMstWeightUsingHeap(Graph g)
    {
        long answer=0;
        int n = g.edgeCount;
        boolean[] used = new boolean[g.getVertexCount()];
        int[] priority = new int[g.getVertexCount()];
        Arrays.fill(priority, Integer.MAX_VALUE);
        priority[0] = 0;
        PriorityQueue<VertexInQueue> q = new PriorityQueue<VertexInQueue>();
        q.add(new VertexInQueue(0,0));
        while (!q.isEmpty()) {
            VertexInQueue v = q.poll();
            int u = (int) v.vertexId;
            if (used[u])
                continue;
            answer+=v.minWeight;
            used[u] = true;
            for (Edge e : g.getIncidentEdges(u)) {
                int nextV = e.to;
                if (!used[nextV] && priority[nextV] > e.weight) {
                    priority[nextV] = e.weight;
                    q.add(new VertexInQueue(nextV,priority[nextV]));
                }
            }
        }
        return answer;
    }



 }

class VertexInQueue implements Comparable<VertexInQueue>
{
    int vertexId;
    int minWeight;
    public VertexInQueue(int vertexId, int minWeight)
    {
        this.vertexId=vertexId;
        this.minWeight=minWeight;
    }
    @Override
    public int compareTo(VertexInQueue myVertex)
    {
        if(this.minWeight==myVertex.minWeight)
        {
            return 0;
        }
        else if(this.minWeight <myVertex.minWeight)
        {
            return -1;
        }
        return 1;
    }
}
