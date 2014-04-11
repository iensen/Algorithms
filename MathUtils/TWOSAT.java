package iensen.MathUtils;

import iensen.Graphs.Graph;
import iensen.Graphs.SCC;
import iensen.Graphs.SparseGraph;
import iensen.Misc.Pair;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: iensen
 * Date: 2/3/13
 * Time: 5:59 PM
 * To change this template use File | Settings | File Templates.
 */
public
class TWOSAT
{
    ArrayList<Pair<Integer,Integer> >clauses;
    int variableCount;

    /**
     * Constructor
     * @param variableCount number of variables in instance
     * @param clauses  Each pair specifies a clause via its two literals,
     *                 with a number denoting the variable and a "-" sign denoting logical "not".
     *                 For example, "-16808 75250" indicates the clause -x16808 or x75250.
     */

    public TWOSAT(int variableCount,ArrayList<Pair<Integer,Integer> >clauses) {
        this.clauses=clauses;
        this.variableCount=variableCount;
    }

    public boolean checkSatisfability() {
        SparseGraph g=new SparseGraph(variableCount*2+1,clauses.size()*2);



        for(Pair<Integer,Integer> clause:clauses) {
            g.addEdge(-clause.first+variableCount,clause.second+variableCount);
            g.addEdge(-clause.second+variableCount,clause.first+variableCount);
        }

        SCC algoSCC=new SCC(g);

        int[] components=algoSCC.run();

        for(int i=0;i<g.getVertexCount();i++)
        {

            int symmetric;
            if(i>variableCount) {
                symmetric=variableCount-(i-variableCount);
            } else  {
                symmetric=variableCount+(variableCount-i);
            }
            if(components[symmetric]==components[i] && i!=variableCount ) {
                return false;
            }

        }


        return true;

    }
}