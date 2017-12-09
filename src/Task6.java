/*
Day 6 - 2017 Advent of Code
http://adventofcode.com/2017/day/6
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Task6 {

    static int steps = 0;
    static List<Integer> input;

    static List<Integer> readFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        List<Integer> tall = new ArrayList<>();
        while (scanner.hasNextInt()) {
            tall.add(scanner.nextInt());
        }
        return tall;
    }

    public static int getMaxValuePosition(int array[]) {
        int value = 0;
        int position = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > value) {
                value = array[i];
                position = i;
            }
        }
        return position;
    }

    public static int getIndex(Set<? extends Object> set, Object value) {
        int result = 0;
        for (Object entry : set) {
            if (entry.equals(value)) return result;
            result++;
        }
        return -1;
    }

    public static void main(String[] argv) throws FileNotFoundException {

        Set<String> set = new LinkedHashSet<>();
        input = Task6.readFile("src/input6.txt");
        System.out.println(input);

        int[] data = new int[input.size()];
        for (int i = 0; i < input.size(); i++) {
            data[i] = input.get(i);
        }

        while (true) {
            if (set.contains(Arrays.toString(data))) {
                // System.out.println(Arrays.toString(data));
                int counter = getIndex(set, Arrays.toString(data));
                System.out.println("Programs end in : " + steps + " steps, loop has: " + ( steps - counter) + " steps.");
                return;
            }

            set.add(Arrays.toString(data));
            steps++;

            int k = getMaxValuePosition(data);
            int j = k;
            int counter = 0;
            while (data[k] != 0 && counter < data.length) {
                if (j < data.length - 1) {
                    j++;
                    data[k]--;
                    data[j]++;
                } else {
                    j = 0;
                    data[k]--;
                    data[j]++;
                }
                counter++;
            }
        }
    }
}

