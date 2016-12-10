package day2;

import AdventOfCode.Day;

/**
 * Created by oisin on 12/9/16.
 */
public class Day2 extends Day {
    public void solve() {
        readInput(new Day2().getClass());
        String commands[] = input.split("\n");

        Part part1 = new Part1();
        Part part2 = new Part2();

        System.out.println("Part 1: " + part1.process(commands));
        System.out.println("Part 2: " + part2.process(commands));
    }
}
