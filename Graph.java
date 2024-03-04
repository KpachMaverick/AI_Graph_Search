//CSE4308- Artificial Intelligence: Assignment 1
//Name: Kerry Pacheco ID:1001437093
import java.util.ArrayList;
public class Graph
{
    ArrayList<Edge> edgeList = new ArrayList<Edge>();
    public void addEdge(String origin, String destination, float cost) {
        Edge edge = new Edge();
        edge.setOrigin(origin);
        edge.setDestination(destination);
        edge.setCost(cost);
        edgeList.add(edge);
        //String edge = String.valueOf(edgeList.get(0));

    }
    public ArrayList<Node> expandNode(Node inputNode) {
        ArrayList<Node> successorNodes = new ArrayList<>();
        String startState = inputNode.getCurrentState();

        for (int i = 0; i < (edgeList.size()); i++) {
            Edge objectElement = edgeList.get(i);
            if (startState.equals(objectElement.getOrigin())) {
                String destin = objectElement.getDestination();
                float cost = inputNode.getAdditiveCost() + objectElement.getCost();
                /*System.out.print("Successor List\n");
                System.out.printf("start here:%s\n", objectElement.getOrigin());
                System.out.printf("End here:%s\n", destin);
                System.out.printf("The cost of this leg is:%f\n", cost);*/
                Node successor = new Node();
                successor.setParent(inputNode);
                successor.setAdditiveCost(cost);
                successor.setCurrentState(destin);
                successorNodes.add(successor);
            }

            if (startState.equals(objectElement.getDestination())) {
                String backStart = objectElement.getDestination();
                float cost2 = inputNode.getAdditiveCost() + objectElement.getCost();
                float backCost = objectElement.getCost();
                /* PRINT CHECK
                System.out.print("Successor List\n");
                System.out.printf("start here:%s\n", backStart );
                System.out.printf("End here:%s\n", objectElement.getOrigin());
                System.out.printf("The cost of this leg is:%f\n", backCost);
                */
                Node successor2 = new Node();
                successor2.setParent(inputNode);
                successor2.setAdditiveCost(cost2);
                successor2.setCurrentState(objectElement.getOrigin());
                successorNodes.add(successor2);
            }
            //expandNode(success);
        }
        return successorNodes;
    }
}
