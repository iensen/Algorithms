package iensen.DataStructures;

/**
 * Created with IntelliJ IDEA.
 * User: iensen
 * Date: 12/23/12
 * Time: 1:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class DJS
{
    int parent[];
    int rank[];
    int setCount=0;
    public DJS(int count) {
      parent=new int[count];
      rank=new int[count];
      setCount=count;
      for(int i=0;i<count;i++) {
          parent[i]=i;
          rank[i] = 0;
      }
    }
    public int getSetCount() {
       return setCount;
    }

    public int findId (int v) {
        if (v == parent[v])
            return v;
        return parent[v]=findId (parent[v]);
    }

    public void unionSets (int v1, int v2) {
        int parent1= findId (v1);
        int parent2= findId (v2);

        if (parent1 != parent2) {
            if(rank[parent1]>rank[parent2]) {
                int buf=parent1;
                parent1=parent2;
                parent2=buf;
            }
            --setCount;
            parent[parent1] = parent2;
            if(rank[parent1]==rank[parent2]) {
                rank[parent1]++;
            }
        }
    }
}
