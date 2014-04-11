package iensen.Graphs;
import iensen.DataStructures.DJS;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: iensen
 * Date: 12/23/12
 * Time: 10:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class KruskalAlgorithm
{
  public static Graph getMST(Graph g) {
       Graph answer=new SparseGraph(g.getVertexCount(),g.getEdgeCount());
       int V=g.getVertexCount();
       DJS djs=new DJS(V);
       ArrayList<Edge> list=getSortedEdgeList(g);
       for(Edge e:list) {
           int id1=djs.findId(e.from);
           int id2=djs.findId(e.to);
           if(id1!=id2) {

              answer.addEdge(e.from,e.to,e.weight);
              djs.unionSets(id1,id2);
           }
       }
       return answer;
  }

    private static ArrayList<Edge> getSortedEdgeList(Graph g) {
    ArrayList <Edge> answerList=new ArrayList<Edge>();
    for(int i=0;i<g.getVertexCount();i++) {
      ArrayList<Edge> list= (ArrayList<Edge>) g.getIncidentEdges(i);
      for(Edge e:list) {
          if(e.from>e.to)
          answerList.add(new Edge(e.from,e.to,e.weight));
      }
    }
    Collections.sort(answerList);
    return answerList;
  }
}
