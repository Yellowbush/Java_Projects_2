// You need to implement AssassinManager

import java.util.*;

public class AssassinManager {
    // the head of the kill ring linked list
    private AssassinNode killRingHead = null;

    // the head of the grave yard linked list
    private AssassinNode graveYardHead = null;

    public AssassinManager(List<String> names) {
        // TODO: constructor builds the kill ring from input names, keep the same order as the input list!
        if (!names.isEmpty()) { // list not empty
            // add names in order
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
        } else { // empty list
            throw new IllegalArgumentException("No names");
        }

    }

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

    public void printGraveyard() {
        // TODO: pring grave yard
        AssassinNode current = graveYardHead;
        while (current != null) {
            System.out.println("    " + current.name + " was killed by " + current.killer);
            current = current.next;
        }
    }

    public boolean killRingContains(String name) {
        // TODO: whether the given name is in the current kill ring
        AssassinNode current = killRingHead;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean graveyardContains(String name) {
        // TODO: whether the given name is in the grave yard
        AssassinNode current = graveYardHead;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) {  // given name in current kill ring
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean gameOver() {
        // TODO: whether the game is over
        if(killRingHead.next == null){  // if one person left
            return true;
        }
        else {
            return false;
        }
    }

    public String winner() {
        // TODO: then name of the winner, if game is over
        if(!gameOver()){    // null if game not over
            return null;
        }
        // name of winner
        return killRingHead.name;
    }

    public void kill(String name) {
        // TODO: kill the person with the given name, transferring the person from the kill ring to the graveyard.
        AssassinNode current = killRingHead;
        AssassinNode last = null;

        // if name does not equal
        if (current.name.equalsIgnoreCase(name)) { // victim front of kill ring.
            last = current;
            while(current.next != null) {
                current = current.next;
            }
            killRingHead = killRingHead.next;
        } else { // victim not front of kill ring
            while (!current.next.name.equalsIgnoreCase(name)) {
                current = current.next;
            }
            last = current.next;
            current.next = current.next.next;
        }
        // LinkedList -> killer, victim, next on list.
        last.killer = current.name;
        last.next = graveYardHead;
        graveYardHead = last;
    }
}
