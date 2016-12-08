package day5;

import sun.security.provider.MD2;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;

/**
 * Created by oisin on 12/6/16.
 */
public class Day5 {

    static final String input = "uqwqemis";

    public static void main(String[] args) {
        Part1 part1 = new Part1();
        Part2 part2 = new Part2();

        System.out.println("Part 1: " + part1.process(input));
        System.out.println("Part 2: " + part2.process(input));
    }

}
