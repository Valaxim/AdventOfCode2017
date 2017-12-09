/*
Day 9 - 2017 Advent of Code
http://adventofcode.com/2017/day/9
*/

import java.io.*;
import java.util.Scanner;

public class Task9 {

    static int nonCancelledChar=0;
    static String input;

    static String readFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        StringBuilder builder = new StringBuilder();
        while (scanner.hasNextLine()) {
            builder.append(scanner.nextLine());
            builder.append("\n");
        }
        return builder.toString();
    }

    static char[] removeChar(String input) {
        char[] arrays = input.toCharArray();

        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] == '!') {
                arrays[i + 1] = ' ';
                arrays[i] = ' ';
            }
        }
        return arrays;
    }

    static void print(char[] arrays) {
        System.out.println();
        for (int i = 0; i < arrays.length; i++) {
            System.out.print(arrays[i]);
        }
    }

    static char[] removeBracket(char[] input) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] == '<') {
                for (int j = i; j < input.length; j++) {
                    if (input[j] == '>') {
                        for (int a = i; a <= j; a++) {
                            if (input[a]!=' ') {
                                nonCancelledChar++;
                            }
                            input[a] = ' ';
                        }
                        nonCancelledChar=nonCancelledChar-2;
                        break;
                    }
                }
            }
        }
        System.out.println("Number of cancelled char: " + nonCancelledChar );
        return input;
    }

    static void countBracket(char[] arrays) {
        int bracketOpen = 0;
        int bracketClose = 0;

        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] == '{')
                bracketOpen++;
            if (arrays[i] == '}')
                bracketClose++;
        }
    }

    public static void countPoints(char[] arrays) {
        int points = 0;
        int countBracket = 0;
        int positionBracket = 0;

        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] == '{') {
                countBracket++;
                positionBracket = i;
            }
            else if (arrays[i] == '}') {
                points += countBracket;
                for (int j = positionBracket; j <= i; j++) {
                    arrays[j] = ' ';
                }
                i = -1;
                countBracket = 0;
            }
        }
    System.out.println("Total points: " + points);
    }
    public static void main(String[] argv) throws FileNotFoundException {
        char[] output;
        input = Task9.readFile("src/input9.txt");
        output = removeChar(input);
        output = removeBracket(output);
        countBracket(output);
        countPoints(output);
    }
}