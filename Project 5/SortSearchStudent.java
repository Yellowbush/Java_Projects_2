/*
 * CS211 Chapter 13 - SortSearchStudent.java
 * Jason Sy, 11/1/2021, Fall 2021
 *
 * Scans and sorts student with custom ordering then prints.
 */


// CS 211 HW 5
//   SortSearchStudent
//
//   Sort and Search with Custom Ordering

import java.io.*;
import java.util.*;

public class SortSearchStudent {
    private List<StudentData> studentList = new ArrayList<StudentData>();

    public static void main(String[] args) throws FileNotFoundException {
        // TODO: change path to match where your input file is located
        File f = new File("/students.txt");

        SortSearchStudent sss = new SortSearchStudent(f);

        System.out.println("\n=== The original ===");
        sss.PrintList();


        System.out.println("\n=== Sort by Name ===");
        sss.SortList(new NameComparator());
        sss.PrintList();


        System.out.println("\n=== Search by Name: Smith Marty ===");
        sss.SearchAndPrintEntry(new StudentData("Smith Marty", "", 0), new NameComparator());
        System.out.println("\n=== Search by Name: Johnson Gus ===");
        sss.SearchAndPrintEntry(new StudentData("Johnson Gus", "", 0), new NameComparator());

        System.out.println("\n=== Search by Name: Foo Bar ===");
        sss.SearchAndPrintEntry(new StudentData("Foo Bar", "", 0), new NameComparator());


        System.out.println("\n=== Sort by Id ===");
        sss.SortList(new IdComparator());
        sss.PrintList();

        System.out.println("\n=== Search by Id: 346282 ===");
        sss.SearchAndPrintEntry(new StudentData("", "346282", 0), new IdComparator());
        System.out.println("\n=== Search by Id: 210498 ===");
        sss.SearchAndPrintEntry(new StudentData("", "210498", 0), new IdComparator());
        System.out.println("\n=== Search by Id: 999999 ===");
        sss.SearchAndPrintEntry(new StudentData("", "999999", 0), new IdComparator());


        System.out.println("\n=== Sort by Grade ===");
        sss.SortList(new GradeComparator());
        sss.PrintList();

        System.out.println("\n=== Search by Grade: 84.1 ===");
        sss.SearchAndPrintEntry(new StudentData("", "", 84.1), new GradeComparator());
        System.out.println("\n=== Search by Grade: 98.6 ===");
        sss.SearchAndPrintEntry(new StudentData("", "", 98.6), new GradeComparator());
        System.out.println("\n=== Search by Grade: 72.4 ===");
        sss.SearchAndPrintEntry(new StudentData("", "", 72.4), new GradeComparator());
        System.out.println("\n=== Search by Grade: 100 ===");
        sss.SearchAndPrintEntry(new StudentData("", "", 100), new GradeComparator());
    }

    public SortSearchStudent(File f) throws FileNotFoundException {
        // TODO: read the file, construct StudentData and put into studentList
        // declaring parts that will be added to studentList
        String firstName;
        String lastName;
        String id;
        Double grade;
        String line;

        // Scanner to read student.txt
        Scanner sc = new Scanner(f);
        try {
            while (sc.hasNext()) {
                line = sc.nextLine();
                // splits line into 4 parts
                String parts[] = line.split("\\s+");
                // reassign each split part
                firstName = parts[0];
                lastName = parts[1];
                id = parts[2];
                grade = Double.parseDouble(parts[3]);
                // recombine first name and last name
                String name = firstName + " " + lastName;
                // add data into studentList with assigned split parts
                studentList.add(new StudentData(name, id, grade));
            }
        }
        //Catches invalid input so that code doesn't break
        catch (Exception e){
            System.out.println("Invalid input detected");
        }

    }


    public void PrintList() {
        for(StudentData d: studentList) {
            System.out.println(d);
        }
    }

    public void SortList(Comparator<StudentData> comp) {
        Collections.sort(studentList, comp);
    }

    public void SearchAndPrintEntry(StudentData toFind, Comparator<StudentData> comp) {
        int index = Collections.binarySearch(studentList, toFind, comp);

        if(index >= 0) {
            System.out.println(studentList.get(index));
        } else {
            System.out.println("(hmm, no such student!)");
        }
    }
}
