package Heap.MinCostSticks;

import java.util.PriorityQueue;

class HeapMinCostSticksMain{
    public static void main(String[] args){
        int[] input = {2,4,3};
        int expected = 14;
        HeapMinCostSticks h = new HeapMinCostSticks();
        int actual = h.connectSticks(input);
        if(expected != actual){
            throw new AssertionError("Stick count doesnt match!");
        }
        System.out.println("Done");
    }
}
/**
 * [1167. Minimum Cost to Connect Sticks - Medium](https://leetcode.com/problems/minimum-cost-to-connect-sticks/)
 */
public class HeapMinCostSticks {
        public int connectSticks(int[] sticks) {
            // return the min cost of connecting all the given sticks into one stick

            // sort sticks by their value
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i : sticks){
                pq.add(i);
            }
            int cost = 0;
            while(pq.size() > 1){
                // grab the two smallest sticks
                int x = pq.poll();
                int y = pq.poll();
                cost += x + y;
                pq.add(x+y);
            }
            return cost;
        }
}
