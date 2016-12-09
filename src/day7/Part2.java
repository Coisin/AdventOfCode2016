package day7;

import java.io.StringBufferInputStream;
import java.util.ArrayList;

/**
 * Created by oisin on 12/9/16.
 */
public class Part2 extends Part {
    ArrayList<String> abas = new ArrayList<>();
    String process(String[] commands) {
        int numberSSL = 0;

        for(String command : commands) {
            if(hasSSL(command)) {
                numberSSL++;
            }
            supernets = new ArrayList<>();
            hypernets = new ArrayList<>();
            abas = new ArrayList<>();
        }

        return Integer.toString(numberSSL);
    }
    boolean hasSSL(String command) {
        seperateNets(command);
        for(String supernet : supernets) {
            findABA(supernet);
        }
        for(String aba : abas) {
            if(hasBAB(aba)) {
                return true;
            }
        }
        return false;
    }
    void findABA(String supernet) {
        for(int i = 0; i < supernet.length() - 2; i++) {
            char c1 = supernet.charAt(i);
            char c2 = supernet.charAt(i + 1);
            char c3 = supernet.charAt(i + 2);
            if((c1 + "").equals(c3 + "")) {
                abas.add(c1 + "" + c2 + "" + c3);
            }
        }
    }
    boolean hasBAB(String ABA) {
        char a1 = ABA.charAt(0);
        char a2 = ABA.charAt(1);
        char a3 = ABA.charAt(2);

        for(String hypernet : hypernets) {
            for(int i = 0 ; i < hypernet.length() - 2; i++) {
                char b1 = hypernet.charAt(i);
                char b2 = hypernet.charAt(i + 1);
                char b3 = hypernet.charAt(i + 2);

                if((a1+"").equals(b2+"")&&(a2+"").equals(b1+"")&&(a2+"").equals(b3+"")) {
                    return true;
                }
            }
        }
        return false;
    }
}
