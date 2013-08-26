package iensen.Graphs;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: iensen
 * Date: 2/3/13
 * Time: 5:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class SCC
{
    Graph graph;
    Graph transposedGraph;

    public SCC(Graph g) {
        this.graph=g;
        used=new boolean[g.getVertexCount()];
        order=new ArrayList<Integer>(g.getVertexCount());
        component=new ArrayList<Integer>(g.getVertexCount());
        buildTransposedGraph();
    }

    private void buildTransposedGraph() {

        transposedGraph=new SparseGraph(graph.getVertexCount(),graph.getEdgeCount());

        for(int v=0;v<graph.getVertexCount();v++) {
            for(Edge e:graph.getIncidentEdges(v)) {
                transposedGraph.addEdge(e.to,v);
            }
        }

    }
    boolean [] used;
    ArrayList<Integer> order, component;

    void dfs1 (int v) {
        used[v] = true;
        for (Edge e:graph.getIncidentEdges(v))
            if (!used[e.to])
                dfs1 (e.to);
        order.add(v);
    }

    void dfs2 (int v,int componentId,int []assignedComponents) {
        used[v] = true;
        assignedComponents[v]=componentId;
        component.add(v);
        for (Edge e:transposedGraph.getIncidentEdges(v))
            if (!used[e.to])
                dfs2 (e.to,componentId,assignedComponents);
    }

    public int[] run() {
        int []assignedComponents=new int[graph.getVertexCount()];
        Arrays.fill(used,false);

        for (int i=0; i<graph.vertexCount; ++i)
            if (!used[i])
                dfs1 (i);


        Arrays.fill(used,false);

        int componentId=0;
        for (int i=0; i<graph.vertexCount; ++i) {
            int v = order.get(graph.vertexCount-1-i);
            if (!used[v]) {
                ++componentId;
                dfs2 (v,componentId,assignedComponents);
                //components.add(component);
            }
        }

        return  assignedComponents;
    }
}
