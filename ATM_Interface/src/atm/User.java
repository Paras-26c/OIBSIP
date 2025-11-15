package atm;

public class User {
    private String userId;
    private String pin;
    private BankAccount account;

    public User(String userId, String pin, BankAccount account) {
        this.userId = userId;
        this.pin = pin;
        this.account = account;
    }

    public boolean validate(String uid, String upin) {
        return this.userId.equals(uid) && this.pin.equals(upin);
    }

    public BankAccount getAccount() {
        return account;
    }
}

