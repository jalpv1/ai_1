import java.util.*;
public class DfsSearch {


 private boolean constainsExp(Set<Node> explored, Node node){
        for (Node state:explored) {
            if(state.equals(node)){
                return true;
            }
        }
        return false;
    }
    private boolean constainsFr(Deque<Node> front, Node node){
        for (Node state:front) {
            if(state.equals(node)){
                return true;
            }
        }
        return false;
    }

	public Node dfsSearch(Node start) {
	    VariantsCreator variantsCreator = new VariantsCreator();
		Deque<Node> frontier = new LinkedList<>();
		Set<Node> explored = new HashSet<Node>();
		frontier.add(start);

		while (true) {
			if (frontier.isEmpty()) {
				return null;    // failure
			}
			Node node = frontier.pollLast();
			explored.add(node);
			if (node.isGoal()) {
				return node;
			}
			List<Node> successors = variantsCreator.generate(node);
			for (Node child : successors) {
			    if(constainsExp(explored, child) || constainsFr(frontier, child)){
			        continue;
                }

				//if ( !frontier.contains(child)) {
					if (child.isGoal()) {
						return child;
					}
					frontier.add(child);
			//	}
			}
		}
	}
}
