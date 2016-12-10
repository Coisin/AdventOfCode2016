package AdventOfCode;

import day1.Day1;
import day2.Day2;
import day3.Day3;
import day4.Day4;
import day5.Day5;
import day6.Day6;
import day7.Day7;
import day8.Day8;

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
        problems.add(new Day8());
    }
    public static void main(String args[]) {
        if(args.length > 0) {
            commenceSolve(Integer.parseInt(args[0]));
        } else {
            for (int dayIndex = 1; dayIndex <= problems.size(); dayIndex++) {
                commenceSolve(dayIndex);
            }
        }
    }
    static void commenceSolve(int dayIndex) {
        Day problem = problems.get(dayIndex - 1);

        System.out.println("--------------------");
        System.out.println("Day " + dayIndex);
        System.out.println("--------------------");
        problem.solve();
    }
}
