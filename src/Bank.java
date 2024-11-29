import java.util.HashMap;
import java.util.Map;

class Bank implements BankSystem {
    static Map<Integer, Object[]> database = new HashMap<>();
    Object[] account;

    public void create(int idNumber, int balance, String pin) {
        account = new Object[] { balance, pin };
        database.put(idNumber, account);
    }

    public void deposit(int idNumber, int amount) {
        Object[] userData = getData(idNumber);
        userData[0] = (int) userData[0] + amount;
        database.put(idNumber, userData);
        System.out.println("Your new balance is: " + userData[0]);
    }

    public void withdraw(int idNumber, int amount) {
        Object[] userData = getData(idNumber);
        int balance = (int) userData[0];
        if (balance < amount) {
            System.out.println("Insuffiecent amount to withdraw");
        } else {
            userData[0] = (int) userData[0] - amount;
            database.put(idNumber, userData);
            System.out.println("Your new balance is: " + userData[0]);
        }
    }

    public void checkBalance(int idNumber) {
        Object[] userData = getData(idNumber);
        System.out.println("Your current balance is: " + userData[0]);
    }

    private Object[] getData(int idNumber) {
        return database.get(idNumber);
    }

    public boolean checkAccount(int idNumber, String pin) {
        if (database.containsKey(idNumber)) {
            Object[] userData = getData(idNumber);
            String userPin = userData[1].toString();
            if (pin.equals(userPin)) {
                return true;
            } else {
                return true;
            }
        } else {
            return false;

        }
    }
}