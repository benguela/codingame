import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 * ---
 * Hint: You can use the debug stream to print initialTX and initialTY, if Thor seems not follow your orders.
 **/
class Player {

    static int TX = 0;
    static int TY = 0;



    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int lightX = in.nextInt(); // the X position of the light of power
        int lightY = in.nextInt(); // the Y position of the light of power
        int initialTx = in.nextInt(); // Thor's starting X position
        int initialTy = in.nextInt(); // Thor's starting Y position

        TX = initialTx;
        TY = initialTy;

        // game loop
        while (true) {
            int remainingTurns = in.nextInt(); // The remaining amount of turns Thor can move. Do not remove this line.

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            int xDiff = TX - lightX;
            int yDiff = TY - lightY;

            int dX = 0;
            int dY = 0;

            if (xDiff != 0)    
              dX = xDiff/Math.abs(xDiff);

            if (yDiff != 0)
              dY = yDiff/Math.abs(yDiff);

            String direction = "Z";

            if (dX == 0 && dY == -1 ) {
                direction = "S";
                TY++;
            } else if (dX == 0 && dY == 1) {
                direction = "N";
                TY--;
            } else if (dY == 0 && dX == -1) {
                direction = "E";
                TX++;          
            } else if (dY == 0 && dX == 1) {
                direction = "W";
                TX--;
            } else if (dX == -1 && dY == -1) {
                direction = "SE";
                TX++;
                TY++;
            } else if (dX == -1 && dY == 1) {
                direction = "NE";
                TX++;
                TY--;
            } else if (dX == 1 && dY == 1) {
                direction = "NW";
                TX--;
                TY--;
            } else {
                direction = "SW";
                TX--;
                TY++;
            }
            
        

            // A single line providing the move to be made: N NE E SE S SW W or NW
            System.out.println(direction);
        }
    }
}