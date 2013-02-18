package iensen.AI.Astar;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * User: iensen
 * Date: 2/17/13
 * Time: 5:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class GraphSearch
{
    State initialState;
    public GraphSearch(State init) {
        initialState=init;
    }

    public int getDist(State to) {
        PriorityQueue<State> Q=new PriorityQueue<State>();
        Q.add(initialState);
        HashMap<State,Integer>  foundDist=new HashMap<State, Integer>();
        foundDist.put(initialState,0);
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
                if(foundDist.containsKey(newState)) {
                   if(newState.getDistance()>foundDist.get(newState)) {

                       continue;
                   }
                   Q.remove(newState);
                   foundDist.put(newState,newState.getDistance());
                }
                Q.add(newState);
            }
        }
        return Integer.MAX_VALUE;
    }
}
