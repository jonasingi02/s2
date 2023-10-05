import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Brute {

    private final List<List<Point>> segments;

    public Brute(Point[] points) {
        segments = new ArrayList<>();

        Arrays.sort(points);
        for (int i=0; i < points.length-3; i++) {
            for (int j=i+1; j < points.length-2; j++) {
                for (int k=j+1; k < points.length-1; k++) {
                    for (int l=k+1; l < points.length; l++) {
                        if (points[i].slopeTo(points[j]) == points[i].slopeTo(points[k])&& points[i].slopeTo(points[j]) == points[i].slopeTo(points[l])){
                            List<Point> segment = new ArrayList<>();
                            segment.add(points[i]);
                            segment.add(points[j]);
                            segment.add(points[k]);
                            segment.add(points[l]);
                            segments.add(segment);
                        }
                    }
                }
            }
        }
    }

    public int HowManySegments () {
        return segments.size();
    }

    Iterable<List<Point>> segments(){
        return segments;
    }



    public static void main(String[] args) {
        // In in = new In();
        // Out out = new Out();
        // int n = in.readInt();
        // Point[] points = new Point[n];
        // for (int i = 0; i < n; i++) {
        //     int x = in.readInt(), y = in.readInt();
        //     points[i] = new Point(x, y);
        // }
        // brute(points);
        Point[] points = new Point[15];
        points[0] = new Point(10,0);
        points[1] = new Point(8,2);
        points[2] = new Point(2,8);
        points[3] = new Point(0,10);
        points[4] = new Point(20,0);
        points[5] = new Point(18,2);
        points[6] = new Point(2,18);
        points[7] = new Point(10,20);
        points[8] = new Point(30,0);
        points[9] = new Point(0,30);
        points[10] = new Point(20,10);
        points[11] = new Point(13,0);
        points[12] = new Point(11,3);
        points[13] = new Point(5,12);
        points[14] = new Point(9,6);

        Brute brute = new Brute(points);
        for (List<Point> segment : brute.segments()) {
            System.out.println(segment);
        }
    }
}