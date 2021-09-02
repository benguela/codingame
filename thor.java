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

    static int thorX = 0;
    static int thorY = 0;

    static final double delta = Math.PI / 8;
    static final double S = 0;
    static final double SSE = delta;
    static final double SE = Math.PI / 4;
    static final double ESE = SE + delta;
    static final double E = Math.PI / 2;
    static final double ENE = E + delta;
    static final double NE = 3 * Math.PI / 4;
    static final double NNE = NE + delta;
    static final double N = Math.PI;
    static final double NNW = N + delta;
    static final double NW = 5 * Math.PI / 4;
    static final double WNW = NW + delta;
    static final double W = 3 * Math.PI / 2;
    static final double WSW = W + delta;
    static final double SW = 7 * Math.PI / 4;
    static final double SSW = SW + delta;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int lightX = in.nextInt(); // the X position of the light of power
        int lightY = in.nextInt(); // the Y position of the light of power
        int initialTx = in.nextInt(); // Thor's starting X position
        int initialTy = in.nextInt(); // Thor's starting Y position

        thorX = initialTx;
        thorY = initialTy;

        // game loop
        while (true) {
            int remainingTurns = in.nextInt(); // The remaining amount of turns Thor can move. Do not remove this line.

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            int xDiff = lightX - thorX;
            int yDiff = lightY - thorY;

            double theta = Math.atan2(xDiff,yDiff);
            System.err.println("xDiff is "+xDiff);
            System.err.println("yDiff is "+yDiff);
            System.err.println("theta is "+theta);

            String direction = "";

            if (theta < 0) {
                theta = theta + 2*Math.PI; 
                System.err.println("theta is "+theta);
            }
             
            if ((0 <= theta && theta < SSE) || (SSW <= theta && theta <= Math.PI)) {
                direction = "S";
                thorY++;
            } else if (SSE <= theta && theta < ESE) {
                direction = "SE";
                thorX++;
                thorY++;
                if (thorX > 39) {
                    direction = "S";
                    thorX--;
                }
                if (thorY > 17) {
                    direction = "E";
                    thorY--;
                }
            } else if (ESE <= theta && theta < ENE) {
                direction = "E";
                thorX++;
            } else if (ENE <= theta && theta < NNE) {
                direction = "NE";
                thorY--;
                thorX++;
                if (thorX > 39) {
                    direction = "N";
                    thorX--;
                }
                if (thorY < 0) {
                    direction = "E";
                    thorY++;
                }
            } else if (NNE <= theta && theta < NNW) {
                direction = "N";
                thorY--;
            } else if (NNW <= theta && theta < WNW) {
                direction = "NW";
                thorY--;
                thorX--;
                if (thorX < 0) {
                    direction = "N";
                    thorX++;
                }
                if (thorY < 0) {
                    direction = "W";
                    thorY++;
                }
            } else if (WNW <= theta && theta < WSW) {
                direction = "W";
                thorX--;
            } else {
                direction = "SW";
                thorX--;
                thorY++;
                if (thorX < 0) {
                    direction = "S";
                    thorX++;
                }
                if (thorY > 17) {
                    direction = "W";
                    thorY--;
                }
            }

            


            // A single line providing the move to be made: N NE E SE S SW W or NW
            System.out.println(direction);
        }
    }
}