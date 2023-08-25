/*
 * CS211 Chapter 11 - LetterInventory.java
 * Jason Sy, 10/20/2021, Fall 2021
 *
 * Takes input word and computes canonical form.
 */


// CS 211 HW 3
// LetterInventory takes an input word and computes its canonical form, which is
//   all the letters in a sorted order, and all lower cases.
//
//   For example, for the input word "AliBaba",
//   the canonical form should be "aaabbil"
//
// You can assume the input contains only valid letters (no punctuation or blanks)
//

import java.util.*;



public class LetterInventory {

    private String input;

    public LetterInventory(String input) {
        // TODO: implement
        this.input = input; //takes String input word
    }

    public String getCanonical() {
        // TODO: implement
        String input_lower = input.toLowerCase();
        char[] word = input_lower.toCharArray();
        Arrays.sort(word);
        return new String(word); //returns canonical sorted letter form from input word
    }


}
