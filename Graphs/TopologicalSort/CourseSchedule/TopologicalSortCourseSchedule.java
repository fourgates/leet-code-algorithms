package Graphs.TopologicalSort.CourseSchedule;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSortCourseSchedule {
    
}
/**
    given:
    
    - courses labled from 0 to num-1 (0 based)
    - you are given the total number of courses
    - you are given an array of pre reqs
    - prereq[i][1] = prereq
    - prereq[i][0] = course to take (need to take [1] to take [0])
    - e.g. [0,1] means you need to take 1 before 0
    
    return:
        boolean value if its possible to finish all the course
        
    contraints:
        there can be a large number of courses + prereqs
        all pairs are unique
        
    thoughts:
        - kind of seems like a tree of classes
        - if there is a circular dependency you cannot finish
        - disjoint sets?
            - you can havce n number of disjoint sets, they dont all need to be part of the same 
              chain
            - [0,1] [1,2], [0,3]
            - if a course is never in [1] then it doesnt have a prereq, you can take it whenever
        - do all classes have a pre req? ..thinking..
        - 
        
    algorithm:
        - thinking about using DFS to transverse a tree of courses
        - if you can transverse the entire tree you should be able to finish all the courses
        - the top of the tree if the courses that either require pre req
        
    pseduo code:        
        - create a graph of courses and their pre reqs
        - create a grpah of pre reqs and which courses they are required for
        - start with courses that do not have a pre req, if no such course return false
        - pop course
        - continue if it was already visited
        - mark is visted
        - increment the number of courses taken
        - check which courses this was a pre req for
        - check to see if you have taken all the other pre reqs for that course
        - if you have taken all the pre reqs add this class to the stack
        - return if the number of courses taken so far are equal to numCourses

*/

class Solution {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0){
            return true;
        }
        List<List<Integer>> coursesFor = new ArrayList<>();
        List<List<Integer>> coursesBy = new ArrayList<>();
        
        for(int i=0;i<numCourses;i++){
            coursesFor.add(new ArrayList<>());
            coursesBy.add(new ArrayList<>());
        }
        
        for(int[] classes : prerequisites){
            // keep track of pre req's for each course
            // keep track of courses by pre reqs
            
            // e.g. 1 ([1]) is a pre req for 0 ([0])
            coursesFor.get(classes[1]).add(classes[0]);
            coursesBy.get(classes[0]).add(classes[1]);
        }
        
        // find courses with no pre req
        // if this doesnt exist there is a cycle!
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<numCourses;i++){
            List<Integer> prereqsFor  = coursesBy.get(i);
            if(prereqsFor.size() == 0){
                stack.add(i);
            }
        }
        if(stack.isEmpty()){
            return false;
        }
        
        // keep track of the courses that have been taken and visited
        boolean[] visited = new boolean[numCourses];
        int coursesTaken = 0;
        while(!stack.isEmpty()){
            Integer course = stack.pop();
            if(visited[course]){
                continue;
            }
            visited[course] = true;
            coursesTaken++;
            // check to see which courses this course is a pre req for
            // we just took it so we want to see if we can take the parent class
            List<Integer> wasAPreReqForCourses = coursesFor.get(course);
            
            // can we take these courses now? since we took the prereq
            for(Integer prereq : wasAPreReqForCourses){
                List<Integer> wasPreReqFor = coursesBy.get(prereq);
                boolean canTakeCourse = true;
                for(Integer didWeTakeYet : wasPreReqFor){
                    if(!visited[didWeTakeYet]){
                        canTakeCourse = false;
                    }
                }
                if(canTakeCourse){
                    stack.add(prereq);
                }
            }
        }
        return coursesTaken >= numCourses;
    }
}