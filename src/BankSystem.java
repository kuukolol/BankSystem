public interface BankSystem {
    void create(int idNumber, int balance, String pin);

    void deposit(int idNumber, int amount);

    void withdraw(int idNumber, int amount);

    void checkBalance(int idNumber);

    boolean checkAccount(int idNumber, String pin);
}
