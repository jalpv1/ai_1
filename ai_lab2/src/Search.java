import java.util.*;

public class Search {


    private boolean constainsExp(Set<Node> explored, Node node) {
        for (Node state : explored) {
            if (myEquals(state, node)) {
                return true;
            }
        }
        return false;
    }

    private boolean constainsFr(Deque<Node> front, Node node) {
        for (Node state : front) {
            if (state.equals(node)) {
                return true;
            }
        }
        return false;

    };

    public Node execute(Node initialNode) {


        VariantsCreator variantsCreator = new VariantsCreator();
        if (initialNode.isGoal()) {
            return initialNode;
        }
        //черга вершин у яких ми ще не були
        mPriorityQueue openQueue = new mPriorityQueue();
        HashSet<Node> closedSet = new HashSet<>(); //сет для збереження поточного стану
        openQueue.addEl(initialNode);
        closedSet.add(initialNode);
        while (!openQueue.myQueue.isEmpty()) {
            //отримуємо стан з найвищім пріоритетом
            Node u = openQueue.Dequeue();
            if (u.isGoal()) {
                return u;
            }
            closedSet.add(u);

            List<Node> successors = variantsCreator.generateDriverOne(u);
            if (successors.isEmpty()) {
                continue;
            }

            for (Node v : successors) {
                if (constainsExp(closedSet, v)) {
                    continue;
                }

                openQueue.addEl(v);

            }
        }

        return null;
    }
    public Node dfsSearch(Node start) {
        VariantsCreator variantsCreator = new VariantsCreator();
        Deque<Node> front = new LinkedList<>();
        Set<Node> explored = new HashSet<Node>();
        front.add(start);

        while (true) {
            if (front.isEmpty()) {
                return null;
            }

            Node node = front.pollLast();

            explored.add(node);
            if (node.isGoal()) {
                return node;
            }
            List<Node> successors = variantsCreator.generate21(node);
            for (Node child : successors) {
                if (constainsExp(explored, child) || constainsFr(front, child)) {
                    continue;
                }

                if (child.isGoal()) {
                    return child;
                }
                front.add(child);

            }
        }
    }

    private boolean myEquals(Node n1, Node n2) {
        return n1.getDriver() == n2.getDriver() && n1.getPos() == n2.getPos() && n1.getPeopleLeft() == n2.getPeopleLeft() && n1.getPeopleRight() == n2.getPeopleRight()
                && n1.getSmallMonkeysLeft() == n2.getSmallMonkeysLeft() && n1.getSmallMonkeysRight() == n2.getSmallMonkeysRight()
                && n1.getBigMonkeysLeft() == n2.getBigMonkeysLeft() && n1.getBigMonkeysRight() == n2.getBigMonkeysRight();
    }
}
