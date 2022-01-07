package Graphs.DFS.ReconstructItinerary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DFSReconstructItinerary {
    
}
// GIVEN
//
// tickets[i] = [from, to]
// start = jfk
// 
// n = tickets.length
// 
// just need to do a dfs for the tickets
//
// use a ds to store the graph, map? {string, []}
// start with jfk
// find the next dest
// add to path
// find the next dest
class Solution {
    private List<String> path = new ArrayList<>();
    
    // use a link list so we can man
    private Map<String, ArrayList<String>> graph = new HashMap<>();
    
    public List<String> findItinerary(List<List<String>> tickets) {
        // edge case
        if(tickets == null || tickets.size() == 0){
            return path;
        }
        
        // create a graph
        for(List<String> ticket : tickets){
            String src = ticket.get(0);
            String dest = ticket.get(1);
            ArrayList<String> nodes = graph.get(src);
            if(nodes == null){
                nodes = new ArrayList<>();
            }
            nodes.add(dest);
            graph.put(src, nodes);
        }
        
        // sort dest bc they need to be visited in lexi order
        for(String key : graph.keySet()){
            Collections.sort(graph.get(key));
        }
        dfs("JFK");
        
        // we need to reverse the list of the iterinary bc they
        // recursion make them backwards
        Collections.reverse(path);
        return path;
    }
    
    private void dfs(String origin){
        // if the origin has destinations we need to iterate over them
        if(graph.containsKey(origin)){
            // get the edges for the orgin
            ArrayList<String> edges = graph.get(origin);
            
            // iterate over each edge
            int i=0;
            while(!edges.isEmpty()){
                String d = edges.get(i);
                
                // remove them from the list as we visit them
                edges.remove(d);
                
                // on to the next one...
                dfs(d);
            }         
        }
        path.add(origin);
    }
}