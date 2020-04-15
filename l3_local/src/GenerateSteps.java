import java.util.ArrayList;
import java.util.stream.IntStream;

public class GenerateSteps {
    private ArrayList<Node> steps;
    private int wifeMove = 1;
    private int husbandMove = 0;

    public GenerateSteps() {
        steps = new ArrayList<>();
    }

    public ArrayList<Node> generator(Node node) {

        steps.clear();
        moveOneperson(node);
        moveCouples(node);
        movePair(node, wifeMove);
        movePair(node, husbandMove);
        moveTrio(node, wifeMove);
        moveTrio(node, husbandMove);
        moveCoupleAndHusband(node);


        return steps;
    }

    private boolean isValidMove(Node node) {
        int countRChild = (int) (node.getHusbands().stream().filter(i -> i.equals(Bank.RIGHT)).count() + node.getWives().stream().filter(i -> i.equals(Bank.RIGHT)).count());
        int countRParent = (int) (node.getParentNode().getHusbands().stream().filter(i -> i.equals(Bank.RIGHT)).count() + node.getParentNode().getWives().stream().filter(i -> i.equals(Bank.RIGHT)).count());
        int countLChild = (int) (node.getHusbands().stream().filter(i -> i.equals(Bank.LEFT)).count() + node.getWives().stream().filter(i -> i.equals(Bank.LEFT)).count());
        ;
        int countLParent = (int) (node.getParentNode().getHusbands().stream().filter(i -> i.equals(Bank.LEFT)).count() + node.getParentNode().getWives().stream().filter(i -> i.equals(Bank.LEFT)).count());
        ;

        if (node.getParentNode().getBoatPos().equals(Bank.LEFT)) {
            //если у родителя лодка на левом берегу значит у нас перемещение на правый значит на левом берегу не могло стать больше людей или остаться прежним
            if (countLChild >= countLParent) {
                return false;
            }
        }
        if (node.getParentNode().getBoatPos().equals(Bank.RIGHT)) {
            //если у родителя лодка на правом берегу значит у нас перемещение на правый значит на правом берегу не могло стать больше людей или остаться прежним
            if (countRChild >= countRParent) {
                return false;
            }
        }
        //количество не может не измениться
        if (countLChild == countLParent && countRChild == countLChild) {
            return false;
        }
        return true;
    }

    private void addNewStep(Node node) {
        boolean v1 = node.isValid();
        boolean v2 = isValidMove(node);
        if (node.isValid() && isValidMove(node)) {
            steps.add(node);
        }
    }

    private Bank switchBank(Bank person) {

        if (person.equals(Bank.LEFT)) {
            person = Bank.RIGHT;
        } else {
            person = Bank.LEFT;
        }
        return person;
    }

    private Bank moveBoat(Node nodeParent) {
        if (nodeParent.getBoatPos().equals(Bank.LEFT)) {
            return Bank.RIGHT;
        } else {
            return Bank.LEFT;
        }
    }

    private ArrayList<Bank> move(ArrayList<Bank> people, int... pos) {
        IntStream.range(0, pos.length).forEach(i -> people.set(pos[i], switchBank(people.get(pos[i]))));
        return people;
    }

    private ArrayList<Bank> clean(ArrayList<Bank> a, ArrayList<Bank> old) {
        /*a.clear();
      /  ArrayList<Bank> newM = new ArrayList<>(old.size());
        for (int i = 0; i < old.size(); i++) {
            newM.set(i, old.get(i));
        }

         */
        return new ArrayList<>(old);

    }

    private ArrayList<Bank> myclone(ArrayList<Bank> collection) {
        return new ArrayList<>(collection);
    }

    private void moveOneperson(Node node) {
        // ArrayList<Bank> husbands = (ArrayList<Bank>) node.getHusbands().clone();
        //ArrayList<Bank> wives = (ArrayList<Bank>) node.getWives().clone();
        ArrayList<Bank> husbands = myclone(node.getHusbands());
        ArrayList<Bank> wives = myclone(node.getWives());
        ArrayList<Bank> husbandsCopy = myclone(node.getHusbands());
        ArrayList<Bank> wivesCopy = myclone(node.getWives());
        for (int i = 0; i < husbands.size(); i++) {
            // i == bank
            if (husbands.get(i).equals(node.getBoatPos())) {
                addNewStep(new Node(myclone(move(husbands, i)), myclone(wives), node, moveBoat(node)));
                //husbands.stream().map(h->h=Bank.LEFT).collect(Collectors.toList());
                husbands = clean(husbands, husbandsCopy);
                wives = clean(wives, wivesCopy);
                //moveBoat(node);
            }
        }
        for (int j = 0; j < wives.size(); j++) {
            if (wives.get(j).equals(node.getBoatPos())) {
                //addNewStep(new Node((ArrayList<Bank>) husbands.clone(), (ArrayList<Bank>) move(wives, j).clone(), node, moveBoat(node)));
                addNewStep(new Node(myclone(husbands), myclone(move(wives, j)), node, moveBoat(node)));

                husbands = clean(husbands, husbandsCopy);
                wives = clean(wives, wivesCopy);

            }
        }

    }

