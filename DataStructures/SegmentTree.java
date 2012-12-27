package iensen.DataStructures;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: iensen
 * Date: 12/27/12
 * Time: 10:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class SegmentTree
{
    int array[];
    final int initVal=2000000000;
    public SegmentTree(int []initArray) {
      int togetCap=initArray.length*2;
      int curLength=1;
      while(curLength<togetCap) {
          curLength*=2;
      }
      array=new int[curLength];
      Arrays.fill(array,initVal);
      build(initArray,1,0,curLength/2-1);

    }

    private void build (int initArray[], int segmentTreeIdx, int initArrayLIdx,int initArrayRIdx) {
        //FILL leaves:
        if (initArrayLIdx==initArrayRIdx)        {
            array[segmentTreeIdx] =(initArrayLIdx<initArray.length)? initArray[initArrayLIdx]:initVal;
        }
        else {
            int  initArrayMIdx = (initArrayLIdx+initArrayRIdx)/2;
            //build subtrees:
            build (initArray, segmentTreeIdx*2, initArrayLIdx, initArrayMIdx);
            build (initArray, segmentTreeIdx*2+1, initArrayMIdx+1, initArrayRIdx);
            //assign value to current vertex
            array[segmentTreeIdx] = Math.min(array[segmentTreeIdx*2],
                    array[segmentTreeIdx*2+1]);
        }
    }
    public int query(int left,int right) {
         return query(1,0,array.length/2-1,left,right);
    }
    private int query (int segmentTreeIdx, int coverLIdx, int coverRIdx, int queryLIdx, int queryRIdx) {
        if (queryLIdx > queryRIdx)
            return initVal;
        if (coverLIdx == queryLIdx && coverRIdx == queryRIdx)
            return array[segmentTreeIdx];
        int coverMIdx = (coverLIdx + coverRIdx) / 2;
        return Math.min(query (segmentTreeIdx*2, coverLIdx, coverMIdx, queryLIdx, Math.min(queryRIdx,coverMIdx))
                , query (segmentTreeIdx*2+1, coverMIdx+1, coverRIdx, Math.max(queryLIdx,coverMIdx+1), queryRIdx));
    }


}
