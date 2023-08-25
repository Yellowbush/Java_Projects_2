/*
 * CS211 Chapter 12 - SierpinskiCarpet.java
 * Jason Sy, 10/25/2021, Fall 2021
 *
 * Creates recursive pattern of squares in a 3 by 3 grid.
 */

// CS 211 HW 4
// Draw the Sierpinski carpet

import java.awt.Color;
import java.awt.Graphics;

public class SierpinskiCarpet {
    public static void main(String[] args) {
        SierpinskiCarpet t = new SierpinskiCarpet(729, 729);
        t.draw(6);
    }

    private Graphics g;
    private int totalWidth, totalHeight;

    public SierpinskiCarpet(int totalWidth, int totalHeight) {
        this.totalWidth = totalWidth;
        this.totalHeight = totalHeight;

        DrawingPanel panel = new DrawingPanel(totalWidth, totalHeight);
        g = panel.getGraphics();
        g.setColor(Color.BLACK);
    }

    public void draw(int level) {
        drawHelper(level, 0, 0, totalWidth, totalHeight);
    }

    private void drawHelper(int level, int startX, int startY, int width, int height) {
        // TODO: implement the recursive call below

        // useful declarations
        int x = (startX/3 + width/3);
        int y = (startY/3 + height/3);
        int widthTwo = width/3;
        int heightTwo = height/3;
        int widthThree = widthTwo/3;
        int heightThree = heightTwo/3;
        int newX = 0;
        int newY = 0;

        if(level == 1){ // level 1
            g.fillRect(x, y, widthTwo, heightTwo);
        }
        else if(level > 1){ // after level 1 proceeding
            for(int i = 0; i < totalWidth; i++){ // condition
                g.fillRect(x, y, widthTwo, heightTwo); // center
                newX = (widthThree + (i * 3 * (widthThree)));
                for(int j = 0; j < totalHeight; j++){ // condition
                    newY = (heightThree + (j * 3 * (heightThree)));
                    g.fillRect(newX, newY, widthThree, heightThree); // fill
                }
            }
            level--;
            // recursion
            drawHelper(level, newX, newY, widthTwo, heightTwo);
        }
        else return; // level 0
    }

}