public class User {
    private int id;
    private String firstName;
    private String lastName;
    private int balance;

    public User(int id, String firstName, String lastName, int balance) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }

    public void decreaseMoney(int delta) {
        balance -= delta;
    }

    public int getBalance() {
        return balance;
    }

    public String getInfo() {
        return firstName + " " + lastName + " " + balance + "$";
    }

    public String getName() {
        return firstName + " " + lastName;
    }
}
