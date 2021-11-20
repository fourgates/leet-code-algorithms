package Arrays.Sorting.ReorderLogs;

import java.util.Arrays;

/**
 * [937. Reorder Data in Log Files - Easy](https://leetcode.com/problems/reorder-data-in-log-files/)
 * 
 */
class ArraysSortingReorderLogsMain{
    public static void main(String[] args){
        String[] input = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] expected = {"let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"};

        ArraysSortingReorderLogs as =  new ArraysSortingReorderLogs();
        String[] actual = as.reorderLogFiles(input);
        for(int i=0;i<actual.length;i++){
            if(!actual[i].equals(expected[i])){
                throw new AssertionError("strings dont match!");
            }
        }
        System.out.println("done");
    }
}
public class ArraysSortingReorderLogs {
    // array of logs
    // each log is space delimited strig of words
    // the first word is the identifer 
    
    // two types of logs
    // letter-logs - all words conssit of lowercase letter
    // digit logs - all words consist of digits
    
    // reorder lgos so that
    // 1. letter logs come before all digit
    // 2. letter lgos are sorted lexi, the the same word, sort by identifer
    // 3. digit logs maintain their relative ordering 
    
    // questions?
    // constraints on the sixe of the words?
    // constraint on the number of logs?
    
    // return the final order of words
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a,b) ->{
            String[] aSplit = a.split(" ", 2);
            String[] bSplit = b.split(" ", 2);
            
            boolean aIsDigit = Character.isDigit(aSplit[1].charAt(0));
            boolean bIsDigit = Character.isDigit(bSplit[1].charAt(0));
            
            // both are not digits
            if(!aIsDigit && !bIsDigit){
                int comp = aSplit[1].compareTo(bSplit[1]);
                // strings are the same
                if(comp == 0){
                    return aSplit[0].compareTo(bSplit[0]);
                }
                else return comp;
            }
            // one log is a letter one is a digit
            if(!aIsDigit && bIsDigit){
                return -1;
            }
            else if(aIsDigit && !bIsDigit){
                return 1;
            }
            else{
                return 0;
            }
        });
        return logs;
    }
}
