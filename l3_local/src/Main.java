import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        LocalSearch localSearch = new LocalSearch();
        Node n =localSearch.hillClimbingAlgoritm3(allocateState());
        print(n);
    }
    private static Node allocateState(){
        ArrayList<Bank> wives = new ArrayList<>(5);
        for (int i =0;i <5;i++) {
            wives.add(Bank.LEFT);
        }
        ArrayList<Bank> husband = new ArrayList<>(5);
        for (int i =0;i <5;i++) {
            husband.add(Bank.LEFT);
        }
        Node node = new Node(husband,wives,new Node(),Bank.LEFT);
       // wives.stream().forEach(wife->new Bank());
        return node;
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
