import java.util.ArrayList;
import java.util.List;
/*
class Point {

    int X;
    int Y;
    int value;
    int ring;

    Point()
    {
        this.X=0;
        this.Y=0;
        this.value=1;
        this.ring=1;
    }

    Point(int i) {
        int n=2;
        this.ring = (int) (Math.ceil(Math.sqrt(i)) - 1);


        }
        else
            {
                n++;
                new Point(i);
            }


        }
    }
    public int getPoint(int x, int y) {
        if (Point(x,y)==null)
                return 0;
        else
            return Point.value;
    }

    public int getNeighbour(int x, int y) {
        int sum=0;
        getPoint(x-1,y-1)
    }
}
*/


public class AoF3 {

    public static void main(String[] argv) {
        int input = 368078;
        int n=2;
        Math.pow(2*n-1,2);
        while ( Math.pow(2*n-1,2) <= input) {
            n++;
        }
        int shortestDistanceToMiddle = n-1;
        int sideLength = 2*shortestDistanceToMiddle+1;
        int distanceToMiddle = (sideLength-1) / 2;
        int middle=0;

        for (int i = 0; i<5 ; i++) {
            if (sideLength * sideLength - i * (sideLength - 1) <= input) {
                middle = sideLength * sideLength - i * (sideLength - 1) + distanceToMiddle;
                middle=Math.abs(middle-input);
                break;
            }
        }
       System.out.println(middle+shortestDistanceToMiddle);
/*
        input = 368078;
        int start = 1;
        List<Point> pointList = new ArrayList<>();
        Point p = new Point();
        pointList.add(p);

        while(start <input) {
            Point p = new Point(start);
            pointList.add(p);
            start++;
        }
*/
    }
}
