import java.util.Scanner;

public class Main {
    final static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String pin;
        int id;

        Bank bank = new Bank();
        boolean check = false;
        boolean checkAcc;

        System.out.println("Welcome to bank system");
        do {
            System.out.println("Please select your choices");
            System.out.println("[1] - Create account\n" +
                    "[2] - Deposit\n" +
                    "[3] - Withdraw\n" +
                    "[4] - Check Balance\n" +
                    "[5] - Exit");
            System.out.print("Enter your choice: ");
            String userChoice = input.nextLine();
            switch (userChoice) {
                case "1":
                    System.out.print("Enter your pin number: ");
                    pin = input.nextLine();
                    int uniqueId = genUniqueId();
                    bank.create(uniqueId, 1_000, pin);
                    System.out.println("Your Unique Id is: " + uniqueId + "\nYour pin is: " + pin);
                    break;
                case "2":
                    System.out.print("Enter your Unique Id: ");
                    id = input.nextInt();
                    input.nextLine();
                    System.out.print("Enter your pin: ");
                    pin = input.nextLine();
                    checkAcc = bank.checkAccount(id, pin);
                    if (checkAcc) {
                        System.out.print("Enter amount to deposit: ");
                        bank.deposit(id, input.nextInt());
                    } else {
                        System.out.println("Invalid unique Id or Pin Number");
                    }
                    break;
                case "3":
                    System.out.print("Enter your Unique Id: ");
                    id = input.nextInt();
                    input.nextLine();
                    System.out.print("Enter your pin: ");
                    pin = input.nextLine();
                    checkAcc = bank.checkAccount(id, pin);
                    if (checkAcc) {
                        System.out.print("Enter amount to withdraw: ");
                        bank.withdraw(id, input.nextInt());
                    } else {
                        System.out.println("Invalid unique Id or Pin Number");

                    }
                    break;
                case "4":
                    System.out.print("Enter your Unique Id: ");
                    id = input.nextInt();
                    input.nextLine();
                    System.out.print("Enter your pin: ");
                    pin = input.nextLine();
                    checkAcc = bank.checkAccount(id, pin);
                    if (checkAcc) {
                        bank.checkBalance(id);
                    } else {
                        System.out.println("Invalid unique Id or Pin Number");

                    }
                    break;
                case "5":
                    System.out.println("Goodbye");
                    check = true;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        } while (check != true);
    }

    private static int genUniqueId() {
        double randomNum = Math.random();
        int value = (int) (randomNum * (10_000_000 - 1_000_000 + 1)) + 1_000_000;
        return value;
    }
}
