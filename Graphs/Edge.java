package iensen.Graphs;

/**
 * Created with IntelliJ IDEA.
 * User: iensen
 * Date: 12/14/12
 * Time: 12:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class Edge implements Comparable<Edge>
{
   int from;
   public int to;
   public int weight;

    public int getFrom()
    {
        return from;
    }

    public void setFrom(int from)
    {
        this.from = from;
    }

    public int getTo()
    {
        return to;
    }

    public void setTo(int to)
    {
        this.to = to;
    }

    public int getWeight()
    {
        return weight;
    }

    public void setWeight(int weight)
    {
        this.weight = weight;
    }

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
    public int compareTo(Edge edge)
    {
        if(this.weight< edge.weight)
        {
            return -1;
        }
        else if(this.weight==edge.weight && this.to==edge.to && this.from==edge.from) {
            return 0;
        }
        else return 1;
    }


}
