import java.util.ArrayList;
import java.util.List;

public class StatesGenerator {
    private void add(List<State> successors, State newNode, State parentNode) {
        if (newNode.isValid()) {
            newNode.setParentNode(parentNode);
            successors.add(newNode);
        }
    }

    List<State> states(State state) {
        List<State> successors = new ArrayList<>();
        if (state.getPos() == Boat.LEFT) {


            //person driver
            //peopleLeft -1 peopleLeft -2  peopleRight +2//
            add(successors, new State(state.getPeopleLeft()-3,state.getMonkeysLeft(),state.getPeopleRight()+3,state.getMonkeysRight(),Boat.RIGHT, Driver.PERSON),state);
            //peopleLeft -1 MonkeyLeft -2 MonkeyRight +2
            add(successors, new State(state.getPeopleLeft()-1,state.getMonkeysLeft()-2,state.getPeopleRight()+1,state.getMonkeysRight()+2,Boat.RIGHT, Driver.PERSON),state);
            //peopleLeft -1 MonkeyLeft -1 MonkeyRight +1 peopleLeft -1  peopleRight +1
            add(successors, new State(state.getPeopleLeft()-1,state.getMonkeysLeft()-2,state.getPeopleRight()+1,state.getMonkeysRight()+2,Boat.RIGHT, Driver.PERSON),state);
           //one driver
            add(successors, new State(state.getPeopleLeft()-1,state.getMonkeysLeft(),state.getPeopleRight()+1,state.getMonkeysRight(),Boat.RIGHT, Driver.PERSON),state);
           //driver+monl
            add(successors, new State(state.getPeopleLeft()-1,state.getMonkeysLeft()-1,state.getPeopleRight()+1,state.getMonkeysRight()+1,Boat.RIGHT, Driver.PERSON),state);
           //driver+pers
            add(successors, new State(state.getPeopleLeft()-2,state.getMonkeysLeft(),state.getPeopleRight()+2,state.getMonkeysRight(),Boat.RIGHT, Driver.PERSON),state);

            //Monkey driver
            //MonkeyLeft -1 peopleLeft -2  peopleRight +2
            add(successors, new State(state.getPeopleLeft()-2,state.getMonkeysLeft()-1,state.getPeopleRight()+2,state.getMonkeysRight(),Boat.RIGHT, Driver.MONKEY),state);
            //MonkeyLeft -1 MonkeyLeft -2 MonkeyRight +2
            add(successors, new State(state.getPeopleLeft(),state.getMonkeysLeft()-3,state.getPeopleRight(),state.getMonkeysRight()+2,Boat.LEFT, Driver.MONKEY),state);
            //MonkeyLeft -1 MonkeyLeft -1 MonkeyRight +1 peopleLeft -1  peopleRight +1
            add(successors, new State(state.getPeopleLeft()-1,state.getMonkeysLeft()-1,state.getPeopleRight()+1,state.getMonkeysRight()+1,Boat.LEFT, Driver.PERSON),state);
            //driver+monl
            add(successors, new State(state.getPeopleLeft()-1,state.getMonkeysLeft()-1,state.getPeopleRight(),state.getMonkeysRight()+1,Boat.RIGHT, Driver.MONKEY),state);
            //driver+pers
            add(successors, new State(state.getPeopleLeft()-2,state.getMonkeysLeft(),state.getPeopleRight()+1,state.getMonkeysRight(),Boat.RIGHT, Driver.MONKEY),state);
            //one driver
            add(successors, new State(state.getPeopleLeft()-1,state.getMonkeysLeft(),state.getPeopleRight()+1,state.getMonkeysRight(),Boat.RIGHT, Driver.MONKEY),state);


        } else {
           //person driver
            //peopleLeft -1 peopleLeft +2  peopleRight -2
            //peopleLeft -1 MonkeyLeft +2 MonkeyRight -2
            //peopleLeft -1 MonkeyLeft =1 MonkeyRight +1 peopleLeft -1  peopleRight +1
            //Monkey driver

            //MonkeyLeft -1 peopleLeft +2  peopleRight =2
            //MonkeyLeft -1 MonkeyLeft +2 MonkeyRight =2
            //MonkeyLeft -1 MonkeyLeft +1 MonkeyRight -1
            // peopleLeft -1  peopleRight +
            //person driver
            //peopleLeft -1 peopleLeft -2  peopleRight +2//
            add(successors, new State(state.getPeopleLeft()-3,state.getMonkeysLeft(),state.getPeopleRight()+3,state.getMonkeysRight(),Boat.LEFT, Driver.PERSON),state);
            //peopleLeft -1 MonkeyLeft -2 MonkeyRight +2
            add(successors, new State(state.getPeopleLeft()-1,state.getMonkeysLeft()-2,state.getPeopleRight()+1,state.getMonkeysRight()+2,Boat.LEFT, Driver.PERSON),state);
            //peopleLeft -1 MonkeyLeft -1 MonkeyRight +1 peopleLeft -1  peopleRight +1
            add(successors, new State(state.getPeopleLeft()-1,state.getMonkeysLeft()-2,state.getPeopleRight(),state.getMonkeysRight()+2,Boat.LEFT, Driver.PERSON),state);
            //one driver
            add(successors, new State(state.getPeopleLeft()-1,state.getMonkeysLeft(),state.getPeopleRight()+1,state.getMonkeysRight(),Boat.LEFT, Driver.PERSON),state);
            //driver+monl
            add(successors, new State(state.getPeopleLeft()-1,state.getMonkeysLeft()-1,state.getPeopleRight()+1,state.getMonkeysRight()+1,Boat.LEFT,  Driver.PERSON),state);
            //driver+pers
            add(successors, new State(state.getPeopleLeft()-2,state.getMonkeysLeft(),state.getPeopleRight()+2,state.getMonkeysRight(),Boat.LEFT,  Driver.PERSON),state);

            //Monkey driver
            //MonkeyLeft -1 peopleLeft -2  peopleRight +2
            add(successors, new State(state.getPeopleLeft()-2,state.getMonkeysLeft()-1,state.getPeopleRight()+2,state.getMonkeysRight(),Boat.LEFT, Driver.MONKEY),state);
            //MonkeyLeft -1 MonkeyLeft -2 MonkeyRight +2
            add(successors, new State(state.getPeopleLeft(),state.getMonkeysLeft()-3,state.getPeopleRight(),state.getMonkeysRight()+2,Boat.LEFT, Driver.MONKEY),state);
            //MonkeyLeft -1 MonkeyLeft -1 MonkeyRight +1 peopleLeft -1  peopleRight +1
            add(successors, new State(state.getPeopleLeft()-1,state.getMonkeysLeft()-1,state.getPeopleRight()+1,state.getMonkeysRight()+1,Boat.LEFT, Driver.MONKEY),state);
            //driver+monl
            add(successors, new State(state.getPeopleLeft()-1,state.getMonkeysLeft()-1,state.getPeopleRight(),state.getMonkeysRight()+1,Boat.LEFT,  Driver.MONKEY),state);
            //driver+pers
            add(successors, new State(state.getPeopleLeft()-2,state.getMonkeysLeft(),state.getPeopleRight()+1,state.getMonkeysRight(),Boat.LEFT,  Driver.MONKEY),state);
            //one driver
            add(successors, new State(state.getPeopleLeft()-1,state.getMonkeysLeft(),state.getPeopleRight()+1,state.getMonkeysRight(),Boat.LEFT, Driver.MONKEY),state);
        }
        return successors;
    }



