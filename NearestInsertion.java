/*************************************************************************
 *  YOU DO NOT NEED TO MODIFY THIS FILE
 *
 *  Compilation:  javac NearestInsertion.java
 *  Execution:    java NearestInsertion < file.txt
 *  Dependencies: Tour.java Point.java StdIn.java StdDraw.java
 *
 *  Run nearest neighbor insertion heuristic for traveling
 *  salesperson problemand plot results.
 *
 *  % java NearestInsertion < tsp1000.txt
 *
 *************************************************************************/
import edu.princeton.cs.algs4.*;

import java.sql.Time;

public class NearestInsertion {

    public static void main(String[] args) {

        In in = new In ("tsp1000.txt");

        int w = in.readInt();
        int h = in.readInt();
        StdDraw.setCanvasSize(w, h);
        StdDraw.setXscale(0, w);
        StdDraw.setYscale(0, h);
        StdDraw.setPenRadius(.005);

        // get dimensions
//        int width = in.readInt();
//        int height = in.readInt();
//        int border = 20;
//        StdDraw.setCanvasSize(width, height + border);
//        StdDraw.setXscale(0, width);
//        StdDraw.setYscale(-border, height);

        // turn on animation mode
        StdDraw.enableDoubleBuffering();

        // run smallest insertion heuristic
        Tour tour = new Tour();
        Stopwatch timer1 = new Stopwatch();
        double elapsed1 = timer1.elapsedTime();
        long startime = System.currentTimeMillis();

        while (!in.isEmpty()) {
            double x = in.readDouble();
            double y = in.readDouble();
            Point p = new Point(x, y);
            tour.insertNearest(p);
            StdOut.print(" " + x + "x \t" + y + "y \n");



////             uncomment the 4 lines below to animate
////             StdDraw.clear();
//             tour.draw();
//             StdDraw.textLeft(20, 0, "length = " + tour.distance());
//             StdDraw.show();
//             StdDraw.pause(10);
        }

        // draw to standard draw
        tour.draw();
        StdDraw.show();

//         print tour to standard output
//        StdOut.println(tour);
        long endTime = System.currentTimeMillis();
        System.out.println("total execution Time: " +(endTime - startime) + "ms");
        StdOut.println("Nearest Insertion: " + elapsed1 + " seconds\n");
        StdOut.printf("Tour length = %.4f\n", tour.distance());
        StdOut.printf("Number of points = %d\n", tour.size());
    }

}