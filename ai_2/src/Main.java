import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        State startNode = new State(3, 3, 0, 0, Boat.LEFT,Driver.PERSON);
        Search search = new Search();
        State solution = search.execute(startNode);
        print(solution);
    }
    private static void print(State solution) {
        if (solution == null) {
            System.out.print("Empty solution");
        } else {
            List<State> path = new ArrayList<>();
            State node = solution;
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
