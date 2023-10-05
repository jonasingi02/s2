import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Brute {

    private final List<List<Point>> segmentsList;

    public Brute(Point[] points) {

        Arrays.sort(points);
        for (int i=0; i <= points.length-3; i++) {
            for (int j=i+1; j <= points.length-2; j++) {
                for (int k=j+1, k <= points.length-1, k++) {
                    for (int l=k+1, l <= points.length, l++) {
                        if (points[i].slopeTo(points[j]) == points[i].slopeTo(points[k])&& points[i].slopeTo(points[j]) == points[i].slopeTo(points[l])){
                            List<Point> segment = new ArrayList<>();
                            segments.add(points[i]);
                            segments.add(points[j]);
                            segments.add(points[k]);
                            segments.add(points[l]);
                            segmentsList.add(segment);
                        }
                    }
                }
            }
        }
    }

    public int HowManySegments () {
        return segmentsList.size();
    }

    



    public static void main(String[] args) {
        In in = new In();
        Out out = new Out();
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt(), y = in.readInt();
            points[i] = new Point(x, y);
        }
        brute(points);

    }
}