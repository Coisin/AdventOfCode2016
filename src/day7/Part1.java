package day7;

import java.util.ArrayList;

/**
 * Created by oisin on 12/9/16.
 */
public class Part1 extends Part {
    String process(String[] commands) {
        int numberIPv7 = 0;
        for(String command : commands) {
            if(isIPv7(command)) numberIPv7++;
            supernets = new ArrayList<>();
            hypernets = new ArrayList<>();
        }
        return Integer.toString(numberIPv7);
    }
    boolean isIPv7(String command) {
        seperateNets(command);
        for(String hypernet : hypernets) {
            if(containsABBA(hypernet)) return false;
        }
        for(String supernet : supernets) {
            if(containsABBA(supernet)) return true;
        }
        return false;
    }
    boolean containsABBA(String partial) {
        for(int i = 0; i < partial.length() - 3; i++) {
            char c1 = partial.charAt(i);
            char c2 = partial.charAt(i + 1);
            char c3 = partial.charAt(i + 2);
            char c4 = partial.charAt(i + 3);
            if((c1 != c2) && (c3 + "" + c4).equalsIgnoreCase(c2 + "" + c1)) {
                return true;
            }
        }
        return false;
    }
}
