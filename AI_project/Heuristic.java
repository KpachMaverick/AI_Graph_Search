//CSE4308- Artificial Intelligence: Assignment 1
//Name: Kerry Pacheco ID:1001437093
import java.io.IOException;
import java.util.HashMap;

public class Heuristic {
    public static void main(String[] args) throws IOException
    {
        //check command line arguments
        if (args.length == 0)
        {
            System.out.println("No arguments provided from the command line");
        }
        else
        {
            //We assign the values from the command line to variables
            String graphInfoFile = args[1];
            String initialNode = args[2];
            String goalTest = args[3];
            String heuristicFile = args[4];

            Node startNode = new Node();
            startNode.setParent(null);
            startNode.setAdditiveCost(0);
            startNode.setCurrentState(initialNode);
            HashMap<String,Float> heuristicValues = new HashMap<>();
            heuristicValues = ReadHeuristic.readHeuristic(heuristicFile);

            Graph graphData = ReadGraph.readGraph(graphInfoFile);
            Node finalNode = HeuristicsSearchInformed.informedHeuristicSearch(graphData,initialNode,goalTest,heuristicValues);
            if(finalNode==null)
            {
                System.out.print("Distance: Infinity\n");
                System.out.print("Route: None\n");
                return;
            }
            System.out.printf("Distance: %.1f Km\nRoute:\n", finalNode.getAdditiveCost());
            getRoute(finalNode);
            //to get the full route we get the parent recursively from the final node
        }
    }
    public static void getRoute(Node lastStop)
    {
        String current = lastStop.getCurrentState();
        float currentCost = lastStop.getAdditiveCost();
        Node parent = lastStop.getParent();
        if(parent==null)//if we're in our destination city we can exit the function
        {
            return;
        }
        String dest = parent.getCurrentState();
        float destCost = parent.getAdditiveCost();
        System.out.printf("%s to %s, %.1f Km\n", dest, current, currentCost - destCost);
        getRoute(parent);
    }
}

