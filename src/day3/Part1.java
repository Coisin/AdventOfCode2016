package day3;

import java.util.Arrays;

/**
 * Created by oisin on 12/3/16.
 */
public class Part1 extends Part {
    public int[][] getTriangles(String[] commands) {
        int[][] triangles = new int[commands.length][3];
        for(int triangleIndex = 0; triangleIndex < commands.length; triangleIndex++) {
            String command = commands[triangleIndex];
            String[] numbersAsStrings = command.split(" ");

            int sideA = Integer.parseInt(numbersAsStrings[0]);
            int sideB = Integer.parseInt(numbersAsStrings[1]);
            int sideC = Integer.parseInt(numbersAsStrings[2]);

            triangles[triangleIndex][0] = sideA;
            triangles[triangleIndex][1] = sideB;
            triangles[triangleIndex][2] = sideC;
        }
        return triangles;
    }
}
