// You need to implement this

import java.awt.*;

public class Giant extends Critter {

    private String[] giantName = {"fee", "fie", "foe", "fum"};
    private int count;
    private int name;
    
    public Giant() {
        //Constructor to track steps to 6
        this.count = 0;
    }

    public Action getMove(CritterInfo info) {
        /*
            if enemy in front will infect
            will hop if possible
            otherwise turn right
         */
        this.count++;
        if(info.getFront() == Neighbor.OTHER){
            return Action.INFECT;
        }
        else if(info.getFront() == Neighbor.EMPTY){
            return Action.HOP;
        }
        else{
            return Action.RIGHT;
        }

    }

    public Color getColor() {
        //Gray color to represent giant
        return Color.GRAY;
    }

    public String toString() {
        /*
            For every 6 steps string representing giant changes in simulation
            in order from "fee" -> "fie" -> "foe" -> "fum" then repeats
         */
        if(this.count == 6){
            this.count = 0;
            if(this.name == 3){
                this.name = 0;
            }
            else {
                this.name++;
            }
        }
        return this.giantName[this.name];
    }    
}
