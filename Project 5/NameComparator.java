/*
 * CS211 Chapter 13 - NameComparator.java
 * Jason Sy, 11/1/2021, Fall 2021
 *
 * Compares name of students to allow sorting by name.
 */

// CS 211 HW 5
//   GradeComparator
//
//   compares StudentData by name
//   if the name of s1 is less than    the name of s2, return a negative int
//   if the name of s1 is equal to     the name of s2, return zero
//   if the name of s1 is greater than the name of s2, return a positive int

import java.util.*;

public class NameComparator implements Comparator<StudentData> {
    public int compare(StudentData s1, StudentData s2) {
        // TODO: implement
        // comparator for strings
        int comparer = s1.getName().compareToIgnoreCase(s2.getName());
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
