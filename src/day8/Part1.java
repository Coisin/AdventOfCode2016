package day8;

/**
 * Created by oisin on 12/9/16.
 */
public class Part1 extends Part {
    String process(String[] commands) {
        for(String command : commands) {
            processCommand(command);
        }
        return Integer.toString(getNumberLit());
    }
}