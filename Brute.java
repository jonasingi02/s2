import java.util.Arrays;
public class Brute {

    public int howManyLines(Point[] points) {
        int count = 0;
        Arrays.sort(points);
        for (i=0, i < points.length, i++) {
            for (j=1, j < points.length, j++) {
                for (k=2, k < points.length, k++) {
                    for (l=3, l < points.length, l++) {
                        if (points[i] == points[j] && points[i] == points[k] && points[i] == points[l]){
                            count++;
                        }
                    }
                }
            }
        }
        return count;
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
        int count = howManyLines(points);

    }
}