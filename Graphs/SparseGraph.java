package iensen.Graphs;

import java.util.ArrayList;
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
    List[] incidentEdges;
    public SparseGraph(int vertexCount)
    {
        this.vertexCount=vertexCount;
        edgeCount=0;
        incidentEdges=new ArrayList[vertexCount];
        for(int i=0;i<vertexCount;i++)
        {
            incidentEdges[i]=new ArrayList<Edge>();
        }
    }
    @Override
    public void addEdge(int vertex,Edge e)
    {
        ++edgeCount;
        e.from=vertex;
        incidentEdges[vertex].add(e);
    }

    @Override
    public List<Edge> getIncidentEdges(int vertexId)
    {
        return incidentEdges[vertexId];
    }
}