    private void moveCouples(Node node) {
        ArrayList<Bank> husbands = myclone(node.getHusbands());
        ArrayList<Bank> wives = myclone(node.getWives());
        ArrayList<Bank> husbandsCopy = myclone(node.getHusbands());
        ArrayList<Bank> wivesCopy = myclone(node.getWives());
        for (int i = 0; i < husbands.size(); i++) {
            if (husbands.get(i).equals(node.getBoatPos()) && wives.get(i).equals(node.getBoatPos())) { // муж  и жена на одном берегу и лодка доступна
                Node step = new Node((ArrayList<Bank>) move(husbands, i).clone(), (ArrayList<Bank>) move(wives, i).clone(), node, moveBoat(node));
                addNewStep(step);
                husbands = clean(husbands, husbandsCopy);
                wives = clean(wives, wivesCopy);
            }
        }

    }

    private void moveCoupleAndHusband(Node node) {
        ArrayList<Bank> husbands = myclone(node.getHusbands());
        ArrayList<Bank> wives = myclone(node.getWives());
        ArrayList<Bank> husbandsCopy = myclone(node.getHusbands());
        ArrayList<Bank> wivesCopy = myclone(node.getWives());
        for (int i = 0; i < husbands.size(); i++) {
            //ориентируемся по индексу мужей =пара
            for (int j = 0; j < husbands.size(); j++) {
                if (j != i) {
                    //все на одном берегу и лодка доступна
                    if (node.getBoatPos().equals(husbands.get(i)) && husbands.get(i) == wives.get(i) && husbands.get(j) == wives.get(i)) {
                        addNewStep(new Node((ArrayList<Bank>) move(husbands, i, j).clone(), (ArrayList<Bank>) move(wives, i).clone(), node, moveBoat(node)));
                        husbands = clean(husbands, husbandsCopy);
                        wives = clean(wives, wivesCopy);

                    }

                }
            }
        }

    }

    private void movePair(Node node, int flag) {
        ArrayList<Bank> husbands = myclone(node.getHusbands());
        ArrayList<Bank> wives = myclone(node.getWives());
        ArrayList<Bank> husbandsCopy = myclone(node.getHusbands());
        ArrayList<Bank> wivesCopy = myclone(node.getWives());
        // 0 - husbands
        if (flag == 0) {
            for (int i = 0; i < husbands.size(); i++) {
                for (int j = 0; j < husbands.size(); j++) {
                    if (i != j) {
                        if (husbands.get(i).equals(node.getBoatPos()) && husbands.get(i).equals(husbands.get(j)))// доступний човен і вони знаходяться на олному березі
                            addNewStep(new Node((ArrayList<Bank>) move(husbands, i, j).clone(), (ArrayList<Bank>) wives.clone(), node, moveBoat(node)));
                        husbands = clean(husbands, husbandsCopy);
                        wives = clean(wives, wivesCopy);


                    }
                }
            }
        }
        //1 - wives
        if (flag == 1) {
            for (int i = 0; i < wives.size(); i++) {
                for (int j = 0; j < wives.size(); j++) {
                    if (i != j) {
                        if (wives.get(i).equals(node.getBoatPos()) && wives.get(i).equals(wives.get(j))) {// доступний човен і вони знаходяться на олному березі
                            addNewStep(new Node((ArrayList<Bank>) husbands.clone(), (ArrayList<Bank>) move(wives, i, j).clone(), node, moveBoat(node)));
                            husbands = clean(husbands, husbandsCopy);
                            wives = clean(wives, wivesCopy);

                        }

                    }
                }
            }
        }
    }

    private void moveTrio(Node node, int flag) {
        ArrayList<Bank> husbands = myclone(node.getHusbands());
        ArrayList<Bank> wives = myclone(node.getWives());
        ArrayList<Bank> husbandsCopy = myclone(node.getHusbands());
        ArrayList<Bank> wivesCopy = myclone(node.getWives());
        // 0 - husbands
        if (flag == 0) {
            for (int i = 0; i < husbands.size(); i++) {
                for (int j = 0; j < husbands.size(); j++) {
                    for (int n = 0; n < husbands.size(); n++) {
                        if (i != j && j != n && i != n) {

                            if (husbands.get(i).equals(node.getBoatPos()) && husbands.get(i).equals(husbands.get(j)) && husbands.get(i).equals(husbands.get(n))) {// доступний човен і вони знаходяться на олному березі

                                addNewStep(new Node((ArrayList<Bank>) move(husbands, i, j, n).clone(), (ArrayList<Bank>) wives.clone(), node, moveBoat(node)));
                                husbands = clean(husbands, husbandsCopy);
                                wives = clean(wives, wivesCopy);


                            }
                        }
                    }
                }
            }
        }
        //1 - wives
        if (flag == 1) {
            for (int i = 0; i < wives.size(); i++) {
                for (int j = 0; j < wives.size(); j++) {
                    for (int n = 0; n < wives.size(); n++) {

                        if (i != j && j != n && i != n) {
                            if (wives.get(i).equals(node.getBoatPos()) && wives.get(i).equals(wives.get(j)) && wives.get(i).equals(wives.get(n))) {// доступний човен і вони знаходяться на олному березі

                                addNewStep(new Node((ArrayList<Bank>) husbands.clone(), (ArrayList<Bank>) move(wives, i, j, n).clone(), node, moveBoat(node)));
                                husbands = clean(husbands, husbandsCopy);
                                wives = clean(wives, wivesCopy);

                            }
                        }
                    }

                }
            }
        }
    }

}
