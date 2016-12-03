package day2;

import java.util.ArrayList;

/**
 * Created by oisin on 12/3/16.
 */
public class Part1 extends Part{
    public Part1() {
        dialPad = new char[][] {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
        currentColumn = currentRow = 1;
    }

    public boolean isPossibleMove(int changeX, int changeY) {
        int newX = currentColumn + changeX;
        int newY = currentRow + changeY;

        if(newX == -1 || newX == 3) return false;
        if(newY == -1 || newY == 3) return false;

        return true;
    }
}
