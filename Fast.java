import java.util.Arrays;
// import java.util.Comparator;
// import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

import java.util.ArrayList;
//import java.util.HashSet;
import java.util.List;
// import java.util.Set;

// import javax.swing.text.Segment;

public class Fast {
    public List<List<Point>> segments(Point[] points) {
        List<List<Point>> lineSegments = new ArrayList<>();
        
        // Iterate through each point as the reference point.
        for (Point p : points) {
            Point[] sortedPoints = Arrays.copyOf(points, points.length); // Create a copy
            Arrays.sort(sortedPoints, p.SLOPE_ORDER);// Sort by slope relative to p
            
            // Implement the logic to find collinear segments and add them to lineSegments.
            // Be careful to avoid duplicates.
        }
        
        return lineSegments;
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

        // Call the segments method to find collinear segments
        Fast fast = new Fast();
        List<List<Point>> lineSegments = fast.segments(points);

        // Sort the line segments as per requirements
        lineSegments.sort((segment1, segment2) -> {
            // Sort by the first point in each line segment
            int cmp = segment1.get(0).compareTo(segment2.get(0));
            if (cmp != 0) {
                return cmp;
            }
            
            // If the first points are equal, compare by slope of the patterns
            double slope1 = segment1.get(0).slopeTo(segment1.get(segment1.size() - 1));
            double slope2 = segment2.get(0).slopeTo(segment2.get(segment2.size() - 1));
            return Double.compare(slope1, slope2);
        });

        // Print the sorted line segments
        for (List<Point> segment : lineSegments) {
            for (int i = 0; i < segment.size(); i++) {
                out.print(segment.get(i));
                if (i < segment.size() - 1) {
                    out.print(" -> ");
                }
            }
            out.println();
        }
    }
}
    
  


