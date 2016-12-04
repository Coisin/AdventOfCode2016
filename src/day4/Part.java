package day4;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;

/**
 * Created by oisin on 12/4/16.
 */
public abstract class Part {

    // Parses input line, and returns a Command object representing this
    public Command convertToCommand(String com) {
        Pattern pattern = Pattern.compile("(([a-z]+-){1,})(\\d+)\\[(.*)\\]");
        Matcher m = pattern.matcher(com);
        if(m.matches()) {
            String name = m.group(1);
            int id = Integer.parseInt(m.group(3));
            char[] claimedPopular = m.group(4).toCharArray();

            // Map for storing frequency of characters in name
            HashMap<Character, Integer> popularity = new HashMap<>();
            // Set for keeping only one occurrence of each Character
            Set<Character> set = new HashSet();
            for(char c : name.replaceAll("-", "").toCharArray()) {
                set.add(c);
                if(popularity.containsKey(c)) {
                    popularity.put(c, popularity.get(c) + 1);
                } else {
                    popularity.put(c, 1);
                }
            }

            Character[] uniqueCharacters = set.toArray(new Character[set.size()]);

            // Sorts uniqueCharacters array, based on frequency(Using the popularity HashMap), and then alphabetically
            Arrays.sort(uniqueCharacters, new Comparator<Character>() {
                @Override
                public int compare(Character c1, Character c2) {
                    if(popularity.get(c1) == popularity.get(c2)) {
                        return Character.compare(c1, c2);
                    }
                    return Integer.compare(popularity.get(c2), popularity.get(c1));
                }
            });

            // Convert from "Character" array, to primitive "char" array;
            char c2[] = new char[uniqueCharacters.length];
            for(int i = 0;i<c2.length;i++) {
                c2[i] = uniqueCharacters[i];
            }

            return new Command(claimedPopular, c2, id, name);

        }
        return null;
    }

    // Asserts that the input's most popular characters are in fact the most popular
    public boolean isValid(Command command) {
        for(int i = 0;i < 5; i++) {
            if(command.claimedPopular[i] != command.actualPopular[i]) return false;
        }
        return true;
    }

    abstract String process(String[] commands);

}

//Data Structure for holding data on each room
class Command {
    public char[] claimedPopular, actualPopular;
    String name;
    int id;
    public Command(char[] cp, char[] ac, int id, String name) {
        claimedPopular = cp;
        actualPopular = ac;
        this.id = id;
        this.name = name;
    }
}