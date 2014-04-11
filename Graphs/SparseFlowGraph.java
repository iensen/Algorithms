package iensen.Graphs;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: iensen
 * Date: 8/26/13
 * Time: 1:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class SparseFlowGraph extends SparseGraph
{

    public int Capacity[];
    public int Flow[];

    public SparseFlowGraph(int vertexCount,int edgeCapacity)
    {
        super(vertexCount,2*edgeCapacity);
        Capacity=new int[2*edgeCapacity];
        Flow=new int[2*edgeCapacity];
    }


    public void addFlowEdge(int from, int to, int capacity) {
        addEdge(from,to);
        addEdge(to,from);
        Capacity[edgeCount-1]=capacity;
        Capacity[edgeCount-2]=capacity;
    }

    public void addWeightedFlowEdge(int from, int to, int weight, int capacity) {
        super.addEdge(from, to, weight);
        super.addEdge(to, from, weight);
        Capacity[edgeCount-1]=capacity;
        Capacity[edgeCount-2]=capacity;
    }

    public int findMaxFlow(int source, int target) {
        Queue<Integer> vertexQueue=new LinkedList<Integer>();
        vertexQueue.add(source);
        Arrays.fill(Flow,0);
        int pathEdgeIndex[]=new int[vertexCount];
        boolean pathFound=true;
        while(pathFound) {
             pathFound=false;
             Arrays.fill(pathEdgeIndex,-1) ;
             pathEdgeIndex[source]=-2;
             vertexQueue.clear();
             vertexQueue.add(source);
             while(!vertexQueue.isEmpty()) {
                 int vertexId=vertexQueue.poll();

                 int incidentEdgeId=Head[vertexId];
                 while(incidentEdgeId!=-1) {
                     if(Capacity[incidentEdgeId]>Flow[incidentEdgeId] && pathEdgeIndex[To[incidentEdgeId]]==-1) {
                        pathEdgeIndex[To[incidentEdgeId]]=incidentEdgeId;
                        vertexQueue.add(To[incidentEdgeId]);
                     }
                     incidentEdgeId=Next[incidentEdgeId];
                 }
             }

            if(pathEdgeIndex[target]!=-1 && pathEdgeIndex[target]!=-2) {
                pathFound=true;
                int minCapacity=Integer.MAX_VALUE;
                int curVertex=target;
                //go backwards:
                while(pathEdgeIndex[curVertex]!=-2) {
                    minCapacity=Math.min(minCapacity,Capacity[pathEdgeIndex[curVertex]]-Flow[pathEdgeIndex[curVertex]]);
                    curVertex=From[pathEdgeIndex[curVertex]];
                }
                curVertex=target;
                //change flows:
                while(pathEdgeIndex[curVertex]!=-2) {
                     int backwardEdgeIndex;
                     if(pathEdgeIndex[curVertex]%2==0) {
                        backwardEdgeIndex=pathEdgeIndex[curVertex]+1;
                     }
                    else {
                        backwardEdgeIndex=pathEdgeIndex[curVertex]-1;
                     }
                     Flow[pathEdgeIndex[curVertex]]+=minCapacity;
                     Flow[backwardEdgeIndex]-=minCapacity;

                    if(Flow[pathEdgeIndex[curVertex]]>353535) {
                        return 353536;
                    }
                     curVertex=From[pathEdgeIndex[curVertex]];
                }
            }
        }

        //calculate flow
        int flow=0;
        int incidentEdgeId=Head[source];
        while(incidentEdgeId!=-1) {
           flow+=Flow[incidentEdgeId];
           incidentEdgeId=Next[incidentEdgeId];
        }
        return  flow;

    }
}
