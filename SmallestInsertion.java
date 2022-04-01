/*************************************************************************
 *  YOU DO NOT NEED TO MODIFY THIS FILE
 *
 *  Compilation:  javac SmallestInsertion.java
 *  Execution:    java SmallestInsertion < file.txt
 *  Dependencies: Tour.java Point.java StdIn.java StdDraw.java
 *
 *  Run smallest insertion heuristic for traveling salesperson problem
 *  and plot results.
 *
 *  % java SmallestInsertion < tsp1000.txt
 *
 *************************************************************************/
import edu.princeton.cs.algs4.*;

public class SmallestInsertion {

    public static void main(String[] args) {

        In in = new In("tsp1000.txt");

        // get dimensions
        int width = in.readInt();
        int height = in.readInt();
        int border = 20;
        StdDraw.setCanvasSize(width, height + border);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(-border, height);

        // turn on double buffering
        StdDraw.enableDoubleBuffering();

        // run smallest insertion heuristic
        Tour tour = new Tour();
        while (!in.isEmpty()) {
            double x = in.readDouble();
            double y = in.readDouble();
            Point p = new Point(x, y);
            tour.insertSmallest(p);
            StdOut.print(" " + x + "x \t " + y + "y \n");
        }


        // uncomment the 4 lines below to animate

//            tour.draw();
//            StdDraw.show();
//            StdDraw.pause(200);
//            StdDraw.textLeft(20, 0, "length = " + tour.size());
//        }


        // draw to standard draw
        tour.draw();
        StdDraw.show();
        StdDraw.pause(10000);

//        print tour to standard output
//        StdOut.println(tour);
        StdOut.printf("Tour length = %.4f\n", tour.distance());
        StdOut.printf("Number of points = %d\n", tour.size());
    }
}

