package day2;

/**
 * Created by oisin on 12/3/16.
 */
public class Part2 extends Part {
    public Part2() {
        dialPad = new char[][] {{'-', '-', '1', '-', '-'},{'-', '2', '3', '4', '-'}, {'5', '6', '7', '8', '9'}, {'-', 'A', 'B', 'C', '-'}, {'-', '-', 'D', '-', '-'}};
        currentColumn = 0;
        currentRow = 2;
    }

    public boolean isPossibleMove(int changeX, int changeY) {
        int newX = currentColumn + changeX;
        int newY = currentRow + changeY;

        if(newX == -1 || newX == 5) return false;
        if(newY == -1 || newY == 5) return false;

        char digit = dialPad[newY][newX];
        return digit != '-';
    }
}
