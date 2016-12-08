package day6;

import java.util.HashMap;

/**
 * Created by oisin on 12/8/16.
 */
public class Part1 extends Part {
    String process(String[] commands) {
        String corrected = "";
        for(int column = 0; column < commands[0].length(); column++) {
            HashMap<String, Integer> frequency = new HashMap<>();
            int mostPopular = -1;
            char mostPopularCharacter='-';
            for(String command : commands) {
                String key = ""+command.charAt(column);
                if(frequency.containsKey(key)) {
                    frequency.put(key, frequency.get(key) + 1);
                } else {
                    frequency.put(key, 1);
                }
                if(frequency.get(key) > mostPopular) {
                    mostPopular = frequency.get(key);
                    mostPopularCharacter = command.charAt(column);
                }
            }
            corrected += mostPopularCharacter;
        }
        return corrected;
    }
}
