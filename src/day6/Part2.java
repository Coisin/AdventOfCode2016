package day6;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by oisin on 12/8/16.
 */
public class Part2 extends Part {
    String process(String[] commands) {
        String corrected = "";

        for(int column = 0; column < commands[0].length(); column++) {
            HashMap<String, Integer> frequency = new HashMap<>();
            ArrayList<String> characters = new ArrayList<>();
            for(String command : commands) {
                String key = ""+command.charAt(column);
                if(frequency.containsKey(key)) {
                    frequency.put(key, frequency.get(key) + 1);
                } else {
                    frequency.put(key, 1);
                    characters.add(key);
                }
            }
            int leastPopularIndex = commands.length + 1;
            String leastPopularCharacter = "-";
            for(String character : characters) {
                if(frequency.get(character) < leastPopularIndex) {
                    leastPopularIndex = frequency.get(character);
                    leastPopularCharacter = character;
                }
            }
            corrected += leastPopularCharacter;
        }

        return corrected;
    }
}
