package AdventOfCode;

import day1.Day1;
import day2.Day2;
import day3.Day3;
import day4.Day4;
import day5.Day5;
import day6.Day6;
import day7.Day7;

import java.util.ArrayList;

/**
 * Created by oisin on 12/9/16.
 */
public class AdventOfCode {
    static ArrayList<Day> problems = new ArrayList<Day>();
    static {
        problems.add(new Day1());
        problems.add(new Day2());
        problems.add(new Day3());
        problems.add(new Day4());
        problems.add(new Day5());
        problems.add(new Day6());
        problems.add(new Day7());
    }
    public static void main(String args[]) {
        for(int dayIndex = 1; dayIndex <= problems.size(); dayIndex++) {
            Day problem = problems.get(dayIndex - 1);

            System.out.println("--------------------");
            System.out.println("Day " + dayIndex);
            System.out.println("--------------------");

            problem.solve();
        }
    }
}
