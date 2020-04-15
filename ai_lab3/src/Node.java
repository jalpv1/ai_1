enum Bank {
    LEFT, RIGHT
}
public class State {
    public Bank bank;
    public int rh1;
    public int rh2;
    public int rh3;
    public int rh4;
    public int rh5;


    public int rw1;
    public int rw2;
    public int rw3;
    public int rw4;
    public int rw5;

    public int lh1;
    public int lh2;
    public int lh3;
    public int lh4;
    public int lh5;


    public int lw1;
    public int lw2;
    public int lw3;
    public int lw4;
    public int lw5;

    public State(Bank bank, int rh1, int rh2, int rh3, int rh4, int rh5, int rw1, int rw2, int rw3, int rw4, int rw5, int lh1, int lh2, int lh3, int lh4, int lh5, int lw1, int lw2, int lw3, int lw4, int lw5) {
        this.bank = bank;
        this.rh1 = rh1;
        this.rh2 = rh2;
        this.rh3 = rh3;
        this.rh4 = rh4;
        this.rh5 = rh5;
        this.rw1 = rw1;
        this.rw2 = rw2;
        this.rw3 = rw3;
        this.rw4 = rw4;
        this.rw5 = rw5;
        this.lh1 = lh1;
        this.lh2 = lh2;
        this.lh3 = lh3;
        this.lh4 = lh4;
        this.lh5 = lh5;
        this.lw1 = lw1;
        this.lw2 = lw2;
        this.lw3 = lw3;
        this.lw4 = lw4;
        this.lw5 = lw5;
    }
}
