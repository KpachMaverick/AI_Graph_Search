//CSE4308- Artificial Intelligence: Assignment 1
//Name: Kerry Pacheco ID:1001437093
public class Edge
{
    private String origin;
    private String destination;
    private float edgeCost;
    public String getOrigin()
    {
        return origin;
    }
    public void setOrigin(String newNode)
    {
        this.origin = newNode;
    }
    public String getDestination()
    {
        return destination;
    }
    public void setDestination(String newNextNode)
    {
        this.destination = newNextNode;
    }
    public float getCost()
    {
        return edgeCost;
    }
    public void setCost(float cost)
    {
        this.edgeCost = cost;
    }

}
