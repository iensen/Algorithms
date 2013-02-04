package iensen.Graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: iensen
 * Date: 12/14/12
 * Time: 12:10 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Graph
{
    int vertexCount;
    int edgeCount;
    public abstract void addEdge(int vertex,Edge e);
    public int getVertexCount()
    {
        return vertexCount;
    }

    public void addEdge(int from,int to) {
        Edge e=new Edge(to);
        addEdge(from,e);
    }

    public int getEdgeCount() {
        return edgeCount;
    }
    public abstract List<Edge> getIncidentEdges(int vertexId);
    public abstract void clearIncidentEdges(int vertexId);
}
