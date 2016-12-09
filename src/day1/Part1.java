package day1;

/**
 * Created by oisin on 12/6/16.
 */
public class Part1 extends Part {
    String process(String[] commands) {
        for(String request:commands) {
            int amount = request.charAt(0) == 'L' ? -1 : 1;
            int steps = Integer.parseInt(request.substring(1));
            rotate(amount, steps);
        }
        return Integer.toString(Math.abs(distanceX) + Math.abs(distanceY));
    }
}
