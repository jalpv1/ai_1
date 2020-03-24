enum Driver {
    MONKEY, PERSON,INIT
}

enum Bank {
    LEFT, RIGHT
}

public class Node {
    private int peopleLeft;
    private int smallMonkeysLeft;
    private int bigMonkeysLeft;

    private int peopleRight;
    private int smallMonkeysRight;
    private int bigMonkeysRight;

    private Bank pos;
    private Node parentNode;
    private Driver driver;

    public Node(int peopleLeft, int smallMonkeysLeft, int bigMonkeysLeft, int peopleRight, int smallMonkeysRight, int bigMonkeysRight, Bank pos, Driver driver) {
        this.peopleLeft = peopleLeft;
        this.smallMonkeysLeft = smallMonkeysLeft;
        this.bigMonkeysLeft = bigMonkeysLeft;
        this.peopleRight = peopleRight;
        this.smallMonkeysRight = smallMonkeysRight;
        this.bigMonkeysRight = bigMonkeysRight;
        this.pos = pos;
        this.driver = driver;
    }

    public boolean isGoal() {
        return peopleLeft == 0 && bigMonkeysLeft == 0 && smallMonkeysLeft == 0 && peopleRight == 3 &&  smallMonkeysRight==2 && bigMonkeysRight==1;
    }

    public boolean isValid() {
        if (peopleLeft >= 0 && smallMonkeysLeft >= 0 && bigMonkeysLeft >= 0 && peopleRight >= 0 && smallMonkeysRight >= 0 && bigMonkeysRight >= 0
                && (peopleLeft == 0 || peopleLeft >= smallMonkeysLeft + bigMonkeysLeft)
                && (peopleRight == 0||peopleRight >= smallMonkeysRight + bigMonkeysRight) ){
            return true;
        }
        return false;
    }
    public boolean isValid1() {
        if (peopleLeft >= 0 && smallMonkeysLeft >= 0 && bigMonkeysLeft >= 0 && peopleRight >= 0 && smallMonkeysRight >= 0 && bigMonkeysRight >= 0
                 ){
            return true;
        }
        return false;
    }

    public int getPeopleLeft() {
        return peopleLeft;
    }

    public void setPeopleLeft(int peopleLeft) {
        this.peopleLeft = peopleLeft;
    }

    public int getSmallMonkeysLeft() {
        return smallMonkeysLeft;
    }

    public void setSmallMonkeysLeft(int smallMonkeysLeft) {
        this.smallMonkeysLeft = smallMonkeysLeft;
    }

    public int getBigMonkeysLeft() {
        return bigMonkeysLeft;
    }

    public void setBigMonkeysLeft(int bigMonkeysLeft) {
        this.bigMonkeysLeft = bigMonkeysLeft;
    }

    public int getPeopleRight() {
        return peopleRight;
    }

    public void setPeopleRight(int peopleRight) {
        this.peopleRight = peopleRight;
    }

    public int getSmallMonkeysRight() {
        return smallMonkeysRight;
    }

    public void setSmallMonkeysRight(int smallMonkeysRight) {
        this.smallMonkeysRight = smallMonkeysRight;
    }

    public int getBigMonkeysRight() {
        return bigMonkeysRight;
    }

    public void setBigMonkeysRight(int bigMonkeysRight) {
        this.bigMonkeysRight = bigMonkeysRight;
    }

    public Bank getPos() {
        return pos;
    }

    public void setPos(Bank pos) {
        this.pos = pos;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
    @Override
    public String toString() {
        return "PL " + peopleLeft + "," +" ML " +smallMonkeysLeft + " BML "+bigMonkeysLeft +" -------- "
                + " PR "+peopleRight + "," + " SMR "+ smallMonkeysRight +" BMR "+bigMonkeysRight + " Boat - " + pos + " D "+driver
                ;
    }
    /*@Override
    public String toString() {
        int ml = smallMonkeysLeft +bigMonkeysLeft;
        int mr =  smallMonkeysRight +bigMonkeysRight;
        return "PL " + peopleLeft + "," +" ML " +ml+" -------- "
                + " PR "+peopleRight + "," + " SMR "+ mr + " Boat - " + pos + " D "+driver
                ;
    }

     */

}
