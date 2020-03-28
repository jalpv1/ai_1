import java.util.Comparator;
import java.util.LinkedList;

public class mPriorityQueue {
    public LinkedList<Node> myQueue;

    public mPriorityQueue() {
         myQueue = new LinkedList<>();
    }

    public void addEl(Node node){
        myQueue.add(node);
    }
    public Node Dequeue()
    {
        int bestIndex = 0;

        for (int i = 0; i < myQueue.size(); i++)
        {
            if (myQueue.get(i).f < myQueue.get(bestIndex).f)
            {
                bestIndex = i;
            }
        }

        Node bestItem = myQueue.get(bestIndex);
        myQueue.remove(bestIndex);
        return bestItem;
    }
}
