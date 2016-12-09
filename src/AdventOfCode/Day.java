package AdventOfCode;

import day7.Day7;

import java.io.*;
import java.net.URL;

/**
 * Created by oisin on 12/9/16.
 */
public abstract class Day {
    public static String input;
    public static void readInput(Class classObject) {
        input = "";

        URL url = classObject.getResource("input.txt");
        File inputFile = new File(url.getPath());
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)))) {
            String line;
            while((line = reader.readLine()) != null) {
                input += line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    abstract public void solve();
}
