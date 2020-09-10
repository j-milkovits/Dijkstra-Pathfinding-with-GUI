package Model;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node>{
    
    public int compare(Node first, Node second){
        if (first.getDistance() < second.getDistance()){
            return -1;
        }
        if (first.getDistance() > second.getDistance()){
            return 1;
        }
        else return 0;
    }
}
