import java.util.*;

public class LocalSearch {
    public Node hillClimbingAlgoritm(Node initNode) {
        int nextEval = -1000000;
        Node nextNode = null;
        GenerateSteps generator = new GenerateSteps();
        Node currentNode = initNode;
        LinkedList<Node> closed = new LinkedList<>();
        ArrayList<Node> oldSteps = new ArrayList<>();

        // create starting position and put to queue
        while (true) { // while queue is not empty
            // get from queue
            if (currentNode.isGoal()) {
                return currentNode;
            }
            if (!closed.contains(currentNode)) {
                closed.add(currentNode);
            }
            ArrayList<Node> steps = generator.generator(currentNode);
            // add them to queue
            // sort using eval as comparizon
            if (steps.isEmpty()) {
                return null;
            }
            Node max = steps.stream().max(Comparator.comparing(Node::getH)).get();
            for (Node step : steps) {
                if (closed.contains(step) || myContains(closed, step)) {
                    System.out.println("f");
                }
                if (!closed.contains(step) || !myContains(closed, step)) {

                    int eval = eval(step);
                    if (eval(step) >= nextEval) {
                        //                  nextNode = step;
                        nextEval = eval(step);
                        currentNode = step;
                    }


                }
                Random r = new Random();
                int pos = r.nextInt((steps.size() - 1 - 0) + 1) + 0;
                if (eval(max) < nextEval) {
                    currentNode = steps.get(pos);
                    // nextNode = max;

                }


            }

        }
    }public Node hillClimbingAlgoritm2(Node initNode) {
        int nextEval = -1000000;
        Node nextNode = null;
        GenerateSteps generator = new GenerateSteps();
        Node currentNode = initNode;
        LinkedList<Node> closed = new LinkedList<>();
        ArrayList<Node> oldSteps = new ArrayList<>();

        // create starting position and put to queue
        while (true) { // while queue is not empty
            // get from queue
            if (currentNode.isGoal()) {
                return currentNode;
            }
            if (!closed.contains(currentNode)) {
                closed.add(currentNode);
            }
            ArrayList<Node> steps = generator.generator(currentNode);
            // add them to queue
            // sort using eval as comparizon
            if (steps.isEmpty()) {
                return null;
            }
            Node max = steps.stream().max(Comparator.comparing(Node::getH)).get();
            for (Node step : steps) {
                if (closed.contains(step) || myContains(closed, step)) {
                    System.out.println("f");
                }
                if (!closed.contains(step) || !myContains(closed, step)) {

                    int eval = eval(step);
                    if (eval(step) >= nextEval) {
                        //                  nextNode = step;
                        nextEval = eval(step);
                        currentNode = step;
                    }


                }
                if (eval(max) < nextEval) {
                    currentNode = max;
                    // nextNode = max;

                }


            }

        }
    }

    public Node bfs(Node initNode) {
        Node nextNode = null;
        GenerateSteps generator = new GenerateSteps();
        //Node currentNode = initNode;
        LinkedList<Node> closed = new LinkedList<>();
        Queue<Node> fr = new LinkedList<>();
        fr.add(initNode);
        // create starting position and put to queue
        while (!fr.isEmpty()) { // while queue is not empty
            // get from queue

            Node currentNode = fr.poll();
            if (!closed.contains(nextNode)) {
                closed.add(currentNode);
            }
            if (currentNode.isGoal()) {
                return currentNode;
            }
            ArrayList<Node> steps = generator.generator(currentNode);
            // add them to queue
            // sort using eval as comparizon
            if (steps.isEmpty()) {
                continue;
            }
            for (Node step : steps) {
                if (!myContains(closed, step)) {
                    fr.add(step);
                }

            }
            //  nextEval = steps.get(1).h;
            // if(nextEval<=eval(currentNode)){
// }


        }
        return null;

    }

    public Node hillClimbingAlgoritm3(Node initNode) {
        int nextEval = -1000000;
        GenerateSteps generator = new GenerateSteps();
        Node currentNode = initNode;
        // create starting position and put to queue
        while (true) { // while queue is not empty
            // get from queue
            if (currentNode.isGoal()) {
                return currentNode;
            }

            ArrayList<Node> steps = generator.generator(currentNode);
            // add them to queue
            // sort using eval as comparizon
            if (steps.isEmpty()) {
                return null;
            }
            Node max = steps.stream().max(Comparator.comparing(Node::getH)).get();
            if (eval(currentNode) >= eval(max)) {
                currentNode = max;
            }
            for (Node step : steps) {


                int eval = eval(step);
                if (eval(step) >= nextEval) {
                    //                  nextNode = step;
                    nextEval = eval(step);
                    currentNode = step;


                } else {
                    return currentNode;
                }


            }

        }
    }


    public Node exec(Node initialState) {
        if (initialState.isGoal()) {
            return initialState;
        }
        GenerateSteps generator = new GenerateSteps();

        Queue<Node> frontier = new LinkedList<Node>();    // FIFO queue
        LinkedList<Node> explored = new LinkedList<>();
        frontier.add(initialState);
        while (true) {
            if (frontier.isEmpty()) {
                return null;    // failure
            }
            Node state = frontier.poll();
            explored.add(state);
            List<Node> successors = generator.generator(state);
            // select with max euristic
            // while not
            for (Node child : successors) {

                if (!myContains(explored, child) && !myContains(frontier, child)) {
                    if (child.isGoal()) {
                        return child;
                    }
                    frontier.add(child);
                }
            }
        }
    }

    private boolean myContains(LinkedList<Node> nodes, Node node) {
        for (Node el : nodes) {
            if (Arrays.equals(el.getHusbands().toArray(), node.getHusbands().toArray()) &&
                    Arrays.equals(el.getWives().toArray(), node.getWives().toArray()) && node.getBoatPos().equals(el.getBoatPos())) {
                return true;
            }
        }
        return false;
    }

    private boolean myContains(Queue<Node> nodes, Node node) {
        for (Node el : nodes) {
            if (Arrays.equals(el.getHusbands().toArray(), node.getHusbands().toArray()) &&
                    Arrays.equals(el.getWives().toArray(), node.getWives().toArray()) && node.getBoatPos().equals(el.getBoatPos())) {
                return true;
            }
        }
        return false;
    }

    public int eval(Node n) {
      /*  return (int) ((n.getHusbands().stream().filter(huspos -> huspos.equals(Bank.RIGHT)).count() +
                n.getWives().stream().filter(wifepos -> wifepos.equals(Bank.RIGHT)).count()) -
                (n.getHusbands().stream().filter(huspos -> huspos.equals(Bank.LEFT)).count() +
                        n.getWives().stream().filter(wifepos -> wifepos.equals(Bank.LEFT)).count()));

       */
        return (int) ((n.getHusbands().stream().filter(huspos -> huspos.equals(Bank.RIGHT)).count() +
                n.getWives().stream().filter(wifepos -> wifepos.equals(Bank.RIGHT)).count()) -
                10);
    }
}
