/**
 * @author AJ ag6240@bard.edu, Anna, Antonio
 * 3/17/22
 * Lab 4: Traveling Salesperson
 * I worked with Anna and Antonio on the lab, and have not met with a tutor this week.
 */


/*
N is the number of inputs, T is the time it took to output.
 */

import edu.princeton.cs.algs4.*;

public class Tour {

    private class Node{
        private Point p;
        private Node next;

        public Node(Point p){
            this.p = p;
            next = null;
        }
    }
    /*
 * Variables
 *
 *
 * * */
    private int n;
    private Node first; //first node in linked list
    private Node last;

    public Tour(){
        first = null;
    }


    //show values.. in StdOut
    public void show() {
        if (first == null) {
            throw new RuntimeException("First is null: no points");
        }
        Node thisNode = first;
        do {
            StdOut.println(thisNode.p.toString());
            thisNode = thisNode.next;
        } while ( thisNode != first);
    }
    //draw it... duh
    public void draw() {
        if ( first == null) {
            throw new RuntimeException("no points in tour");
        }
            Node thisNode = first;
            do {
                thisNode.p.drawTo(thisNode.next.p);
                thisNode = thisNode.next;

            } while (thisNode != first);
        }


    //number of points on tour
    public int size() {
        Node thisNode = first;
        int count = 0;
        while(thisNode.next != first){
            count++;

        }
        return count;
    }
    public void insert(Point p ) {
        Node newNode = new Node(p);
        //if empty
        if (first == null){
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        n = n + 1;
    }



//    private void insertPoint(Point p, Node node) {
//        if (node.next == null) {
//            throw new RuntimeException("Not attached to list... error..");
//        }
//
//        Node insertionNode = new Node();
//        insertionNode.next = node.next;
//        node.next = insertionNode;
//    }

    double distance() {


        double distance = 0;

        Node thisNode = first;

        if (thisNode != null) {
            do {
                distance += thisNode.p.distanceTo(thisNode.next.p);
                thisNode = thisNode.next;
            } while (thisNode != first);
        }
        return distance;
    }

    //insert p using nearest neighbor heuristic
    public void insertNearest(Point p){

        if (first == null) { //this is for if the first point node is given..
            first = new Node(p);
            first.next = first;
        } else {
            //start node pointers
            Node thisNode = first;
            double currentDist = thisNode.p.distanceTo(p); //distance variable at first distance
            Node nearestNode =  thisNode; //node to find the nearest.
            double nearestDist = currentDist;

            //check each node in the tour, and if the current distance from node
            // is less than recorded shortest distance, replace distance and nearest
            // node variables with the current node.

            do {
                if (nearestDist > currentDist) {
                    nearestNode = thisNode;
                    nearestDist = currentDist;
                }
                thisNode = thisNode.next;
                currentDist = thisNode.p.distanceTo(p);
            } while ( thisNode != first);

            //insert the point....
            Node insertionNode = new Node(p);
            insertionNode.next = nearestNode.next;
            nearestNode.next = insertionNode;
        }
    }

    //insert p using nearest neighbor heuristic
    public void insertSmallest(Point p){

        //checks if node is empty, adds point if so.
        if (first == null){
            first = new Node(p);
            first.next = first;
        } else {

            //must initialize node to track (thisNode) and smallest node (idealNode)
            Node thisNode = first;
            Node idealNode = thisNode;

            //calculate the first difference in distance @distInc (change) and then compare it to
            // the smallest change (@smallestDist).
            double distInc = thisNode.p.distanceTo(p) + p.distanceTo(thisNode.next.p) - thisNode.p.distanceTo(thisNode.next.p);
            //initialize smallest change
            double smallestDist = distInc;

            do {
                if(smallestDist > distInc) {
                    idealNode = thisNode;
                    smallestDist = distInc;
                }
                thisNode = thisNode.next;
                distInc = thisNode.p.distanceTo(p)
                        + p.distanceTo(thisNode.next.p)
                        - thisNode.p.distanceTo(thisNode.next.p);
            } while (!thisNode.equals(first));

            Node newNode = new Node(p);
            newNode.next = idealNode.next;
            idealNode.next = newNode;
        }
    }

//    void insertAfter(Point a) {
//        if (first.p == null) {
//            first.p == a;
//        }
//        else {
//            Node thisNode = new Node();
//            thisNode.p = a;
//            last.next = thisNode;
//            last = last.next;
//            n++;
//        }
//    }

    public static void main(String[] args) {
        Point a = new Point(1.0, 1.0);
        Point b = new Point(1.0, 4.0);
        Point c = new Point(3.0, 4.0);
        Point d = new Point(200.0, 100.0);


        //test tour
        Tour test = new Tour();

    }


}
