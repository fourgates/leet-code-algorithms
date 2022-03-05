package Trie.SearchSuggestionSystem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

    3 different ways to solve this problem. 

    1. Doing a binary search at each substring. (Fastest)
        2. Time - `O(nlog(n))+O(mlog(n))` - where `n` = # of prouducts and m = length of `searchWord`
            3. `nlog(n)` - initial sorting
            4. `mlog(n)` - binary search
        3. Space - `O(1)` - for the most part
    2. Using a Trie + DFS. (Slowest for some reason)
        3. Time - `O(M)` - to build tree where `M` = the total # of characters in `products`
        4. Space - `O(M)` - where `M` is the total number of characters of products. Note a hashmap representaiton
    3. Brute force, just creating a dictionary / hashmap for each prefix in each word (2nd fastest)
        4. Time - `O(M *N) + O(N)` where `M` = the total number of products and `N` = the length of the searchWord
        5. Space - `O(M)` where `M` is the total number of characters in all products. this is most likely going to much smaller than this!

    you are given an array of products and search word
    
    suggest at most 3 products after each character is typed
    
    rules
        - should have a common prefix
        - if more than three proudcts with common prefix return the three lexx min products
        
    return
        - a list of lists suggested prudcts after each character of searchWord is types
        - list.size() == searchWorkd.length
        
    constraints
        - up to 1000 produts
        - up to 3000 characters per product
        - all strings are unique
        - both products and search word are lowercase
        - the searchWord can be up to 1000 characters
        - are the products sorted?
        
    thoughts
        - hashmap - brute force
            - 1000 * 3000 = 3000000 possible unique keys
            - O(i * j) - i = number of proucts * number of characters
            - could be a long startup + memory but constant find search
            
        - searching
            - we could sort O(nlogn)
            - then make use of a binary or quick sort
            
        - tree's
            - disjoint sets, quick find?
                - allows you to quickly find a parent...
            - a trie problem (prefix tree)?
*/
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // fastest
        return binarySearchSolution(products, searchWord);
        // 2nd fastest (brute force-ish)
        //return hashmapSolution(products, searchWord);
        // slowest
        //return trieSoltuion(products, searchWord);
    }
    private List<List<String>> binarySearchSolution(String[] products, String searchWord){
        // sort the products O(lg(n))
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        
        int start = 0;
        int bsStart = 0;
        int n = products.length;
        String prefix = "";
        
        // iterate over each char in the search word
        for(char c : searchWord.toCharArray()){
            // increment prefix we are searching
            prefix += c;
            
            // get the starting index of word starting with the given prefix
            start = lowerBounds(products, bsStart, prefix);
            
            result.add(new ArrayList<>());
            
            // start at the first occurrence of the prefix
            for(int i=start;i<Math.min(start+3, n);i++){
                // product length is less than the current prefix we are search for...
                if(products[i].length() < prefix.length()){
                    break;
                }
                if(!products[i].startsWith(prefix)){
                    break;
                }
                result.get(result.size() - 1).add(products[i]);
            }
            bsStart = Math.abs(start);
        }
        return result;
    }
    private int lowerBounds(String[] products, int start, String prefix){
        int i = start;
        int j = products.length;
        int mid = -1;
        while(i<j){
            mid = (i+j) / 2;
            if(products[mid].compareTo(prefix) >= 0){
                j = mid;
            }
            else{
                i = mid + 1;
            }
        }
        return i;
    }
    private List<List<String>> trieSoltuion(String[] products, String searchWord){
        Trie trie = new Trie();
        // insert all products into trie
        for(String product : products){
            trie.insert(product);
        }
        List<List<String>> result = new ArrayList<>();
        
        // do a search at each prefix
        String prefix = "";
        for(char c : searchWord.toCharArray()){
            prefix += c;
            result.add(trie.searchForPrefix(prefix));
        }
        return result;
    }
    class Trie{
        class TrieNode{
            public boolean isWord;
            public Map<Character, TrieNode> childMap = new HashMap<>();
        }
        private TrieNode root;
        
        public Trie(){
            root = new TrieNode();
        }
        public void insert(String word){
            TrieNode curr = root;
            // iterate over each char in the word
            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);
                // add an edge for each char
                if(curr.childMap.get(c) == null){
                    curr.childMap.put(c, new TrieNode());
                }
                // move the pointer
                curr = curr.childMap.get(c);
            }
            // keep track of which nodes are words
            // not all nodes will end to form a word
            curr.isWord = true;
        }
        public List<String> searchForPrefix(String prefix){
            TrieNode curr = root;
            List<String> result = new ArrayList<>();
            
            // move the pointer (curr) to the end of the prefix it represents
            // this will contain all the words that can be created with the given prefix
            for(char c : prefix.toCharArray()){
                if(curr.childMap.get(c) == null){
                    // not found
                    return result;
                }
                curr = curr.childMap.get(c);
            }
            // do a dfs to determine all the words that can be 
            // suggested based on the given prefix
            dfs(curr, prefix, result);
            return result;
        }
        private void dfs(TrieNode curr, String word, List<String> result){
            // base case
            // this is business specific logic
            if(result.size() == 3){
                return;
            }
            // if the current node is a word, add it to the list
            if(curr.isWord){
                result.add(word);
            }
            // this is a trick to make sure the words are return in lexi order
            // iterate over each char (lexi order)
            for (char c = 'a'; c <= 'z'; c++){
                if(curr.childMap.get(c) == null){
                    continue;
                }
                dfs(curr.childMap.get(c), word+c, result);
            }
        }
    }
    private List<List<String>> hashmapSolution(String[] products, String searchWord){
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        
        for(String product : products){
            String key = "";
            for(int i=0;i<product.length();i++){
                key += product.charAt(i);
                if(map.get(key) == null){
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(product);
            }
        }
        String key = "";
        for(int i=0;i<searchWord.length();i++){
            key += searchWord.charAt(i);
            List<String> wordsWithPrefix = map.get(key);
            if(wordsWithPrefix == null){
                result.add(new ArrayList<>());
                continue;
            }
            Collections.sort(wordsWithPrefix);
            List<String> curr = new ArrayList<>();
            for(int j=0;j<3 && j<wordsWithPrefix.size();j++){
                curr.add(wordsWithPrefix.get(j));  
            }
            result.add(curr);    
        }
        return result;        
    }
}