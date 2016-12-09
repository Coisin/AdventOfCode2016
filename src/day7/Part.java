package day7;

import java.util.ArrayList;

/**
 * Created by oisin on 12/9/16.
 */
public abstract class Part {
    ArrayList<String> supernets = new ArrayList<>();
    ArrayList<String> hypernets = new ArrayList<>();

    void seperateNets(String command) {
        String currentPartial = "";
        for(int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);
            if(c == '[') {
                supernets.add(currentPartial);
                currentPartial = "";
            } else if(c == ']') {
                hypernets.add(currentPartial);
                currentPartial = "";
            } else {
                currentPartial += c;
            }
        }
        if(!currentPartial.equals("")) {
            supernets.add(currentPartial);
        }
    }

    abstract String process(String[] commands);
}
