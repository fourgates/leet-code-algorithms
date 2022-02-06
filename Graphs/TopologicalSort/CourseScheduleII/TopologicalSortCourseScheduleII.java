package Graphs.TopologicalSort.CourseScheduleII;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSortCourseScheduleII {
    
}
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
            return new int[0];
        }
        
        // keep track of the courses that have been taken and visited
        boolean[] visited = new boolean[numCourses];
        int coursesTaken = 0;
        int[] courseOrder = new int[numCourses];
        while(!stack.isEmpty()){
            Integer course = stack.pop();
            if(visited[course]){
                continue;
            }
            courseOrder[coursesTaken] = course;
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
        if(coursesTaken >= numCourses){
            return courseOrder;
        }
        return new int[0];
    }
}