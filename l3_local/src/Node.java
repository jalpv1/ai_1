import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

enum Bank {
    LEFT, RIGHT
}

public class Node {
    private ArrayList<Bank> husbands;
    private ArrayList<Bank> wives;
    private Node parentNode;
    private Bank boatPos;
    int h;

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int eval() {
    /*    return (int) (getHusbands().stream().filter(huspos -> huspos.equals(Bank.RIGHT)).count() +
                getWives().stream().filter(wifepos -> wifepos.equals(Bank.RIGHT)).count()     -   (getHusbands().stream().filter(huspos -> huspos.equals(Bank.LEFT)).count() +
                getWives().stream().filter(wifepos -> wifepos.equals(Bank.LEFT)).count()));

     */
        return (int) (getHusbands().stream().filter(huspos -> huspos.equals(Bank.RIGHT)).count() +
                getWives().stream().filter(wifepos -> wifepos.equals(Bank.RIGHT)).count()     - 10);
    }

    public boolean isValid() {
        for (int i = 0; i < wives.size(); i++) {
            // если итая жена находится на разных берегах со ствоим итым мужем то других мужей на этом береге быть не должно
            Bank pos = wives.get(i);
            int count = (int) (husbands.stream().filter(huspos -> huspos.equals(pos)).count() );
            if (wives.get(i) != husbands.get(i) && count != 0) {
//int husbands.stream().filter(huspos -> huspos.equals(pos)).count()
                return false;


            }
        }
        return true;
    }

    public boolean isGoal() {
        int i = (int) (husbands.stream().filter(huspos -> huspos.equals(Bank.RIGHT)).count() +
                wives.stream().filter(wifepos -> wifepos.equals(Bank.RIGHT)).count());
        if (i == 10)
            return true;
        return false;
    }

    public Node(ArrayList<Bank> husbands, ArrayList<Bank> wives, Node parentNode, Bank boatPos) {
        this.husbands = husbands;
        this.wives = wives;
        this.parentNode = parentNode;
        this.boatPos = boatPos;
        h = eval();
        //this.lastMove = parentNode.boatPos;
    }

    public Node() {
        husbands = new ArrayList<>();
        wives = new ArrayList<>();
        parentNode = null;
        boatPos = Bank.LEFT;

        //this.lastMove = parentNode.boatPos;
    }

    public ArrayList<Bank> getHusbands() {
        return husbands;
    }



    public ArrayList<Bank> getWives() {
        return wives;
    }



    public Node getParentNode() {
        return parentNode;
    }


    public Bank getBoatPos() {
        return boatPos;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        Arrays.equals(getHusbands().toArray(), node.getHusbands().toArray());
        return compareArr(getHusbands(), node.getHusbands()) &&
                compareArr(getWives(), node.getWives()) &&
                getBoatPos().equals(node.getBoatPos());
    }

    private boolean compareArr(ArrayList<Bank> f, ArrayList<Bank> s) {
        boolean check = true;
        for (int i = 0; i < f.size(); i++) {
            for (int j = 0; j < s.size(); j++) {
                if (!f.get(i).equals(s.get(j))) {
                    check = false;
                }
            }
        }
        return check;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHusbands(), getWives(), getParentNode(), getBoatPos());
    }

    @Override
    public String toString() {
        return "Node{" +
                "husbands=" + husbands +
                ", wives=" + wives +

                ", boatPos =" + boatPos +

                '}';
    }
}
