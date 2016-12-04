package day4;

/**
 * Created by oisin on 12/4/16.
 */
public class Part1 extends Part {
    public String process(String[] commands) {
        int sumOfIds = 0;
        for(String c : commands) {
            Command command = convertToCommand(c);
            if(isValid(command)) {
                sumOfIds += command.id;
            }
        }

        return Integer.toString(sumOfIds);
    }
}
