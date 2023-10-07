import edu.princeton.cs.algs4.Merge;

public class Brute {

    private Point[][] segments;
    private int segmentCount;

    public Brute(Point[] points) {
        segments = new Point[100][4];
        segmentCount = 0;

        Merge.sort(points); // Using Merge.sort from algs4 library

        for (int i = 0; i < points.length - 3; i++) {
            for (int j = i + 1; j < points.length - 2; j++) {
                for (int k = j + 1; k < points.length - 1; k++) {
                    for (int l = k + 1; l < points.length; l++) {
                        if (points[i].slopeTo(points[j]) == points[i].slopeTo(points[k])
                                && points[i].slopeTo(points[j]) == points[i].slopeTo(points[l])) {
                            segments[segmentCount][0] = points[i];
                            segments[segmentCount][1] = points[j];
                            segments[segmentCount][2] = points[k];
                            segments[segmentCount][3] = points[l];
                            segmentCount++;
                        }
                    }
                }
            }
        }
    }

    public int howManySegments() {
        return segmentCount;
    }

    public Iterable<Point[]> segments() {
        Point[][] validSegments = new Point[segmentCount][4];
        for (int i = 0; i < segmentCount; i++) {
            validSegments[i] = segments[i];
        }
        return new ArraySegmentIterable(validSegments);
    }

    private class ArraySegmentIterable implements Iterable<Point[]> {
        private Point[][] array;

        public ArraySegmentIterable(Point[][] array) {
            this.array = array;
        }

        @Override
        public java.util.Iterator<Point[]> iterator() {
            return new ArraySegmentIterator(array);
        }
    }

    private class ArraySegmentIterator implements java.util.Iterator<Point[]> {
        private Point[][] array;
        private int currentIndex;

        public ArraySegmentIterator(Point[][] array) {
            this.array = array;
            this.currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < array.length;
        }

        @Override
        public Point[] next() {
            return array[currentIndex++];
        }
    }

    public static void main(String[] args) {
        Point[] points = new Point[15];
        points[0] = new Point(10, 0);
        points[1] = new Point(8, 2);
        points[2] = new Point(2, 8);
        points[3] = new Point(0, 10);
        points[4] = new Point(20, 0);
        points[5] = new Point(18, 2);
        points[6] = new Point(2, 18);
        points[7] = new Point(10, 20);
        points[8] = new Point(30, 0);
        points[9] = new Point(0, 30);
        points[10] = new Point(20, 10);
        points[11] = new Point(13, 0);
        points[12] = new Point(11, 3);
        points[13] = new Point(5, 12);
        points[14] = new Point(9, 6);

        Brute brute = new Brute(points);
        for (Point[] segment : brute.segments()) {
            System.out.println(java.util.Arrays.toString(segment));
        }
    }
}