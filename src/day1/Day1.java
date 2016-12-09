package day1;

import AdventOfCode.Day;

/**
 * Created by oisin on 12/9/16.
 */
public class Day1 extends Day {
    public void solve() {
        readInput(new Day1().getClass());
        input = input.replaceAll("\n", "");
        String[] commands = input.split(", ");

        Part part1 = new Part1();
        Part part2 = new Part2();

        System.out.println("Part 1: " + part1.process(commands));
        System.out.println("Part 2: " + part2.process(commands));
    }
}
