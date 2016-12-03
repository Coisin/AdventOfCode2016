package day3;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by oisin on 12/3/16.
 */
public abstract class Part {
    public String process(String[] commands) {
        int numberValid = 0;

        int[][] triangles = getTriangles(commands);
        for(int[] triangle : triangles) {
            if(isValid(triangle[0], triangle[1], triangle[2])) {
                numberValid++;
            }
        }

        return Integer.toString(numberValid);
    }

    public boolean isValid(int sideA, int sideB, int sideC) {
        int sides[] = {sideA, sideB, sideC};
        Arrays.sort(sides);
        if(sides[0] + sides[1] <= sides[2]) return false;
        return true;
    }

    abstract int[][] getTriangles(String[] commands);
}
