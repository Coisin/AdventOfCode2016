package day1;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by oisin on 12/6/16.
 */
public abstract class Part {

    static final int north = 0, east = 1, south = 2, west = 3;
    int currentDirection = 0;

    int distanceX = 0, distanceY = 0;
    static int firstSecondX = -1, firstSecondY = -1;
    ArrayList<Point> visited = new ArrayList<>();

    // Update Direction by given amount, and cycles it where necessary
    public void rotate(int amount, int steps) {
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
        if(contains(distanceX, distanceY) && firstSecondX == -1) {
            firstSecondX = distanceX;
            firstSecondY = distanceY;
        }
        visited.add(new Point(distanceX, distanceY));
    }

    public boolean contains(int x, int y) {
        for(Point point : visited) {
            if(point.x == x && point.y == y) {
                return true;
            }
        }
        return false;
    }

    abstract String process(String input);
}