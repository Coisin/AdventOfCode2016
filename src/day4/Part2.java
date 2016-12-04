package day4;

import java.util.HashMap;

/**
 * Created by oisin on 12/4/16.
 */
public class Part2 extends Part {

    static HashMap<Character, Integer> alphaIndex = new HashMap<>();
    static HashMap<Integer, Character> indexAlpha = new HashMap<>();

    static {
        alphaIndex.put('a', 1);
        alphaIndex.put('b', 2);
        alphaIndex.put('c', 3);alphaIndex.put('o', 15);
        alphaIndex.put('d', 4);alphaIndex.put('p', 16);
        alphaIndex.put('e', 5);alphaIndex.put('q', 17);
        alphaIndex.put('f', 6);alphaIndex.put('r', 18);
        alphaIndex.put('g', 7);alphaIndex.put('s', 19);
        alphaIndex.put('h', 8);alphaIndex.put('t', 20);
        alphaIndex.put('i', 9);alphaIndex.put('u', 21);
        alphaIndex.put('j', 10);alphaIndex.put('v', 22);
        alphaIndex.put('k', 11);alphaIndex.put('w', 23);
        alphaIndex.put('l', 12);alphaIndex.put('x', 24);
        alphaIndex.put('m', 13);alphaIndex.put('y', 25);
        alphaIndex.put('n', 14);alphaIndex.put('z', 26);

        indexAlpha.put(1, 'a');
        indexAlpha.put(2, 'b');
        indexAlpha.put(3, 'c');indexAlpha.put(15, 'o');
        indexAlpha.put(4, 'd');indexAlpha.put(16, 'p');
        indexAlpha.put(5, 'e');indexAlpha.put(17, 'q');
        indexAlpha.put(6, 'f');indexAlpha.put(18, 'r');
        indexAlpha.put(7, 'g');indexAlpha.put(19, 's');
        indexAlpha.put(8, 'h');indexAlpha.put(20, 't');
        indexAlpha.put(9, 'i');indexAlpha.put(21, 'u');
        indexAlpha.put(10, 'j');indexAlpha.put(22, 'v');
        indexAlpha.put(11, 'k');indexAlpha.put(23, 'w');
        indexAlpha.put(12, 'l');indexAlpha.put(24, 'x');
        indexAlpha.put(13, 'm');indexAlpha.put(25, 'y');
        indexAlpha.put(14, 'n');indexAlpha.put(26, 'z');

    }

    public String process(String[] commands) {

        for(String com : commands) {
            Command command = convertToCommand(com);
            if(!isValid(command))continue;
            String desipheredString = desipherString(command);
            if(desipheredString.contains("north")) {
                return Integer.toString(command.id);
            }
        }

        return "Error";
    }

    public String desipherString(Command command) {
        String newString = "";
        for(char c : command.name.toCharArray()) {
            if(c == '-') {
                newString += '-';
                continue;
            }
            int newPosition = Part2.alphaIndex.get(c) + command.id;

            while(newPosition > 26) {
                newPosition -= 26;
            }
            char newChar = indexAlpha.get(newPosition);
            newString += newChar;
        }
        return newString;
    }
}