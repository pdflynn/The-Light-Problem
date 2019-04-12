package com.pdanielflynn.numberedlights;

/**
 * This was actually a program I wrote to help solve a puzzle. Originally, I
 * just wrote it with Java arrays to solve the problem, but then I later added a
 * GUI in and scrapped this part. The puzzles goeslike this: There are 100
 * lights in a hallway, each with their own switch. On
 * the first day, all of the lights are off. On the second day, someone comes
 * along and flips the switch of lights whose numbers are divisible by 2. The
 * second day, someone flips the switch for lights with numbers divisible by 3,
 * on the fourth day the same and so on until the 100th day. The question is: On
 * the 100th day, which lights will be off and which lights will be on? This
 * program attempts to solve it.
 * 
 * 
 * @author Danny Flynn
 * @version 2019.04.11
 *
 */
public class NumberedLights {

    private static Boolean[] lights = new Boolean[101];


    /**
     * Main method that initializes the GUI by creating a new Display()
     * 
     * @param args
     *            Unused
     */
    public static void main(String[] args) {

        Display dsp = new Display();

    }


    /**
     * Method to do this the non-visually way, if you so desire.
     */
    public void doItTheOldWay() {
        for (int i = 1; i <= 100; i++) {
            lights[i] = true;
        }

        int numDays = 100;

        for (int i = 1; i <= numDays; i++) {
            executeDay(i);
        }

        printLights();
    }


    /**
     * Iterate through the array and denote which lights are on and which are
     * off
     */
    public static void printLights() {
        for (int i = 1; i <= 100; i++) {
            System.out.print("Light " + i + ": ");
            if (lights[i]) {
                System.out.println("On");
            }
            else {
                System.out.println("Off");
            }
        }
    }


    /**
     * Execute the light-flipping for day n
     * 
     * @param n
     *            The number of the day to perform
     */
    public static void executeDay(int n) {
        for (int i = 1; i <= 100; i++) {
            if ((i % n) == 0) {
                swap(i);
            }
        }
    }


    /**
     * Flip the switch of light i
     * 
     * @param i
     *            The number of the light to switch
     */
    public static void swap(int i) {
        lights[i] = !lights[i];
    }

}
