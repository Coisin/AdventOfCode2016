package day1;

/**
 * Created by oisin on 12/3/16.
 */
public class Day1 {

    static final int north = 0, east = 1, south = 2, west = 3;
    static int currentDirection = 0;

    static int distanceX = 0, distanceY = 0;

    static final String input = "R4, R4, L1, R3, L5, R2, R5, R1, L4, R3, L5, R2, L3, L4, L3, R1, R5, R1, L3, L1, R3, L1, R2, R2, L2, R5, L3, L4, R4, R4, R2, L4, L1, R5, L1, L4, R4, L1, R1, L2, R5, L2, L3, R2, R1, L194, R2, L4, R49, R1, R3, L5, L4, L1, R4, R2, R1, L5, R3, L5, L4, R4, R4, L2, L3, R78, L5, R4, R191, R4, R3, R1, L2, R1, R3, L1, R3, R4, R2, L2, R1, R4, L5, R2, L2, L4, L2, R1, R2, L3, R5, R2, L3, L3, R3, L1, L1, R5, L4, L4, L2, R5, R1, R4, L3, L5, L4, R5, L4, R5, R4, L3, L2, L5, R4, R3, L3, R1, L5, R5, R1, L3, R2, L5, R5, L3, R1, R4, L5, R4, R2, R3, L4, L5, R3, R4, L5, L5, R4, L4, L4, R1, R5, R3, L1, L4, L3, L4, R1, L5, L1, R2, R2, R4, R4, L5, R4, R1, L1, L1, L3, L5, L2, R4, L3, L5, L4, L1, R3";

    // Update Direction by given amount, and cycles it where necessary
    public static void rotate(int amount, int steps) {
        currentDirection += amount;
        if(currentDirection == 4)currentDirection = 0;
        else if(currentDirection == -1)currentDirection = 3;

        //Update Distance on X and Y axis
        switch (currentDirection) {
            case 0:
                distanceY -= steps;
                break;
            case 1:
                distanceX += steps;
                break;
            case 2:
                distanceY += steps;
                break;
            case 3:
                distanceX -= steps;
                break;
        }

    }

    public static void main(String args[]) {
        String[] requests = input.split(", ");
        for(String request:requests) {
            int amount = request.charAt(0) == 'L' ? -1 : 1;
            int steps = Integer.parseInt(request.substring(1));
            rotate(amount, steps);
        }
        System.out.println(Math.abs(distanceX) + Math.abs(distanceY));
    }

}
