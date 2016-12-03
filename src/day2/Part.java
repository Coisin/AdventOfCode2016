package day2;

import java.util.ArrayList;

/**
 * Created by oisin on 12/3/16.
 */
public abstract class Part {
    ArrayList<Character> key = new ArrayList<>();
    char[][] dialPad;
    int currentRow, currentColumn;

    void move(char direction) {
        int changeX = 0, changeY = 0;
        switch (direction) {
            case 'U':
                changeY -= 1;
                break;
            case 'D':
                changeY += 1;
                break;
            case 'L':
                changeX -= 1;
                break;
            case 'R':
                changeX += 1;
                break;
        }
        if(isPossibleMove(changeX, changeY)) {
            currentColumn += changeX;
            currentRow += changeY;
        }
    }

    public String process(String[] commands) {
        String keyAsString = "";
        for(String inputLine : commands) {
            for(char command : inputLine.toCharArray()) {
                move(command);
            }
            key.add(dialPad[currentRow][currentColumn]);
        }
        for(char digit:key) {
            keyAsString += digit;
        }
        return keyAsString;
    }

    abstract boolean isPossibleMove(int changeX, int changeY);
}
