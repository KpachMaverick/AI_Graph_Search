//CSE4308- Artificial Intelligence: Assignment 1
//Name: Kerry Pacheco ID:1001437093
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
public class ReadHeuristic
{
    public static HashMap<String,Float> readHeuristic(String fileName) throws IOException
    {
        HashMap<String, Float> fileValues = new HashMap<>();
        BufferedReader heuristicFile;
        heuristicFile =  new BufferedReader(new FileReader(fileName));
        String lineValues = heuristicFile.readLine();

        while(!lineValues.equals("END OF INPUT"))
        {
            String [] tokenList = lineValues.split(" ");
            String city = tokenList[0];
            float heuristicVal = Float.parseFloat(tokenList[1]);
            fileValues.put(city, heuristicVal);

            lineValues = heuristicFile.readLine();
            //PRINT CHECK
             //System.out.println(lineValues);
        }
        heuristicFile.close();
        return fileValues;
    }
}
