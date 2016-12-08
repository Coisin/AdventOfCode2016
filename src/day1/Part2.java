package day1;

/**
 * Created by oisin on 12/6/16.
 */
public class Part2 extends Part {
    String process(String input) {
        return Integer.toString(Math.abs(firstSecondX) + Math.abs(firstSecondY));
    }
}
