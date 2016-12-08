package day5;

import java.util.ArrayList;

/**
 * Created by oisin on 12/6/16.
 */
public class Part1 extends Part {
    String process(String input) {
        String password = "";
        inc = 0;
        for(int found = 0; found < 8 ; inc++) {
            String hash = MD5Hash(input + Integer.toString(inc));
            if(hash.startsWith("00000")) {
                password += hash.charAt(5);
                hashes.add(hash);
                found++;
            }
        }
        return password;
    }
}
