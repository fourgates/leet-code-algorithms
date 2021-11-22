package Arrays.SingleNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ArraysSingleNumberMain{
    public static void main(String[] args){
        int[] input = {2,2,1};
        int expectedOutput = 1;
        int actualOutput = new ArraysSingleNumber().singleNumber(input);
        if(expectedOutput != actualOutput){
            throw new AssertionError("output doesnt match");
        }
        System.out.println("done");
    }
}
public class ArraysSingleNumber {
    public int singleNumber(int[] nums) {
        if(nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            return nums[0];
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            List<Integer> l = map.get(nums[i]);
            if(l == null){
                l = new ArrayList<Integer>();
            }
            l.add(nums[i]);
            map.put(nums[i], l);
        }
        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            if(entry.getValue().size() < 2){
                return entry.getKey();
            }
        }
        return -1;
    }
}
