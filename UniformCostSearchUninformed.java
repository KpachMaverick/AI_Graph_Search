//CSE4308- Artificial Intelligence: Assignment 1
//Name: Kerry Pacheco ID:1001437093
import java.io.IOException;

public class UniformCostSearchUninformed
{
    public static void main(String[] args) throws IOException
    {
        //check command line arguments
        if (args.length == 0)
        {
            System.out.println("No arguments provided from the command line");
            System.exit(0);
        }
        else
        {
            //We assign the values from the command line to variables
            //So we can create the starting node and goal test for our graph search
            String graphInfoFile = args[1];
            String initialNode = args[2];
            String goalTest = args[3];

            Node startNode = new Node();
            startNode.setParent(null);
            startNode.setAdditiveCost(0);
            startNode.setCurrentState(initialNode);

            Graph graphData = ReadGraph.readGraph(graphInfoFile);
            Node finalNode = UniformCostSearch.uniformCostSearch(graphData, initialNode, goalTest);
            //Check if final node is null then print the distance,route etc
            if(finalNode==null)
            {
                System.out.print("Distance: Infinity\n");
                System.out.print("Route: None\n");
                return;

            }
            System.out.printf("Distance: %.1f Km\nRoute:\n", finalNode.getAdditiveCost());
            getRoute(finalNode);
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
        getRoute(parent);
        System.out.printf("%s to %s, %.1f Km\n", dest, current, currentCost - destCost);

    }
}


