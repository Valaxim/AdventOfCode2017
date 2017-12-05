/*
Day 5 - 2017 Advent of Code
http://adventofcode.com/2017/day/4
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task5 {

    static int steps = 0;
    static List<Integer> input;

    static List<Integer> readFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        List<Integer> tall = new ArrayList<Integer>();
        while (scanner.hasNextInt()) {
            tall.add(scanner.nextInt());
        }
        return tall;
    }

    static void printArray(List<Integer> k) {
        for (Integer i : k) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] argv) throws FileNotFoundException {

        int index =0;
        int value =0;
       input = Task5.readFile("src/input5.txt");

        while (index >=0 && index < input.size()) {
            steps++;
            value=input.get(index);
            input.set(index, input.get(index)+1);
            index+=value;
            //printArray(k);
        }
        System.out.println("Required steps: "+ steps);

        input = Task5.readFile("src/input5.txt");
        index = 0;
        steps = 0;

        while (index >=0 && index < input.size()) {
            steps++;
            value=input.get(index);
            if (value>=3)
                input.set(index, input.get(index)-1);
            else
                input.set(index, input.get(index)+1);
            index+=value;
            //printArray(k);
        }
        System.out.println("Required steps: "+ steps);
    }
}
