package day5;

import AdventOfCode.Day;

/**
 * Created by oisin on 12/9/16.
 */
public class Day5 extends Day {
    public void solve() {
        readInput(new Day5().getClass());
        input = input.replaceAll("\n", "");

        Part part1 = new Part1();
        Part part2 = new Part2();

        System.out.println("Part 1: " + part1.process(input));
        System.out.println("Part 2: " + part2.process(input));
    }
}
