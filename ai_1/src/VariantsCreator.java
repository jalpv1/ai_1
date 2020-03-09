import java.util.ArrayList;
import java.util.List;

public class VariantsCreator {

    public List<Node> generate(Node node) {
        List<Node> successors = new ArrayList<>();
        if (node.getBoat() == Bank.LEFT) {
            testAndAdd(successors, new Node(node.getCannibalLeft(), node.getMissionaryLeft() - 2, Bank.RIGHT,
                    node.getCannibalRight(), node.getMissionaryRight() + 2),node);
            testAndAdd(successors, new Node(node.getCannibalLeft() - 2, node.getMissionaryLeft(), Bank.RIGHT,
                    node.getCannibalRight() + 2, node.getMissionaryRight()),node);
            testAndAdd(successors, new Node(node.getCannibalLeft() - 1, node.getMissionaryLeft() - 1, Bank.RIGHT,
                    node.getCannibalRight() + 1, node.getMissionaryRight() + 1),node);
            testAndAdd(successors, new Node(node.getCannibalLeft(), node.getMissionaryLeft() - 1, Bank.RIGHT,
                    node.getCannibalRight(), node.getMissionaryRight() + 1),node);
            testAndAdd(successors, new Node(node.getCannibalLeft() - 1, node.getMissionaryLeft(), Bank.RIGHT,
                    node.getCannibalRight() + 1, node.getMissionaryRight()),node);
        } else {
            testAndAdd(successors, new Node(node.getCannibalLeft(), node.getMissionaryLeft() + 2, Bank.LEFT,
                    node.getCannibalRight(), node.getMissionaryRight() - 2),node);
            testAndAdd(successors, new Node(node.getCannibalLeft() + 2, node.getMissionaryLeft(), Bank.LEFT,
                    node.getCannibalRight() - 2, node.getMissionaryRight()),node);
            testAndAdd(successors, new Node(node.getCannibalLeft() + 1, node.getMissionaryLeft() + 1, Bank.LEFT,
                    node.getCannibalRight() - 1, node.getMissionaryRight() - 1),node);
            testAndAdd(successors, new Node(node.getCannibalLeft(), node.getMissionaryLeft() + 1, Bank.LEFT,
                    node.getCannibalRight(), node.getMissionaryRight() - 1),node);
            testAndAdd(successors, new Node(node.getCannibalLeft() + 1, node.getMissionaryLeft(), Bank.LEFT,
                    node.getCannibalRight() - 1, node.getMissionaryRight()),node);
        }
        return successors;
    }
    private void testAndAdd(List<Node> successors, Node newNode,Node parentNode) {
        if (newNode.isValid()) {
            newNode.setParentNode(parentNode);
            successors.add(newNode);
        }
    }

}
