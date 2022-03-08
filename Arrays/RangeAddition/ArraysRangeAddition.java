package Arrays.RangeAddition;

import java.util.Arrays;

public class ArraysRangeAddition {
    
}
// great explaination!
// https://leetcode.com/problems/range-addition/discuss/84225/Detailed-explanation-if-you-don't-understand-especially-%22put-negative-inc-at-endIndex%2B1%22
/*
    given
        int length
        array of updates
        update[i] = startIdx, endIdx, increment
        
    task
        pretend you have an arr of length length
        you have some operation to apply on arr
        for each operation you should increment all the elemnts in the given ranges
        by a given increment
        
    e.g.
    
        start array
        [0,0,0]
        
        length = 3
        
        updates
        [0,1,1]
        [1,1,1]
        [1,2,2]
        
    constraints
        how big can length be?
            - can be very big
        how many updates can there be?
            - can big almost as big
        can we assumed startIdx <= endIDx?
            - yes
        increment values?
            - +- 1000
            
    brute force
        init array - fill with zeros
        iterate over updates
            for each update iterate over each range
                apple each update
                
        complexity?
            fill array - n
            iterate over update - m
            iterate over range - n
            O(m*n)
            
        can we make this faster?
        
*/
class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        //return bruteForce(length, updates);
        return rangeArray(length, updates);
    }
    private int[] rangeArray(int length, int[][] updates){
        int[] arr = new int[length];
        Arrays.fill(arr, 0);        
        // increment the start value
        // decrement the end + 1
        for(int[] update : updates){
            int start = update[0], end = update[1], val = update[2];
            arr[start] += val;
            if(end < length - 1){
                arr[end + 1] -= val;
            }
        }
        // add the value up cumlatively
        // we added the value to end + 1 bc there is where to stop
        for(int i=1;i<length;i++){
            arr[i] += arr[i-1];
        }
        return arr;
    }
    private int[] bruteForce(int length, int[][] updates){
        int[] arr = new int[length];
        Arrays.fill(arr, 0);
        for(int[] update : updates){
            for(int i=update[0];i<=update[1];i++){
                arr[i] += update[2];
            }
        }
        return arr;        
    }
}