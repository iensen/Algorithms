package iensen.Graphs;

/**
 * Created with IntelliJ IDEA.
 * User: iensen
 * Date: 12/14/12
 * Time: 12:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class Edge
{
    int from;
    int to;
    int weight;
    int capacity;
    public  Edge(int to)
    {
        //this.from=from;
        this.to=to;
    }
    public Edge(int to,int weight)
    {
       this(to);
       this.weight=weight;
    }
    public Edge(int from,int to,int weight)
    {
        this(to);
        this.from=from;
        this.weight=weight;
    }
}
