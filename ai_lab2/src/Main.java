import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Node startNode = new Node(3, 2, 1,0, 0, 0,Bank.LEFT,Driver.INIT);
        Search search = new Search();
        Node solution = search.execute(startNode);
        print(solution);
        System.out.println("--------------------------------------------------");

    }
    private static void print(Node solution) {
        if (solution == null) {
            System.out.print("Empty solution");
        } else {
            List<Node> path = new ArrayList<>();
            Node node = solution;
            while(node!= null) {
                path.add(node);
                node = node.getParentNode();
            }

            int depth = path.size() - 1;
            for (int i = depth; i >= 0; i--) {
                node = path.get(i);
                if (node.isGoal()) {
                    System.out.println(node.toString());
                } else {
                    System.out.println(node.toString() );
                }
            }
        }
    }
}
