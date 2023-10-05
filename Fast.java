import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class Fast {
    private final List<List<Point>> segments;

    public Fast(Point[] points) {
        segments = new ArrayList<>();
        Arrays.sort(points);
        int n = points.length;
        Set<String> printedSegments = new HashSet<>();

        for (int i = 0; i < n; i++) {
            Point[] sortedPoints = Arrays.copyOf(points, n);
            Arrays.sort(sortedPoints, points[i].SLOPE_ORDER);

            int j = 1;
            while (j < n) {
                int k = j + 1;
                while (k < n && points[i].slopeTo(sortedPoints[j]) == points[i].slopeTo(sortedPoints[k])) {
                    k++;
                }

                if (k - j >= 3) {
                    List<Point> segment = new ArrayList<>();
                    segment.add(points[i]);
                    for (int m = j; m < k; m++) {
                        segment.add(sortedPoints[m]);
                    }
                    segment.sort(null); // Sort the segment lexicographically
                    String segmentString = segment.toString();

                    if (!printedSegments.contains(segmentString)) {
                        segments.add(segment);
                        printedSegments.add(segmentString);
                    }
                }

                j = k;
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
    
        Fast fast = new Fast(points);
        for (List<Point> segment : fast.segments()) {
            System.out.print(segment.get(0)); // Print the first point in the segment
            for (int i = 1; i < segment.size(); i++) {
                System.out.print(", " + segment.get(i)); // Print the rest of the points
            }
            System.out.println(); // Move to the next line after printing a segment
        }
    }
}

