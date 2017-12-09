/*
Day 8 - 2017 Advent of Code
http://adventofcode.com/2017/day/8
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Task8 {

    static String input;
    static int temporaryMaxValue=0;

    static String readFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        StringBuilder builder = new StringBuilder();
        while (scanner.hasNextLine()) {
            builder.append(scanner.nextLine());
            builder.append("\n");
        }
        return builder.toString();
    }

    public static void main(String[] argv) throws FileNotFoundException {

        input = Task8.readFile("src/input8.txt");
        String[] lines = input.split("\n");

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String line : lines) {
            String[] properties = line.split(" ");
            //System.out.println("map: " + properties[0] + " ins: " + properties[1] + " value: " + properties[2] + " if: " + properties[3] + " variable: " + properties[4] + " char: " + properties[5] + " value2: " + properties[6]);
            map.put(properties[0], 0);
        }
        for (String line : lines) {
            String[] properties = line.split(" ");
            int value1 = Integer.parseInt(properties[2]);
            int value2 = Integer.parseInt(properties[6]);
            boolean addValue = properties[1].equals("inc") ? true : false;

            switch (properties[5]) {

                case "!=":
                    if (map.get(properties[4]) != value2) {
                        if (addValue) {
                            map.put(properties[0], map.get(properties[0]) + value1);
                        } else {
                            map.put(properties[0], map.get(properties[0]) - value1);
                        }
                    }
                    break;
                case "==":
                    if (map.get(properties[4]) == value2) {
                        if (addValue) {
                            map.put(properties[0], map.get(properties[0]) + value1);
                        } else {
                            map.put(properties[0], map.get(properties[0]) - value1);
                        }
                    }
                    break;

                case ">":
                    if (map.get(properties[4]) > value2) {
                        if (addValue) {
                            map.put(properties[0], map.get(properties[0]) + value1);
                        } else {
                            map.put(properties[0], map.get(properties[0]) - value1);
                        }
                    }
                    break;
                case "<":
                    if (map.get(properties[4]) < value2) {
                        if (addValue) {
                            map.put(properties[0], map.get(properties[0]) + value1);
                        } else {
                            map.put(properties[0], map.get(properties[0]) - value1);
                        }
                    }
                    break;

                case ">=":
                    if (map.get(properties[4]) >= value2) {
                        if (addValue) {
                            map.put(properties[0], map.get(properties[0]) + value1);
                        } else {
                            map.put(properties[0], map.get(properties[0]) - value1);
                        }
                    }
                    break;
                case "<=":
                    if (map.get(properties[4]) <= value2) {
                        if (addValue) {
                            map.put(properties[0], map.get(properties[0]) + value1);
                        } else {
                            map.put(properties[0], map.get(properties[0]) - value1);
                        }
                    }
                    break;
                default:
                    break;
            }
            temporaryMaxValue = Collections.max(map.values()) > temporaryMaxValue ? Collections.max(map.values()) : temporaryMaxValue;
        }

        System.out.println("Max value is: " + Collections.max(map.values()));
        System.out.println("Temporary Max value is: " + temporaryMaxValue);
    }
}
