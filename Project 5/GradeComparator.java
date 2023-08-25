/*
 * CS211 Chapter 13 - GradeComparator.java
 * Jason Sy, 11/1/2021, Fall 2021
 *
 * Compares grade of students to allow sorting by grade.
 */

// CS 211 HW 5
//   GradeComparator
//
//   compares StudentData by grade
//   if the grade of s1 is less than    the grade of s2, return a negative int
//   if the grade of s1 is equal to     the grade of s2, return zero
//   if the grade of s1 is greater than the grade of s2, return a positive int

import java.util.*;

public class GradeComparator implements Comparator<StudentData> {
    public int compare(StudentData s1, StudentData s2) {
        // TODO: implement
        // s1 less than s2
        if(s1.getGrade() < s2.getGrade()) {
            return -1;
        }
        // s1 greater than s2
        else if(s1.getGrade() > s2.getGrade()) {
            return 1;
        }
        // equal
        else {
            return 0;
        }
    }
}
