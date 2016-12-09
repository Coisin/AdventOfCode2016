package day6;

import AdventOfCode.Day;

import java.io.*;
import java.net.URL;

/**
 * Created by oisin on 12/9/16.
 */
public class Day6 extends Day {
    public void solve() {
        readInput(new Day6().getClass());
        String commands[] = input.split("\n");

        Part part1 = new Part1();
        Part part2 = new Part2();

        System.out.println("Part 1: " + part1.process(commands));
        System.out.println("Part 2: " + part2.process(commands));
    }
}
