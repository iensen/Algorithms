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
    public int vertexCount;
    public int edgeCount;
    public int getVertexCount()
    {
        return vertexCount;
    }

    abstract public void addEdge(int from,int to);

    abstract public void addEdge(int from,int to, int weight);


    public int getEdgeCount() {
        return edgeCount;
    }
    public abstract List<Edge> getIncidentEdges(int vertexId);
    public abstract void clearIncidentEdges(int vertexId);
}
