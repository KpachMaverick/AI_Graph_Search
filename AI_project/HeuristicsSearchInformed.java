//CSE4308- Artificial Intelligence: Assignment 1
//Name: Kerry Pacheco ID:1001437093
import java.util.*;
public class HeuristicsSearchInformed
{
    public static Node informedHeuristicSearch(Graph graph, String initialCity, String destinationCity, HashMap<String, Float> heuristicValues)
    {
        //This search implements A* search which uses the formula g(n)+h(n) to sort the nodes in the fringe
        PriorityQueue<Node> fringe = new PriorityQueue<Node>(Comparator.comparingDouble(node -> node.getAdditiveCost()+heuristicValues.get(node.getCurrentState())));

        Node firstNode = new Node();
        HashSet<String> closedList = new HashSet<String>();
        firstNode.setCurrentState(initialCity);        firstNode.setParent(null);
        firstNode.setAdditiveCost(0);

        fringe.add(firstNode);
        int counterPopped = 0;
        int counterExpanded = 0;
        int counterGenerated = 1;

        while(!(fringe.isEmpty()))
        {
            //The function poll() will extract the node with the least cost
            //once we assign that value to firstNode we can check if it's closed or not
            //The amount of nodes popped is the same amount the function poll() is called
            //because we pop the node with the least cost from the fringe
            firstNode = fringe.poll();
            counterPopped++;
            String checkedNode = firstNode.getCurrentState();

            if(checkedNode.equals(destinationCity))
            {
                System.out.printf("Nodes popped: %d\n", counterPopped);
                System.out.printf("Nodes expanded: %d\n",counterExpanded );
                System.out.printf("Nodes Generated: %d\n", counterGenerated);
                return firstNode;
            }
            if(!(closedList.contains(checkedNode)))
            {
                //We only expand the node and increment the counter after we
                //add it to the closed list
                closedList.add(checkedNode);
                ArrayList<Node> successorList = graph.expandNode(firstNode);
                counterExpanded ++ ;
                counterGenerated = counterGenerated + successorList.size();
                //addAll creates a loop and adds all elements at once
                fringe.addAll(successorList);
            }
        }
        System.out.printf("Nodes popped: %d\n", counterPopped);
        System.out.printf("Nodes expanded: %d\n",counterExpanded );
        System.out.printf("Nodes Generated: %d\n", counterGenerated);
        return null;
    }

/* UNIFORM COST SEARCH ALGORITHM
while !(fringe is empty) Get the first node in the fringe. que es el primero que tienen menor costo.
luego a ese node le saco el nombre y lo busco en la lista de closed(que es un hashset de Strings que tiene los nombres ),
si no esta en la lista de closed. lo meto en la lista de closed luego le saco los succesores usando expandNode function.
esos sucesores en la lista de nodes, y cada uno de esos sucesores los meto en la lista del fringe.

 */

}