package day7;

import java.io.*;
import java.net.URL;

/**
 * Created by oisin on 12/9/16.
 */
public class Day7 {
    static String input;
    public static void main(String args[]) {
        readInput();
        String commands[] = input.split("\n");
        Part part1 = new Part1();
        Part part2 = new Part2();

        System.out.println("Part 1: " + part1.process(commands));
        System.out.println("Part 2: " + part2.process(commands));
    }
    public static void readInput() {
        input = "";

        URL url = new Day7().getClass().getResource("input.txt");
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
}
