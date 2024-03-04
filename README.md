#CSE4308- Artificial Intelligence: Assignment 1
#Name: Kerry Pacheco ID:1001437093

#Graph Search Program
This Java program was made using IntelliJ IDEA Community Edition 2023.1.1
Using Java Version java version "21.0.1" 2023-10-17 LTS
This program is Compiled and run in Windows Power Shell

Please make sure your computer has these tools available to use this program:

**There are 2 ways of running this program open your IntelliJ IDE and upload the files from the zip
folder, run from the IntelliJ IDE using the edit configurations on the top right
drop down menu next to the build button (hammer icon).

after clicking on Edit configurations. You will see the build and run window
Use the drop down menu to choose the Java version and setup the JDK. After the JDK/SDK configuration choose the main class you want to 
run. There is the Heuristic class for Informed search and the UniformCostSearchUninformed class for the Uninformed search

Type the arguments in the argument textbox as you would type them in the command terminal. Change the names of the cities with your own

for Uninformed Uniform Cost search use:
find_route input_file.txt starting_city destination_city 

for informed A* search using Heuristics use: 
find_route input_file.txt starting_city destination_city heuristic_data.txt

***Alternate compile/run options below***



This Java program implements two graph search algorithms:
- Uninformed Uniform Cost Search Algorithm
and
- Informed A* search Algorithm using Heuristics

For Uninformed Uniform Cost search compile and run the following java code file:
UniformCostSearchUninformed.java

For Informed search using heuristics compile and run the following java code file:
Heuristic.java

Read below for run/compile instructions

##Usage

**Download zip files and extract to your local directory
**Open a Windows Powershell terminal and go to your local directory where the files are located
** for example PS C:\Users\kerryPacheco\Desktop\AI_project>
**In your PS terminal you can compile the program now as follows.

1)**Compile** UNINFORMED Uniform cost search:Compile the java program using Windows Powershell terminal. Use the following
command line arguments for

javac UniformCostSearchUninformed.java

**Run** Run the compiled UniformCostSearchUninformed.java program with the following command line arguments. Replace the city names with the names
of the cities you wish to search a path for. Replace the input file with the name of the text file that has the graph data :

java UniformCostSearchUninformed find_route input_file.txt starting_city destination_city

2)**Compile** INFORMED A* Search with Heuristics: compile the java program using Windows Powershell terminal. Use the following
command line arguments for UNINFORMED Uniform cost search:

javac Heuristic.java

**Run** Run the compiled Heuristic.java program with the following command line arguments. replace the city names with the names
of the cities you wish to search a path for. Replace the input file with the name of the text file that has the graph data :

java Heuristic find_route input_file.txt starting_city destination_city heuristic_data.txt

## Input Graph Format

The input_file.txt file should follow this specific format:

- Each line represents an edge in the graph.

- The last line of the text file will have the String "END OF INPUT" so the program knows when it has reached the end of the file

- Each edge is represented by three values (String, String, float) separated by spaces: 
<source_node> <destination_node> <edge_cost>.

- For example:

Luebeck Hamburg 63
Hamburg Bremen 116
Hamburg Hannover 153
Hamburg Berlin 291
END OF INPUT

## Input Heuristics Format

The heuristic_data.txt file should follow this specific format:

- Each line represents a city and an estimated heuristic cost. 
- The last line of the text file will have the String "END OF INPUT" so the program knows when it has reached the end of the file

- Each heuristic is represented by 2 values separated by spaces: 
<city_from> <estimated_heuristic>.

For example: for the estimated heuristics to go from Bremen to Kassel.
The heuristic file for Kassel will include all the cities in the graph 
and the estimated cost from that city node to Kassel

Birmingham 400
Bristol 400
London 300
END OF INPUT

## INDEX OF ALGORITHMS

**Data Structures** 
Class Node contains the fields: Node parent, String currentState, and float additiveCost

Class Edge contains the fields: String origin, String destination, float and edgeCost

class HeuristicValues contains the fields: String cityName and float cityHeuristic

Class Graph contains the functions:
 public void addEdge(String origin, String destination, float cost) This function 
 adds new edges to an array list of edges.
 
 public ArrayList<Node> expandNode(Node inputNode) This function expands the nodes 
 contained in the edge list using the lowest cost node from the fringe
 
 
**Fringe Implementation

1)For fringe implementation using Uniform Cost search

File: UniformCostSearch.java
 public static Node uniformCostSearch(Graph graph, String initialCity, String destinationCity)
{
  PriorityQueue<Node> fringe = new PriorityQueue<Node>(Comparator.comparingDouble(node -> node.getAdditiveCost()));
}

The function UniformCostSearch Receives an object of type Graph that contains all the edges of the graph, a String
with the name of the initial city and a String with the name of the destination city.
The fringe is implemented using a priority queue of type Node. The Node Object contains the fields forthe node parent,
the additive cost for that node, and the current state of the node.
The priority queue will fill the add to the fringe all the nodes in order of additiveCost, putting the lowest cost node
in the front of the fringe so the algorithm can choose to travel to that node next.

2)For fringe implementation of A* search algorithm using Heuristics
File: 
HeuristicsSearchInformed.java

public static Node informedHeuristicSearch(Graph graph, String initialCity, String destinationCity, HashMap<String, Float> heuristicValues)
{       
  PriorityQueue<Node> fringe = new PriorityQueue<Node>(Comparator.comparingDouble(node -> node.getAdditiveCost()+heuristicValues.get(node.getCurrentState())));
}
The fringe is implemented using a priority queue of type Node. The Node Object contains the fields forthe node parent,
the additive cost for that node, and the current state of the node. This priority queue will use the formula g(n)+h(n) to sort 
the nodes in the fringe to implement A* search

** Reading input

1) File: ReadGraph.java 
public static Graph readGraph(String fileName) throws IOException This function will read the input file that contains the 
edges of the graph and add those edges to the graph using function addEdge()

2) File: ReadHeuristic.java
public static HashMap<String,Float> readHeuristic(String fileName) throws IOException This function will read the input file 
that contains the heuristic values and will add those values to a HashMap of <String, Float> type elements 

3) File: Heuristic.java this file contains the main method that will handle the command line arguments that call
for the implementation of the A* search using the input file and the heuristic file

4) File: UniformCostSearchUninformed.java this file contains the main method that will handle the command line arguments that call
for the implementation of the Uninformed Uniform Cost Search using the data from input file only without heuristics
