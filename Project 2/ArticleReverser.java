/*
 * CS211 Chapter 10 - ArticleReverser.java
 * Jason Sy, 10/13/2021, Fall 2021
 *
 * Program reads and prints out line from txt file and reverses the txt and prints again.
 */


// CS 211 HW 2
// Article Reverser
//   Reverse the lines of the input article.
//   For each line, the words should also be reversed.
//
//   For example, if your article has two lines:
//
//     This is line 1.
//     And, this is line 2.
//
//   The "reversed" should print as:
//
//     2. line is this And,
//     1. line is This
//
//   Please use ArrayList to help you.
//


import java.io.*;
import java.util.*;

public class ArticleReverser {

    public static void main(String[] args)  throws FileNotFoundException {
        // TODO: change path to match where your input file is located
        File f = new File("C:/new/HW2_sample_input.txt");

        ArticleReverser r = new ArticleReverser();
        r.readLines(f);

        System.out.println("--- the Original article ---");
        r.print();

        System.out.println("\n--- now Reversed ---");
        r.reversePrint();
    }

    private List<List<String>> lines = new ArrayList<List<String>>();

    public void readLines(File inputFile) throws FileNotFoundException {
        // TODO: read input file, put into the above ArrayList
        Scanner input = new Scanner(inputFile);
        while (input.hasNextLine()){
            String line = input.nextLine();
            List<String> list = Arrays.asList(line.split(" "));
            lines.add(list);
        }
        //Reads input from input text
    }

    public void print() {
        // TODO: print the original article
        for(List<String> list : lines){
            for(String word : list){
                System.out.print(word + " ");
            }
            System.out.println();
        }
        //Prints input from text
    }

    public void reversePrint() {
        // TODO: print with lines reversed, and each line with words reversed
        Collections.reverse(lines);
        for(List<String> list : lines){
            for(int i = list.size() - 1; i >= 0; i--){
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
        //Prints reversed line from text
    }
}
