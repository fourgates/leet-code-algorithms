package Arrays.DailyTemperatures;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArraysDailyTemperatures {
    
}
/*
    given
        - array of ints
        - rep daily temps
        
    todo
        - return an array of ints where ans[i] is the number of days you have to wait
          until after the ith day to get a warmer temperature
          
    edge cases
        - if there is no future day then then ans[i] should equal 0
        
        
    questions
        - how many temps?
        - range for temps?
        - can temps be empty?
        
    food for thought
        - init array of the same size of temps
        - the last index will always be 0
        - brute force n^2 nested loop for each temp - that was easy...
        - how can we do this faster?
        - work backwards... what does that mean
        - two pointers, keep track of last warm day
        - if you are at 60, go back one
        - is the temp < 
        
    [30, 40, 50, 60]
    
    [1,   1,  1,  0]
**/
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // return bruteForce(temperatures);
        // return stacks(temperatures);
        return arrayOptimized(temperatures);
    }
    private int[] arrayOptimized(int[] temp){
        int n = temp.length;
        int[] answer = new int[n];
        int hottest = 0;
        for(int currDay = n-1;currDay >= 0; currDay--){
            int currentTemp = temp[currDay];
            if(currentTemp >= hottest){
                hottest = currentTemp;
                continue;
            }
            int days = 1;
            while(temp[currDay + days] <= currentTemp){
                // use the info from answer to search for the next warmer day
                days += answer[currDay + days];
            }
            answer[currDay] = days;
        }
        return answer;
    }
    private int[] stacks(int[] temp){
        int n = temp.length;
        int[] answer = new int[n];
        answer[n - 1] = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int currDay=0;currDay<n;currDay++){
            int currTemp = temp[currDay];
            
            // pop until the current days temp
            // is not warmer than the temp at the top of the stack
            
            // what is on the top of the stack? 
            //  - the previous days
            while(!stack.isEmpty() && temp[stack.peek()] < currTemp){
                int prevDay = stack.pop();
                answer[prevDay] = currDay - prevDay;
            }
            stack.push(currDay);
        }
        return answer;
    }
    private int[] bruteForce(int[] temperatures){
        int[] answer = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            int currentTemp = temperatures[i];
            int daysUntil = 0;
            for(int j=i+1;j<temperatures.length;j++){
                if(temperatures[j] > currentTemp){
                    daysUntil = j-i;
                    break;
                }
            }
            answer[i] = daysUntil;
        }
        return answer;        
    }
}