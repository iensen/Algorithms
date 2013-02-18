package iensen.AI.Astar;

import iensen.Graphs.Edge;
import iensen.Misc.Pair;

import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * User: iensen
 * Date: 2/17/13
 * Time: 3:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class TreeSearch
{
    State initialState;
    public TreeSearch(State init) {
        initialState=init;
    }

    public int getDist(State to) {
        PriorityQueue<State> Q=new PriorityQueue<State>();
        Q.add(initialState);
        while(!Q.isEmpty()) {
            // fetch the closest to start element
            // from “queue” organized via set
            State top = Q.poll();
            System.out.println(top.toString());
            if(top.equals(to)) {
                return top.getDistance();
            }
            for (State s:top.expand()) {
                State newState=s.getCopy();
                newState.setHeuristicValue(s.getHeuristicValue());
                newState.setDistance(top.getDistance()+top.getDistanceTo(newState));
                Q.add(newState);
            }
        }
        return Integer.MAX_VALUE;
    }
}
