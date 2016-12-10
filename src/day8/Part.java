package day8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by oisin on 12/9/16.
 */
public abstract class Part {
    String rotateRowPattern = "rotate row y=(.*?) by (.*?)";
    String rotateColumnPattern = "rotate column x=(.*?) by (.*?)";
    String lightPattern = "rect (.*?)x(.*?)";

    static boolean[][] screen = new boolean[6][50];

    public boolean[][] copyScreen() {
        boolean[][] newScreen = new boolean[screen.length][screen[0].length];
        for(int y = 0; y < screen.length; y++)
            for(int x = 0; x < screen[y].length; x++)
                newScreen[y][x] = screen[y][x];
        return newScreen;
    }
    public void light(int width, int height) {
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                screen[y][x] = true;
            }
        }
    }
    public void rotateRow(int y, int change) {
        boolean[][] screen = copyScreen();
        for(int x = 0; x < screen[y].length; x++) {
            int newIndex = x + change;
            if(newIndex >= screen[y].length) {
                newIndex -= screen[y].length;
            }
            screen[y][newIndex] = this.screen[y][x];
        }
        this.screen = screen;
    }
    public void rotateColumn(int x, int change) {
        boolean[][] screen = copyScreen();
        for(int y = 0; y < screen.length; y++) {
            int newIndex = y + change;
            if(newIndex >= screen.length) {
                newIndex -= screen.length;
            }
            screen[newIndex][x] = this.screen[y][x];
        }
        this.screen = screen;
    }
    void processCommand(String command) {
        Matcher matcher;
        if((matcher = matchesPattnern(lightPattern, command)) != null) {
            light(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
        } else if((matcher = matchesPattnern(rotateColumnPattern, command)) != null) {
            rotateColumn(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
        } else if((matcher = matchesPattnern(rotateRowPattern, command)) != null) {
            rotateRow(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
        }
    }

    int getNumberLit() {
        int numberLit = 0;
        for(int y = 0; y < screen.length; y++)
            for(int x = 0; x < screen[y].length; x++)
                if(screen[y][x]) numberLit++;
        return numberLit;
    }

    Matcher matchesPattnern(String expression, String subject) {
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(subject);
        if(matcher.matches()) return  matcher;
        return null;
    }

    abstract String process(String[] commands);
}
