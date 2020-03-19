import org.w3c.dom.Node;

import java.util.*;

public class Search {

    private StatesGenerator statesGenerator;

    public State execute(State initialNode) {
        int nodeNo = 0 ;
        int expanded = 0;
        statesGenerator = new StatesGenerator();
        if (initialNode.isGoal()) {
            return initialNode;
        }

        Queue<State> pq = new LinkedList<>();
        HashMap<State, Integer> map = new HashMap<>();

        pq.add(initialNode);

        while (!pq.isEmpty()) {
            State u = pq.poll();

            if (u.isGoal()) {
                return u;
            }

            map.put(u, nodeNo);

            expanded++;

            List<State> successors = statesGenerator.states(u);

            for (State v : successors) {
                if(contains(map,v)){
                    continue;
                }
                if(v.getMonkeysLeft()> v.getPeopleLeft() || v.getPeopleRight() < v.getMonkeysRight()){
                    continue;
                }



                    nodeNo++;

                    pq.add(v);

            }
        }

        return null;
    }
    boolean contains(HashMap<State,Integer> stateIntegerMap,State n){
        for (HashMap.Entry<State,Integer> e:  stateIntegerMap.entrySet() ) {
         if(e.getKey().equals(n)){
             return true;
         }
        }
        return false;
    }
}
