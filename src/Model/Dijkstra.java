package Model;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Set;
import Controller.WindowController;
import java.awt.Color;

public class Dijkstra {

    public static void startDijkstra(){
        Node[][] nodeMatrix = WindowController.getDijkstraGridPanel().getNodeMatrix();
        ArrayList<Node> nodeCollection = new ArrayList<>();

        // Adding all the nodes to an collection, so I can use it for a priority queue
        addNodesToArrayList(nodeCollection);

        // Set up a priority queue with a comparator that sorts nodes by distance
        PriorityQueue<Node> queue = new PriorityQueue<Node>(10000, new NodeComparator());

        // Adds all the nodes to the queue
        queue.addAll(nodeCollection);

        int startRow = WindowController.getStartPointRow();
        int startColumn = WindowController.getStartPointColumn();

        Node startNode = nodeMatrix[startRow][startColumn];

        startNode.setDistance(0);
        queue.remove(startNode);
        queue.add(startNode);

        runDijkstra(queue);

        int endRow = WindowController.getEndPointRow();
        int endColumn = WindowController.getEndPointColumn();

        Node endNode = nodeMatrix[endRow][endColumn];

        System.out.println(endNode.getDistance());

        drawPath(startNode, endNode);
    }

    public static void drawPath(Node startNode, Node endNode){
        Color pathColor = WindowController.getPathColor();
        if (endNode.getPredecessor() != null){
            Node temp = endNode.getPredecessor();

            while (temp != startNode){
                temp.setColor(pathColor);
                temp = temp.getPredecessor();
            }
        }        
    }
 
    public static void runDijkstra(PriorityQueue<Node> queue){
        while (queue.peek() != null){
            //System.out.println("Taking new node");
            //System.out.println();
            Node minNode = queue.poll();
            Set<Node> neighborNodes = minNode.getNeighbors().keySet();

            for(Node currentNode : neighborNodes){
                //System.out.println("minNode: row: " + minNode.getRow() + " column: " + minNode.getColumn() + " distance: " + minNode.getDistance());
                //System.out.println("currentNode: row: " + currentNode.getRow() + " column: " + currentNode.getColumn() + " distance: " + currentNode.getDistance());
                relax(minNode, currentNode, queue);
            }
        }

    }

    public static void relax(Node start, Node end, PriorityQueue<Node> queue){
        //System.out.println();
        if (end.getDistance() > start.getDistance() + start.getNeighbors().get(end)){
            //System.out.println("Updated distance");
            end.setDistance(start.getDistance() + start.getNeighbors().get(end));
            end.setPredecessor(start);
            //System.out.println(end.getDistance());
            //System.out.println();
            queue.remove(end);
            queue.add(end);
        }
    }
    
    /**
    * Iterates nodeMatrix and adds all non-obstacle nodes to a given collection
    * @param nodeCollection
    */
    private static void addNodesToArrayList(ArrayList<Node> nodeCollection){
        Node[][] nodeMatrix = WindowController.getDijkstraGridPanel().getNodeMatrix();

        for (int row = 0; row < nodeMatrix.length; row++){
            for (int column = 0; column < nodeMatrix[row].length; column++){
                // Check if the color is not the obstacle color
                if (nodeMatrix[row][column].getColor() != WindowController.getObstacleColor()){
                    nodeCollection.add(nodeMatrix[row][column]);
                }
            }
        }
    }
}
