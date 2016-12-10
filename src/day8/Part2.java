package day8;

/**
 * Created by oisin on 12/9/16.
 */
public class Part2 extends Part {
    String process(String[] commands) {
        String code = "\n";

        for(int y = 0; y < screen.length; y++) {
            for (int x = 0; x < screen[y].length; x++)
                code += screen[y][x] ? 1 : " ";
            code += "\n";
        }
        return code;
    }
}
