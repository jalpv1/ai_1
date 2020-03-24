import java.util.*;

public class Search {


    private boolean constainsExp(Set<Node> explored, Node node) {
        for (Node state : explored) {
            if (myEquals(state,node)) {
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
            List<Node> successors = variantsCreator.generate(node);
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

    public Node execute(Node initialNode) {
        VariantsCreator variantsCreator = new VariantsCreator();
        if (initialNode.isGoal()) {
            return initialNode;
        }

        //HashMap<State, Integer> map = new HashMap<>();

        Queue<Node> openQueue = new LinkedList<>();
        HashSet<Node> closedSet = new HashSet<>(); //сет для збереження поточного стану
        openQueue.add(initialNode);
        closedSet.add(initialNode);
        while (!openQueue.isEmpty()) {

            Node u = openQueue.poll();
         /*  if(u.getPeopleLeft() < u.getBigMonkeysLeft()+u.getSmallMonkeysLeft() ){
                u.setPeopleLeft(u.getBigMonkeysLeft()+u.getSmallMonkeysLeft());
            }

            if(u.getPeopleRight() < u.getBigMonkeysRight()+u.getSmallMonkeysRight() ){
                u.setPeopleRight(u.getBigMonkeysRight()+u.getSmallMonkeysRight());
            }

          */

            //System.out.println(u.toString());

            if (u.isGoal()) {
                return u;
            }

            //map.put(u, nodeNo);
            closedSet.add(u);

            List<Node> successors = variantsCreator.generate(u);
            if(successors.isEmpty()){
                continue;
            }

            for (Node v : successors) {
                if (constainsExp(closedSet, v)) {
                    continue;
                }

                openQueue.add(v);

            }
        }

        return null;
    }
    private boolean myEquals(Node n1,Node n2){
        return n1.getDriver() == n2.getDriver() && n1.getPos() == n2.getPos() && n1.getPeopleLeft() == n2.getPeopleLeft() &&  n1.getPeopleRight() == n2.getPeopleRight()
                && n1.getSmallMonkeysLeft() == n2.getSmallMonkeysLeft() &&  n1.getSmallMonkeysRight() == n2.getSmallMonkeysRight()
                && n1.getBigMonkeysLeft() == n2.getBigMonkeysLeft() &&  n1.getBigMonkeysRight() == n2.getBigMonkeysRight();
    }
}
