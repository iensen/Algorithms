package iensen.Graphs;

/**
 * Created with IntelliJ IDEA.
 * User: iensen
 * Date: 1/13/13
 * Time: 8:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class Johnson implements AllPairsShortestPathAlgo
{
    @Override
    public long[][] getDistances(Graph g)
    {
        Graph graph2=new SparseGraph(g.getVertexCount()+1,g.getEdgeCount()+g.getVertexCount()+1);
        for(int i=0;i<g.getVertexCount();i++) {
            for(Edge e:g.getIncidentEdges(i)) {
                graph2.addEdge(i,e.to,e.weight);
            }
            graph2.addEdge(g.getVertexCount(),i,0);
        }

        long []weights=new FordBellman().run(graph2,g.getVertexCount());
        if(weights==null) {
            return null;
        }
        long [][] answer=new long[g.getVertexCount()][g.getVertexCount()];
        for(int i=0;i<g.getVertexCount();i++) {
            long [] distances=new Djikstra(weights).run(g,i,-1);
            for(int j=0;j<distances.length;j++) {
                if(distances[j]==Long.MAX_VALUE) {
                    answer[i][j]=Long.MAX_VALUE;
                }
                else
                    answer[i][j]=distances[j]-weights[i]+weights[j];
            }
        }
        return answer;
    }
}
