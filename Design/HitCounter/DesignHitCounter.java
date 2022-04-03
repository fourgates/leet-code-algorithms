package Design.HitCounter;

import java.util.HashMap;
import java.util.Map;

public class DesignHitCounter {
    
}
class HitCounter {

    private Map<Integer, Integer> cache;
    public HitCounter() {
        this.cache = new HashMap<Integer, Integer>();
    }
    
    public void hit(int timestamp) {
        Integer count = cache.get(timestamp);
        if(count == null){
            count = 0;
        }
        count++;
        cache.put(timestamp, count);
    }
    
    public int getHits(int timestamp) {
        int endTime = timestamp - 300;
        int totalHits = 0;
        while(timestamp > endTime){
            Integer currentCount = cache.get(timestamp);
            if(currentCount != null){
                totalHits += currentCount;
            }
            timestamp--;
        }
        return totalHits;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */