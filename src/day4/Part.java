package day4;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;

/**
 * Created by oisin on 12/4/16.
 */
public abstract class Part {
    public Command convertToCommand(String com) {
        Pattern pattern = Pattern.compile("(([a-z]+-){1,})(\\d+)\\[(.*)\\]");
        Matcher m = pattern.matcher(com);
        if(m.matches()) {
            String name = m.group(1);
            int id = Integer.parseInt(m.group(3));
            char[] claimedPopular = m.group(4).toCharArray();

            HashMap<Character, Integer> popularity = new HashMap<>();
            Set<Character> set = new HashSet();
            for(char c : name.replaceAll("-", "").toCharArray()) {
                set.add(c);
                if(popularity.containsKey(c)) {
                    popularity.put(c, popularity.get(c) + 1);
                } else {
                    popularity.put(c, 1);
                }
            }

            Character[] c = set.toArray(new Character[set.size()]);
            Arrays.sort(c, new Comparator<Character>() {
                @Override
                public int compare(Character c1, Character c2) {
                    if(popularity.get(c1) == popularity.get(c2)) {
                        return Character.compare(c1, c2);
                    }
                    return Integer.compare(popularity.get(c2), popularity.get(c1));
                }
            });

            char c2[] = new char[c.length];
            for(int i = 0;i<c2.length;i++) {
                c2[i] = c[i];
            }

            return new Command(claimedPopular, c2, id, name);

        }
        return null;
    }
    public boolean isValid(Command command) {
        for(int i = 0;i < 5; i++) {
            if(command.claimedPopular[i] != command.actualPopular[i]) return false;
        }
        return true;
    }

    abstract String process(String[] commands);

}

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