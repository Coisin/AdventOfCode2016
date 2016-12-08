package day5;

import java.util.ArrayList;

/**
 * Created by oisin on 12/6/16.
 */
public class Part2 extends Part {
    int suitable = 0;
    String process(String input) {
        StringBuilder password = new StringBuilder("--------");
        for(String hash : hashes) {
            insertIntoString(hash, password);
        }
        for(; suitable < 8; ++inc) {
            String hash = MD5Hash(input + Integer.toString(inc));
            if(hash.startsWith("00000")) {
                insertIntoString(hash, password);
            }
        }
        return password.toString();
    }
    void insertIntoString(String hash, StringBuilder password) {
        if(Character.isAlphabetic(hash.charAt(5))) return;
        int insertionIndex = Character.getNumericValue(hash.charAt(5));
        if(insertionIndex > 7 || password.charAt(insertionIndex) != '-') {
            return;
        }
        suitable++;
        char insertion = hash.charAt(6);
        password.setCharAt(insertionIndex, insertion);
    }
}
