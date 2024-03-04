//CSE4308- Artificial Intelligence: Assignment 1
//Name: Kerry Pacheco ID:1001437093
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class ReadGraph
{
    public static Graph readGraph(String fileName) throws IOException
    {
        BufferedReader inputFile;
        inputFile =  new BufferedReader(new FileReader(fileName));
        String eachLine = inputFile.readLine();

        Graph graph= new Graph();

        while(!eachLine.equals("END OF INPUT"))
        {
            String [] tokenList = eachLine.split(" ");
            String origin = tokenList[0];
            String destination = tokenList[1];
            float edgeCost = Float.parseFloat(tokenList[2]);
            graph.addEdge(origin, destination,edgeCost);
            eachLine = inputFile.readLine();
            //PRINT CHECK
            //System.out.println(eachLine);
        }
        inputFile.close();
        return graph;
    }
}
