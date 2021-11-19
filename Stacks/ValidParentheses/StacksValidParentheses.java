package Stacks.ValidParentheses;

import java.util.Stack;

class StacksValidParenthesesMain{
    public static void main(String[] args) {
        String input  = "{[]}";
        StacksValidParentheses s = new StacksValidParentheses();
        boolean output = s.isValid(input);
        if(!output){
            throw new AssertionError("this should be true!");
        }
        System.out.println("done");
    }
}
/**
 * 20. Valid Parentheses - Easy
 * 
 * https://leetcode.com/problems/valid-parentheses/
 */
public class StacksValidParentheses {
        // given
    //
    // s is a string containing (), {}, []
    //
    // return
    // 
    // if the string is valid
    //
    // what does valid mean?
    //
    // 1. open brackets must be closed by the same type of bracket
    // 2. open brackets must be closed in the correct order
    //
    // e.g.
    //
    // ({[]})
    //
    
    public boolean isValid(String s) {
        if(s == null || s.length() <= 1 || s.length() % 2 != 0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.add(c);
            }
            else if (c == ')' && !stack.isEmpty() && stack.peek() == '('){
                stack.pop();
            }
            else if (c == ']' && !stack.isEmpty() && stack.peek() == '['){
                stack.pop();
            }            
            else if (c == '}' && !stack.isEmpty() && stack.peek() == '{'){
                stack.pop();
            }            
            else{
                return false;
            }
        }
        return stack.isEmpty();
    }
}
