/*
 * CS211 Chapter 11 - AnagramFinder.java
 * Jason Sy, 10/20/2021, Fall 2021
 *
 * Takes input and prints out anagrams from dictionary text file
 */


// CS 211 HW 3
// Anagram Finder
//   Try to find the anagrams in the given dictionary for a given input word.
//
//   For example, if your input is "Silent", the dictionary contains the following
//   anagrams for it: "listen", "silent", "tinsel".
//

import java.io.*;
import java.util.*;

public class AnagramFinder {
    public static void main(String[] args) throws FileNotFoundException {
        String[] originals = new String[] {
            "realfun",
            "mias",
            "EVIL",
            "unable",
            "Silent",
            "AliBaba",
        };

        for(String original: originals) {
            LetterInventory inv = new LetterInventory(original);
            System.out.println("Original: " + original + ", Canonical: " + inv.getCanonical());
        }

        System.out.println("\n");

        // TODO: change path to match where your input file is located
        File f = new File("/sample_dict.txt");

        AnagramFinder finder = new AnagramFinder(f);

        for(String original: originals) {
            finder.printAnagrams(original);
        }
    }

    ArrayList<String> d = new ArrayList<String>(); // stores word of dictionary

    public AnagramFinder(File f) throws FileNotFoundException {
        // TODO: implement
        Scanner sc = new Scanner(f); // constructor takes dictionary
        while (sc.hasNextLine()) {
            d.add(sc.nextLine()); // add words to array
        }
    }


    // takes word input and prints out anagrams
    public void printAnagrams(String word) {
        // TODO: implement
        Map<String, String> map = new HashMap<>(); // builds map
        for (int i = 0; i < d.size(); i++) {
            ArrayList<String> anagramList = new ArrayList<String>(); // store anagram of given word in array
            for (String s : d) {
                if (!(d.get(i)).equals(s)) {
                    char[] k = (d.get(i)).toCharArray();
                    char[] l = s.toCharArray();
                    for (char[] chars : Arrays.asList(k, l)) {
                        Arrays.sort(chars);
                    }
                    int c = 0;
                    if (k.length == l.length) {
                        for (int j = 0; j < k.length; j++) {
                            if (k[j] == l[j])
                                c++;
                        }
                    }
                    if (c == k.length) {
                        anagramList.add(s);
                    }
                }
            }
            anagramList.add(d.get(i));
            LetterInventory inve = new LetterInventory(d.get(i));
            // remove brackets
            String list = anagramList.toString().replace("[", "").replace("]", ".");
            map.put(inve.getCanonical(), list);
        }
        LetterInventory obj = new LetterInventory(word);
        if (map.get(obj.getCanonical()) == null) {
            System.out.println("Your input is: " + word + ". " + "Sorry, didn't find any anagrams.");
        } else {
            System.out.println("Your input is: " + word + ". " + "Found anagrams: " + map.get(obj.getCanonical()));
        }
    }
    
    
    // takes case where input word is same as word inside dictionary and doesn't print the word as anagram
    public void printAnagrams2(String word) {
        // Extra Credit: optional to implement
        Map<String, String> map = new HashMap<>(); // builds map
        for (int i = 0; i < d.size(); i++) {
            ArrayList<String> anagramList = new ArrayList<String>(); // store anagram of given word in array
            for (String s : d) {
                if (!(d.get(i)).equals(s)) {
                    char[] k = (d.get(i)).toCharArray();
                    char[] l = s.toCharArray();
                    for (char[] chars : Arrays.asList(k, l)) {
                        Arrays.sort(chars);
                    }
                    int c = 0;
                    if (k.length == l.length) {
                        for (int j = 0; j < k.length; j++) {
                            if (k[j] == l[j])
                                c++;
                        }
                    }
                    if (c == k.length) {
                        anagramList.add(s);
                    }
                }
            }
            anagramList.add(d.get(i));
            LetterInventory inve = new LetterInventory(d.get(i));
            // for formatting and removal of input from printing out as anagram
            String list1 = anagramList.toString().replace("[", "").replace("]", ".");
            String list2 = list1.replace(word.toLowerCase() + "," + " ", "");
            String list3 = list2.replace(", " + word.toLowerCase() +".", ".");
            map.put(inve.getCanonical(), list3);
        }
        LetterInventory obj = new LetterInventory(word);
        if (map.get(obj.getCanonical()) == null) {
            System.out.println("Your input is: " + word + ". " + "Sorry, didn't find any anagrams.");
        } else {
            System.out.println("Your input is: " + word + ". " + "Found anagrams: " + map.get(obj.getCanonical()));
        }
    }

}
