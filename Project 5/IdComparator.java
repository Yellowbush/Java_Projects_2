/*
 * CS211 Chapter 13 - IdComparator.java
 * Jason Sy, 11/1/2021, Fall 2021
 *
 * Compares id of students to allow sorting by ID.
 */


// CS 211 HW 5
//   GradeComparator
//
//   compares StudentData by ID
//   if the id of s1 is less than    the id of s2, return a negative int
//   if the id of s1 is equal to     the id of s2, return zero
//   if the id of s1 is greater than the id of s2, return a positive int

import java.util.*;

public class IdComparator implements Comparator<StudentData> {
    public int compare(StudentData s1, StudentData s2) {
        // TODO: implement
        // comparator for strings
        int comparer = s1.getId().compareToIgnoreCase(s2.getId());
        // s1 less than s2
        if(comparer < 0) {
            return -1;
        }
        // s1 greater than s2
        else if(comparer > 0) {
            return 1;
        }
        // equal
        else {
            return 0;
        }
    }
}
