// You need to implement this

import java.awt.*;

public class Bear extends Critter {

    private int count;
    private boolean polar;


    public Bear(boolean polar) {
        //Constructor
        this.count = 0;
        this.polar = polar;
    }
    
    public Critter.Action getMove(CritterInfo info) {
        /*
            if enemy in front will infect
            will hop if possible
            otherwise turn left
         */
        if(info.getFront() == Neighbor.OTHER){
            return Action.INFECT;
        }
        else if (info.getFront() == Neighbor.EMPTY){
            return Action.HOP;
        }
        else {
            return Action.LEFT;
        }

    }

    public Color getColor() {
        /*
            When true will be white to represent polar bear
            if false will be black to represent not polar bear
         */

        if(this.polar){
            return Color.WHITE;
        }
        else{
            return Color.BLACK;
        }
    }

    public String toString() {
        //Slash and backslash string to represent bear and alternates each step
        this.count = this.count + 1;
        if(this.count % 2 == 1){
            return "/";
        }
        else{
            return "\\";
        }
    }
}
