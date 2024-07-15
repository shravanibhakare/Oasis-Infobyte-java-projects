import java.util.Scanner;
import javax.swing.JOptionPane;

class BankAcc {
    String name;
    String userName;
    String password;
    String accountNo;
    float balance = 10000f;
    int transactions = 0;
    String transactionHistory = "";

    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter your Name: ");
        this.name = sc.nextLine();
        System.out.println("\nEnter your Username: ");
        this.userName = sc.nextLine();
        System.out.println("\nEnter your Password: ");
        this.password = sc.nextLine();
        System.out.println("\nEnter your Account Number: ");
        this.accountNo = sc.nextLine();
        System.out.println("\nRegistration Successful. Please Log in to your Bank Account");
    }

    public boolean login() {
        boolean isLogin = false;
        Scanner sc = new Scanner(System.in);
        while (!isLogin) {
            System.out.println("\nEnter your username: ");
            String Username = sc.nextLine();
            if (Username.equals(userName)) {
                while (!isLogin) {
                    System.out.println("\nEnter your password: ");
                    String Password = sc.nextLine();
                    if (Password.equals(password)) {
                        System.out.println("\nLogin Successful");
                        isLogin = true;
                    } else {
                        System.out.println("\nIncorrect Password");
                    }
                }
            } else {
                System.out.println("\nUsername not found");
            }
        }
        return isLogin;
    }

    public void withdraw() {
        System.out.println("\nEnter Amount to Withdraw: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try {
            if (balance >= amount) {
                transactions++;
                balance -= amount;
                System.out.println("\nWithdrawal Successful.");
                String str = amount + " Rs Withdrawn\n";
                transactionHistory = transactionHistory.concat(str);
            } else {
                System.out.println("\nInsufficient Balance.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
        }
    }

    public void deposit() {
        System.out.println("\nEnter Amount to Deposit: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try {
            if (amount <= 10000f) {
                transactions++;
                balance += amount;
                System.out.println("\nDeposit Successful.");
                String str = amount + " Rs deposited\n";
                transactionHistory = transactionHistory.concat(str);
            } else {
                System.out.println("\nSorry. The limit is 10000.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
        }
    }

    public void transfer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Recipient's Name: ");
        String recipient = sc.nextLine();
        System.out.println("\nEnter Amount to transfer: ");
        float amount = sc.nextFloat();
        try {
            if (balance >= amount) {
                if (amount <= 50000f) {
                    transactions++;
                    balance -= amount;
                    System.out.println("\nSuccessfully Transferred to " + recipient);
                    String str = amount + " Rs transferred to " + recipient + "\n";
                    transactionHistory = transactionHistory.concat(str);
                } else {
                    System.out.println("\nSorry. The limit is 50000.");
                }
            } else {
                System.out.println("\nInsufficient Balance.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
        }
    }

    public void checkBalance() {
        System.out.println("\n" + balance + " Rs");
    }

    public void transHistory() {
        if (transactions == 0) {
            System.out.println("No Transactions happened");
        } else {
            System.out.print("\n" + transactionHistory);
        }
    }
}

public class ATM_Stat {
    public static void main(String args[]) {
        System.out.println("\n********************WELCOME TO ATM INTERFACE*******************");
        System.out.println("\n1.Register \n2.Exit");
        Scanner sc = new Scanner(System.in);
        BankAcc b = new BankAcc();
        System.out.println("Choose one option: ");
        int choose = sc.nextInt();

        if (choose == 1) {
            b.register();
            System.out.println("\n1.Login \n2.Exit");
            System.out.println("Enter your choice: ");
            int ch = sc.nextInt();
            sc.nextLine(); // consume newline

            if (ch == 1) {
                if (b.login()) {
                    String userInput = JOptionPane.showInputDialog(null,
                            "Enter 1 for Banking, 2 for Mini statement, and 3 for Exit");
                    int num = Integer.parseInt(userInput);
                    if (num == 1) {
                        System.out.println("Hey! You chose Banking.");
                        String bInput = JOptionPane.showInputDialog(null,
                                "Enter 1 for Withdraw, 2 for Transfer, and 3 for Checking Balance");
                        int BI = Integer.parseInt(bInput);

                        switch (BI) {
                            case 1:
                                b.withdraw();
                                break;

                            case 2:
                                b.transfer();
                                break;

                            case 3:
                                b.checkBalance();
                                break;

                            default:
                                System.out.println("Enter the correct option");
                                break;
                        }
                    } else if (num == 2) {
                        System.out.println("Dear customer, you have chosen Mini statement!");
                        System.out.println("You can get your transaction history using Mini statement");
                        System.out.println();
                        b.transHistory();
                    } else {
                        System.out.println("Dear account holder, you chose to Exit!");
                        System.exit(0);
                    }
                }
            } else {
                System.exit(0);
            }
        } else {
            System.exit(0);
        }
        sc.close();
    }
}
