package iensen.DataStructures;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: iensen
 * Date: 2/24/13
 * Time: 10:40 AM
 * To change this template use File | Settings | File Templates.
 */
public class SegmentSegmentTree
{
    int array[];

    final int initVal=0;
    public SegmentSegmentTree(int[] initArray)
    {
        int togetCap = initArray.length * 2;
        int curLength = 1;
        while (curLength < togetCap)
        {
            curLength *= 2;
        }
        array = new int[curLength];
        Arrays.fill(array, initVal);
        build(initArray, 1, 0, curLength / 2 - 1);

    }

    private void build(int initArray[], int segmentTreeIdx, int initArrayLIdx, int initArrayRIdx)
    {
            if (initArrayLIdx == initArrayRIdx)
            {
                array[segmentTreeIdx] = (initArrayLIdx < initArray.length) ? initArray[initArrayLIdx] : initVal;
            } else
            {
                int initArrayMIdx = (initArrayLIdx + initArrayRIdx) / 2;
                //build subtrees:
                build(initArray, segmentTreeIdx * 2, initArrayLIdx, initArrayMIdx);
                build(initArray, segmentTreeIdx * 2 + 1, initArrayMIdx + 1, initArrayRIdx);

            }

    }
    public int query(int pos)
    {
        return query(1, 0, array.length / 2 - 1, pos);
    }

    private int query(int segmentTreeIdx, int coverLIdx, int coverRIdx, int queryIdx)
    {
        if (coverLIdx == coverRIdx)
            return array[segmentTreeIdx];
        int middleIndex = (coverLIdx + coverRIdx) / 2;
        if (queryIdx <= middleIndex)
            return array[segmentTreeIdx] + query (segmentTreeIdx*2, coverLIdx, middleIndex, queryIdx);
        else
            return array[segmentTreeIdx] + query (segmentTreeIdx*2+1, middleIndex+1, coverRIdx, queryIdx);

    }


    public void update(int lIndex,int rIndex,int newVal) {
        update(1,0,array.length/2-1,lIndex,rIndex,newVal);
    }

    private void update(int segmentTreeIdx, int coverLIdx, int coverRIdx, int lIndex,int rIndex, int new_val)
    {
        if (lIndex > rIndex)
            return;
        if (coverLIdx == lIndex && coverRIdx == rIndex)
            array[segmentTreeIdx] += new_val;
        else {
            int coverMidx = (coverLIdx + coverRIdx) / 2;
            update (segmentTreeIdx*2, coverLIdx, coverMidx, lIndex, Math.min(rIndex,coverMidx), new_val);
            update (segmentTreeIdx*2+1, coverMidx+1, coverRIdx, Math.max(lIndex,coverMidx+1),rIndex, new_val);
            //special cases are fired when converLidx==coverRidx
        }
    }
}
