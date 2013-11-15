package iensen.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: iensen
 * Date: 12/14/12
 * Time: 12:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class SparseGraph extends   Graph
{
    public int []From;
    public int []To;
    public int Head[];
    public int Next[];
    public int Weight[];
    int edgeCapacity;
    public SparseGraph(int vertexCount,int edgeCapacity)
    {
        From=new int[edgeCapacity];
        To=new int[edgeCapacity];
        Head=new int[vertexCount];
        Next=new int[edgeCapacity];
        Arrays.fill(Next,-1);
        Arrays.fill(Head,-1);
        this.edgeCapacity=edgeCapacity;
        this.vertexCount=vertexCount;
        edgeCount=0;
    }


    @Override
    public void addEdge(int from, int to) {
        From[edgeCount]=from;
        To[edgeCount]=to;
        Next[edgeCount]=Head[from];
        Head[from]=edgeCount;
        ++edgeCount;
    }

    @Override
    public void addEdge(int from, int to, int weight)
    {
        if(Weight==null)  {
            Weight=new int[edgeCapacity];
        }
        addEdge(from,to);
        Weight[edgeCount-1]=weight;
    }



    @Override
    public List<Edge> getIncidentEdges(int vertexId)
    {
       ArrayList<Edge> list=new ArrayList<Edge>();
       int p=Head[vertexId];
       while(p!=-1) {
           Edge e=new Edge(To[p]);
           list.add(e);
           p=Next[p];
       }
        return list;
    }

    @Override
    public void clearIncidentEdges(int vertexId)
    {
        Head[vertexId]=-1;
    }


}
