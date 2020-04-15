public class Person {
    private int bank;
//1 - left 0 -right
    public Person(int bank) {
        this.bank = bank;
    }

    public int getBank() {
        return bank;
    }

    public void changeBank() {
        if (bank==1){
            bank = 0;
        } else {
            bank =1;

        }

    }

    public void setBank(int bank) {
        this.bank = bank;
    }
}
