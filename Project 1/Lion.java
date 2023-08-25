/**
 *
 * @author zubinwang
 */
import java.awt.*;
import java.util.*;

public class Lion extends Critter {

    private int count;
    private Color initialColor;
    private Random rand = new Random();


    public Lion() {
        //Constructor to track steps(1, 2, 3)
        this.count = 0;
    }


    public Action getMove(CritterInfo info) {
        /*
            if enemy in front will infect
            if wall in front or to right will turn left
            otherwise hop
         */
        this.count++;
        if(info.getFront() == Neighbor.OTHER){
            return Action.INFECT;
        }
        else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL){
            return Action.LEFT;
        }
        else if(info.getFront() == Neighbor.SAME){
            return Action.RIGHT;
        }
        else{
            return Action.HOP;
        }

    }

    public Color getColor() {
        /*
            Randomly picks between Red, Green, Blue to represent lion
            Uses color for three moves, then randomly picks another and repeat
         */
        if (this.count % 3 == 0) {
            int c = 0;
            while (c == 0){
                int i = this.rand.nextInt(3);
                if (i == 0 && this.initialColor != Color.RED){
                    this.initialColor = Color.RED;
                    c++;
                }
                if (i == 1 && this.initialColor != Color.GREEN){
                    this.initialColor = Color.GREEN;
                    c++;
                }
                if (i == 2 && this.initialColor != Color.BLUE){
                    this.initialColor = Color.BLUE;
                    c++;
                }
            }
        }
        return this.initialColor;

    }

    public String toString() {
        //Lion shows up as "L" in simulation
        return "L";
    }
}

