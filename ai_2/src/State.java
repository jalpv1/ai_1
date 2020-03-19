public class State {
    public int getPeopleLeft() {
        return peopleLeft;
    }

    public void setPeopleLeft(int peopleLeft) {
        this.peopleLeft = peopleLeft;
    }

    public int getMonkeysLeft() {
        return monkeysLeft;
    }

    public void setMonkeysLeft(int monkeysLeft) {
        this.monkeysLeft = monkeysLeft;
    }

    public int getPeopleRight() {
        return peopleRight;
    }

    public void setPeopleRight(int peopleRight) {
        this.peopleRight = peopleRight;
    }

    public int getMonkeysRight() {
        return monkeysRight;
    }

    public void setMonkeysRight(int monkeysRight) {
        this.monkeysRight = monkeysRight;
    }

    public Boat getPos() {
        return pos;
    }

    public void setPos(Boat pos) {
        this.pos = pos;
    }

    public State getParentNode() {
        return parentNode;
    }

    public void setParentNode(State parentNode) {
        this.parentNode = parentNode;
    }

    public State(int peopleLeft, int monkeysLeft, int peopleRight, int monkeysRight, Boat pos, Driver driver) {
        this.peopleLeft = peopleLeft;
        this.monkeysLeft = monkeysLeft;
        this.peopleRight = peopleRight;
        this.monkeysRight = monkeysRight;
        this.pos = pos;
        this.parentNode = parentNode;
        this.driver = driver;
    }

    private int peopleLeft;
    private int monkeysLeft;
    private int peopleRight;
    private int monkeysRight;
    private Boat pos;
    private State parentNode;
    private Driver driver;

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
    public boolean isGoal() {
        return peopleLeft == 0 && monkeysLeft == 0;
    }

    public boolean isValid() {
        if (peopleLeft >= 0 && monkeysLeft >= 0 && monkeysRight >= 0 && peopleRight >= 0
                && (peopleLeft == 0 || peopleLeft >= monkeysLeft)
                && (peopleRight == 0 || peopleRight >= monkeysRight)) {
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return "PL " + peopleLeft + "," +"ML " +monkeysLeft + " -------- "
                + " PR "+peopleRight + "," + " MR "+ monkeysRight  + " Boat - " + pos
                ;
    }
}
