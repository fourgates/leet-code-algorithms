package Greedy.MaxUnitsOnTruck;

import java.util.Arrays;

class GreedyMaxUnitsOnTruckMain{
    public static void main(String[] args){
        int[][] input  = {{1,3},{2,2},{3,1}};
        GreedyMaxUnitsOnTruck g = new GreedyMaxUnitsOnTruck();
        int truckSize = 4;
        int expected = 8;
        int actual = g.maximumUnits(input, truckSize);

        if(expected != actual){
            throw new AssertionError("Truck size is wrong!");
        }
        System.out.println("done!");
    }
}

/**
 * [1710. Maximum Units on a Truck - Easy](https://leetcode.com/problems/maximum-units-on-a-truck/)
 */
public class GreedyMaxUnitsOnTruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // sort the array by the max number of units in a box
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int unitCount = 0;

        // iterate over each box type utnil you reach the truck size
        for (int[] boxType : boxTypes) {
            int boxCount = Math.min(truckSize, boxType[0]);
            unitCount += boxCount * boxType[1];
            truckSize -= boxCount;
            if (truckSize == 0)
                break;
        }
        return unitCount;
    }
}
