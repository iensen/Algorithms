package iensen.AI.Astar;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: iensen
 * Date: 2/17/13
 * Time: 3:28 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class State implements Comparable<State>
{
    int heuristicValue ;

    public State() {};
    public int getHeuristicValue()
    {
        return heuristicValue;
    }

    public int getDistance()
    {
        return distance;
    }

    public void setHeuristicValue(int heuristicValue)
    {
        this.heuristicValue = heuristicValue;
    }

    public void setDistance(int distance)
    {
        this.distance = distance;
    }

    int distance;
    public State(int heuristicValue) {
        this.heuristicValue=heuristicValue;
    }
    public State(int heuristicValue,int distance) {
        this.heuristicValue=heuristicValue;
        this.distance=distance;
    }

    public int getMeasure() {
        return this.heuristicValue+this.distance;
    }

    abstract public ArrayList<State> expand();

    @Override
    public int compareTo(State s) {
        return this.getMeasure()-s.getMeasure();
    }

    @Override
    abstract public boolean equals(Object o);
    @Override
    abstract public int hashCode();

    abstract public State getCopy();

    abstract public int getDistanceTo(State s);
}
