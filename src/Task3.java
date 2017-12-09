/*
Day 3 - 2017 Advent of Code
http://adventofcode.com/2017/day/3
*/

import java.util.Arrays;

class Spiral {

    enum Direction {
        RIGHT, UP, LEFT, DOWN;
    }

    static int input = 368078;

    static String[][] genSpiral(int n) {
        return genSpiral(n, 1);
    }

    public static void removeNullFromSpiral(String[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                tab[i][j] = (tab[i][j] == null ? "0000000" : tab[i][j]);
            }
        }
    }

    private static String[][] genSpiral(int n, int i) {
        String[][] spiral = new String[n][n];
        Direction dir = Direction.RIGHT;
        int j = i;
        int y = n / 2;
        int x = (n % 2 == 0) ? y - 1 : y; //shift left for even n's
        while (j <= ((n * n) - 1 + i)) {
            int sum = 0;
            try {
                if (spiral[y - 1][x - 1] != null)
                    sum += Integer.parseInt(spiral[y - 1][x - 1].trim());
                if (spiral[y - 1][x] != null)
                    sum += Integer.parseInt(spiral[y - 1][x].trim());
                if (spiral[y - 1][x + 1] != null)
                    sum += Integer.parseInt(spiral[y - 1][x + 1].trim());
                if (spiral[y][x - 1] != null)
                    sum += Integer.parseInt(spiral[y][x - 1].trim());
                if (spiral[y][x + 1] != null)
                    sum += Integer.parseInt(spiral[y][x + 1].trim());
                if (spiral[y + 1][x - 1] != null)
                    sum += Integer.parseInt(spiral[y + 1][x - 1].trim());
                if (spiral[y + 1][x] != null)
                    sum += Integer.parseInt(spiral[y + 1][x].trim());
                if (spiral[y + 1][x + 1] != null)
                    sum += Integer.parseInt(spiral[y + 1][x + 1].trim());
                if (sum == 0) {
                    spiral[y][x] = String.format("%7d", 1);
                } else {
                    spiral[y][x] = String.format("%7d", sum);
                }
                if (Integer.parseInt(spiral[y][x].trim()) >= input) {
                    System.out.println(spiral[y][x]);
                    return spiral;
                }


            } catch (Exception e) {
                spiral[y][x] = String.format("%7d", 0000000);
            }
            switch (dir) {
                case RIGHT:
                    if (x <= (n - 1) && spiral[y - 1][x] == null && j > i) dir = Direction.UP;
                    break;
                case UP:
                    if (spiral[y][x - 1] == null) dir = Direction.LEFT;
                    break;
                case LEFT:
                    if (x == 0 || spiral[y + 1][x] == null) dir = Direction.DOWN;
                    break;
                case DOWN:
                    if (spiral[y][x + 1] == null) dir = Direction.RIGHT;
                    break;
            }

            switch (dir) {
                case RIGHT:
                    x++;
                    break;
                case UP:
                    y--;
                    break;
                case LEFT:
                    x--;
                    break;
                case DOWN:
                    y++;
                    break;
            }
            j++;

        }
        return spiral;
    }
}

public class Task3 {

    static int input = 368078;

    static void firstTask() {
        int n = 2;
        Math.pow(2 * n - 1, 2);
        while (Math.pow(2 * n - 1, 2) <= input) {
            n++;
        }
        int shortestDistanceToMiddle = n - 1;
        int sideLength = 2 * shortestDistanceToMiddle + 1;
        int distanceToMiddle = (sideLength - 1) / 2;
        int middle = 0;

        for (int i = 0; i < 5; i++) {
            if (sideLength * sideLength - i * (sideLength - 1) <= input) {
                middle = sideLength * sideLength - i * (sideLength - 1) + distanceToMiddle;
                middle = Math.abs(middle - input);
                break;
            }
        }
        System.out.println(middle + shortestDistanceToMiddle);
    }

    public static void main(String[] argv) {
        firstTask();
        String[][] spiral = Spiral.genSpiral(11);
        Spiral.removeNullFromSpiral(spiral);
        for (String[] row : spiral) {
            System.out.println(Arrays.toString(row).replaceAll(",", ""));
        }
        System.out.println();
    }
}
