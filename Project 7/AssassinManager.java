/*
 * CS211 Chapter 16 - AssassinManager.java
 * Jason Sy, 11/22/2021, Fall 2021
 *
 * Simulates game of assassin and keeps track of the kill ring and graveyard.
 */

// You need to implement AssassinManager

import java.util.*;

public class AssassinManager {
    // the head of the kill ring linked list
    private AssassinNode killRingHead = null;

    // the head of the grave yard linked list
    private AssassinNode graveYardHead = null;


    // assumes given list is not empty and strings are valid
    // adds name in same order in which they appear in the list to form kill ring
    public AssassinManager(List<String> names) {
        // TODO: constructor builds the kill ring from input names, keep the same order as the input list!
        for (String name : names) {
            AssassinNode assassin = new AssassinNode(name);
            if (killRingHead != null) {
                AssassinNode current = killRingHead;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = assassin;
            } else {
                killRingHead = assassin;
            }
        }

    }

    // print names of people in kill ring
    public void printKillRing() {
        // TODO: print kill ring
        AssassinNode current = killRingHead;
        while (current != null) {
            if(current.next == null){
                System.out.println("    " + current.name + " is stalking " + killRingHead.name);
            } else {
                System.out.println("    " + current.name + " is stalking " + current.next.name);
            }
            current = current.next;
        }
    }


    // prints name of people in graveyard in reverse kill order
    public void printGraveyard() {
        // TODO: pring grave yard
        AssassinNode current = graveYardHead;
        while (current != null) {
            System.out.println("    " + current.name + " was killed by " + current.killer);
            current = current.next;
        }
    }

    // returns true if given name is in current kill ring, false otherwise
    public boolean killRingContains(String name) {
        // TODO: whether the given name is in the current kill ring
        AssassinNode current = killRingHead;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) {  // given name is in current kill ring
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // returns true if given name is in graveyard, false otherwise
    public boolean graveyardContains(String name) {
        // TODO: whether the given name is in the grave yard
        AssassinNode current = graveYardHead;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) {  // given name in current graveyard
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // return true if game is over(one person left), false otherwise
    public boolean gameOver() {
        // TODO: whether the game is over
        if(killRingHead.next == null){  // if one person left
            return true;
        } else {
            return false;
        }
    }

    // returns name of winner, if game not over return null.
    public String winner() {
        // TODO: then name of the winner, if game is over
        if(!gameOver()){    // null if game not over
            return null;
        }
        // name of winner
        return killRingHead.name;
    }

    // assumes input name currently exists in kill ring and game is not over yet.
    // records killing of person with given name from kill ring to graveyard.
    public void kill(String name) {
        // TODO: kill the person with the given name, transferring the person from the kill ring to the graveyard.
        AssassinNode current = killRingHead;
        AssassinNode last = null;

        if (!killRingHead.name.equalsIgnoreCase(name)) {    // victim not head of kill ring
            while (!current.next.name.equalsIgnoreCase(name)) {
                current = current.next;
            }
            last = current.next;
            last.killer = current.name;
            current.next = current.next.next;
        } else {                                           // victim head of kill ring
            while (current.next != null) {
                current = current.next;
            }
            last = killRingHead;
            last.killer = current.name;
            killRingHead = killRingHead.next;
        }
        last.next = graveYardHead;
        graveYardHead = last;
    }
}
