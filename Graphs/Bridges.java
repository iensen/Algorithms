package iensen.Graphs;

/**
 * Created with IntelliJ IDEA.
 * User: iensen
 * Date: 7/7/13
 * Time: 10:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class Bridges {



    int n,m;

    int timer, tin[], fup[];

    void dfs (int v, int p,boolean[]used,SparseGraph g,boolean isBridge[]) {
        used[v] = true;
        tin[v] = fup[v] = timer++;
        //tin[v]=timer++;
        //fup[v]=Integer.MAX_VALUE;
        int index=g.Head[v];
        while(index!=-1){

            int to = g.To[index];
            if (to != p){
                if (used[to])
                    fup[v] = Math.min(fup[v], tin[to]);
                else {
                    dfs (to, v,used,g,isBridge);
                    fup[v] = Math.min(fup[v], fup[to]);
                    if (fup[to] > tin[v])
                        isBridge[index]=true;
                }
            }
            index=g.Next[index];
        }
    }

    void find_bridges(boolean []used,SparseGraph g,boolean isBridge[]) {
        timer = 0;
        for (int i=0; i<n; ++i)
            used[i] = false;
        tin=new int[n];
        fup=new int[n];
        for (int i=0; i<n; ++i)
            if (!used[i])
                dfs (i,-1,used,g,isBridge);
    }

    public boolean [] run(SparseGraph g) {


        boolean isBridge[]=new boolean[g.getEdgeCount()];

        boolean []used=new boolean[n];

        find_bridges(used,g,isBridge);
        return isBridge;

    }
}