   /*public List<State> states(State state) {
       List<State> successors = new ArrayList<>();
       if (state.getPos() == Boat.LEFT) {
           add(successors, new State(state.getPeopleLeft(),state.getMonkeysLeft()-2,
                   state.getPeopleRight(),state.getMonkeysRight()+2,Boat.RIGHT, Driver.PERSON),state);

           add(successors, new State(state.getPeopleLeft()-2,state.getMonkeysLeft(),state.getPeopleRight()+2,state.getMonkeysRight(),Boat.RIGHT, Driver.PERSON),state);

           add(successors, new State(state.getPeopleLeft()-1,state.getMonkeysLeft()-1,
                   state.getPeopleRight()+1,state.getMonkeysRight()+1,Boat.RIGHT, Driver.PERSON),state);

           add(successors, new State(state.getPeopleLeft(),state.getMonkeysLeft()-1,
                   state.getPeopleRight(),state.getMonkeysRight()+1,Boat.RIGHT, Driver.PERSON),state);

           add(successors, new State(state.getPeopleLeft()-1,state.getMonkeysLeft(),
                   state.getPeopleRight()+1,state.getMonkeysRight(),Boat.RIGHT, Driver.PERSON),state);



        add(successors, new State(state.getPeopleLeft(),state.getMonkeysLeft()-2,
                   state.getPeopleRight(),state.getMonkeysRight()+2,Boat.RIGHT, Driver.MONKEY),state);

           add(successors, new State(state.getPeopleLeft()-2,state.getMonkeysLeft(),state.getPeopleRight()+2,state.getMonkeysRight(),Boat.RIGHT, Driver.PERSON),state);

           add(successors, new State(state.getPeopleLeft()-1,state.getMonkeysLeft()-1,
                   state.getPeopleRight()+1,state.getMonkeysRight()+1,Boat.RIGHT, Driver.MONKEY),state);

           add(successors, new State(state.getPeopleLeft(),state.getMonkeysLeft()-1,
                   state.getPeopleRight(),state.getMonkeysRight()+1,Boat.RIGHT, Driver.MONKEY),state);

           add(successors, new State(state.getPeopleLeft()-1,state.getMonkeysLeft(),
                   state.getPeopleRight()+1,state.getMonkeysRight(),Boat.RIGHT, Driver.MONKEY),state);


       } else {
           add(successors, new State(state.getPeopleLeft(),state.getMonkeysLeft()+2,
                   state.getPeopleRight(),state.getMonkeysRight()-2,Boat.LEFT, Driver.PERSON),state);

           add(successors, new State(state.getPeopleLeft()+2,state.getMonkeysLeft(),
                   state.getPeopleRight()-2,state.getMonkeysRight(),Boat.RIGHT, Driver.PERSON),state);

           add(successors, new State(state.getPeopleLeft()+1,state.getMonkeysLeft()+1,
                   state.getPeopleRight()-1,state.getMonkeysRight()-1,Boat.LEFT, Driver.PERSON),state);

           add(successors, new State(state.getPeopleLeft(),state.getMonkeysLeft()+1,
                   state.getPeopleRight(),state.getMonkeysRight()-1,Boat.LEFT, Driver.PERSON),state);

           add(successors, new State(state.getPeopleLeft()+1,state.getMonkeysLeft(),
                   state.getPeopleRight()-1,state.getMonkeysRight(),Boat.LEFT, Driver.PERSON),state);






/*
           add(successors, new State(state.getPeopleLeft(),state.getMonkeysLeft()+2,
                   state.getPeopleRight(),state.getMonkeysRight()-2,Boat.LEFT, Driver.MONKEY),state);

           add(successors, new State(state.getPeopleLeft()+2,state.getMonkeysLeft(),
                   state.getPeopleRight()-2,state.getMonkeysRight(),Boat.RIGHT, Driver.MONKEY),state);

           add(successors, new State(state.getPeopleLeft()+1,state.getMonkeysLeft()+1,
                   state.getPeopleRight()-1,state.getMonkeysRight()-1,Boat.LEFT, Driver.MONKEY),state);

           add(successors, new State(state.getPeopleLeft(),state.getMonkeysLeft()+1,
                   state.getPeopleRight(),state.getMonkeysRight()-1,Boat.LEFT, Driver.MONKEY),state);

           add(successors, new State(state.getPeopleLeft()+1,state.getMonkeysLeft(),
                   state.getPeopleRight()-1,state.getMonkeysRight(),Boat.LEFT, Driver.MONKEY),state);



       }
       return successors;
   }
   */


}
