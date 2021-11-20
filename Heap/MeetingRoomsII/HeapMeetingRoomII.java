package Heap.MeetingRoomsII;

import java.util.Arrays;
import java.util.PriorityQueue;
class HeapMeetingRoomIIMain{
    public static void main(String[] args){
        HeapMeetingRoomII h = new HeapMeetingRoomII();
        int input[][] = {{0,30},{5,10},{15,20}};
        int expected = 2;
        int actual = h.minMeetingRooms(input);
        if(expected != actual){
            throw new AssertionError("The rooms is not correct");
        }
        System.out.println("done");
    }
}
/**
 * 253. Meeting Rooms II - Medium
 * 
 * https://leetcode.com/problems/meeting-rooms-ii/
 */
public class HeapMeetingRoomII {
    public int minMeetingRooms(int[][] intervals) {
        // edge case
        if(intervals.length == 0){
            return 0;
        }
        
        // sort meetings by their start time
        Arrays.sort(intervals, (a,b)->a[0] - b[0]);
        

        // use a heap to keep the meeting with the earliest ending time first
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)-> a[1] - b[1]);
        // queue up the first meeting
        pq.add(intervals[0]);

        // reduce intervals (all meetings) 
        for(int i=1;i<intervals.length;i++){ // start at 1 bc we already queued up the first meeting
            int[] curr = intervals[i];
            int[] prev = pq.poll();
            // if the current start time is before the prev end time
            // we need two rooms (thanks to sorting!)
            if(curr[0] < prev[1]){
                pq.add(prev);
                pq.add(curr);
            }
            // we only need one room bc there is no overlap
            else{
                // extend the prev end time and add it back to the queue
                prev[1] = curr[1];
                pq.add(prev);
            }
        }
        // at the end of the loop we end up with a merged queue of intervals
        // if two rooms were required they both would have been added to the heap
        // else we just merged the two meetings and added one room
        return pq.size();
    }
}
