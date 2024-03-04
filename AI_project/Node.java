//CSE4308- Artificial Intelligence: Assignment 1
//Name: Kerry Pacheco ID:1001437093
public class Node
{
    private Node parent;
    private String currentState;
    private float additiveCost;

    public Node getParent()
    {
        return parent;
    }
    public void setParent(Node parent)
    {
        this.parent = parent;
    }
    public String getCurrentState()
    {
        return currentState;
    }
    public void setCurrentState(String state)
    {
        this.currentState = state;
    }
    public float getAdditiveCost()
    {
        return additiveCost;
    }
    public void setAdditiveCost(float cost)
    {
        this.additiveCost = cost;
    }

    public void expandNode(String initialNode) {
    }
}