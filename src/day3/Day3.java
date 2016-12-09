package day3;

import AdventOfCode.Day;

/**
 * Created by oisin on 12/9/16.
 */
public class Day3 extends Day {
    public void solve() {
        readInput(new Day3().getClass());
        String commands[] = convertArrayFormat();

        Part part1 = new Part1();
        Part part2 = new Part2();

        System.out.println("Part 1: " + part1.process(commands));
        System.out.println("Part 2: " + part2.process(commands));
    }
    public static String[] convertArrayFormat() {
        String[] commands = input.split("\n");
        for(int i = 0;i < commands.length; i++) {
            String command = commands[i];
            boolean spaceDue = false;
            String result = "";
            for(char digit : command.toCharArray()) {
                if(Character.isDigit(digit)) {
                    result += digit;
                    spaceDue = true;
                } else if(spaceDue){
                    result += " ";
                    spaceDue = false;
                }
            }
            commands[i] = result;
        }
        return commands;
    }

}

