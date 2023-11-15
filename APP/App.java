import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Account.BankAccountUser;
import Account.BillManager.Bill.Bill;
import Account.UserAccount;
import Authentication.Authentication;
import Authentication.BankAuthentication;
import Authentication.WalletAuthentication;

public class App {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int answer = 0;
        boolean run = true;
        UserAccount account = null;
        String status = "registration";
        System.out.println("Welcome to Instapay Application:)");
        System.out.println("Would you like to: ");
        while (run) {
            // clearScreen();
            if (status.equals("actions")) {
                System.out
                        .println("\n----------------- Welcome Back " + account.getUserName() + " -----------------\n");
            }
            ArrayList<String> menu = getMainMenu(status);
            for (int i = 0; i < menu.size(); i++) {
                System.out.println("    " + (i + 1) + "." + menu.get(i));
            }
            System.out.println();
            System.out.print("Select Action: ");
            answer = Integer.parseInt(scanner.nextLine());
            // clearScreen();
            switch (menu.get(answer - 1)) {
                case "Log In": {
                    String username, password;
                    System.out.print("Enter Your Username: ");
                    username = scanner.nextLine();
                    System.out.print("Enter Your Password: ");
                    password = scanner.nextLine();
                    account = Authentication.login(username, password);
                    if (account != null) {
                        status = "actions";
                    }
                    break;
                }
                case "Sign Up": {
                    System.out.println();
                    System.out.println("1. Bank Account");
                    System.out.println("2. Wallet Account");
                    System.out.print("Select Account Type: ");
                    String type = scanner.nextLine();
                    System.out.println();
                    Authentication auth;
                    if (type.equals("1")) {
                        System.out.print("Enter Phone Number: ");
                        String phoneNumber = scanner.nextLine();
                        System.out.print("Enter Card Number: ");
                        String cardNumber = scanner.nextLine();
                        auth = new BankAuthentication(phoneNumber, cardNumber);

                        if (!auth.verifyInfo())
                            break;

                        System.out.print("Enter Username: ");
                        String username = scanner.nextLine();
                        System.out.print("Enter Password: ");
                        String password = scanner.nextLine();
                        if (!auth.Signup(username, password))
                            break;

                        System.out.println("\nAccount Added, Please Log In.");
                        break;
                    } else if (type.equals("2")) {
                        System.out.print("Enter Phone Number: ");
                        String phoneNumber = scanner.nextLine();
                        auth = new WalletAuthentication(phoneNumber);

                        if (!auth.verifyInfo())
                            break;

                        System.out.print("Enter Username: ");
                        String username = scanner.nextLine();
                        System.out.print("Enter Password: ");
                        String password = scanner.nextLine();
                        if (!auth.Signup(username, password))
                            break;

                        System.out.println("\nAccount Added, Please Log In.");
                        break;
                    }
                }
                case "Transfer Money": {
                    if (account instanceof BankAccountUser) {
                        status = "Transfer-Bank";
                    } else {
                        status = "Transfer-Normal";
                    }
                    break;
                }
                case "Transfer to another Instapay Account.": {
                    // Call Implementation Here
                    break;
                }
                case "Transfer to Wallet.": {
                    // Call Implementation Here
                    System.out.println("wallet transfer");
                    break;
                }
                case "Transfer to Bank Account.": {
                    System.out.println("bank transfer");
                    // Call Implementation Here
                    break;
                }
                case "Inquire Balance": {
                    System.out.println("\nYour Current Balance is: ");
                    System.out.print(account.inquireBalance());
                    break;
                }
                case "Pay Bills": {
                    List<Bill> accountBills = account.getBills();
                    int i = 1;
                    System.out.println("Your Bills: \n");
                    for (Bill bill : accountBills) {
                        System.out.println("    " + (i) + "." + bill);
                        i++;
                    }
                    System.out.println();
                    System.out.print("Select the Bill You Want to Pay: ");
                    int choice = Integer.parseInt(scanner.nextLine());
                    if (account.payBill(account.getBills().get(choice - 1))) {
                        System.out.println("The Selected Bill is Payed Successfully");
                    } else {
                        double billPrice = account.getBills().get(choice - 1).getPrice();
                        double balance = account.inquireBalance();
                        System.out.println("Your Balance is Insufficient. Please Deposit " + (billPrice - balance)
                                + " to be able to proceed.");
                    }
                    break;
                }
                case "Deposit Money": {
                    System.out.print("Enter the amount to deposit: ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    account.deposite(amount);
                    break;
                }
                case "Withdraw Money": {
                    System.out.print("Enter the amount to withdraw: ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    account.withdraw(amount);
                    break;
                }
                case "Quit": {
                    run = false;
                    break;
                }
            }
        }

    }

    public static ArrayList<String> getMainMenu(String status) {
        switch (status) {
            case "registration" -> {
                return new ArrayList<String>() {
                    {
                        add("Log In");
                        add("Sign Up");
                        add("Quit");
                    }
                };
            }
            case "actions" -> {
                return new ArrayList<String>() {
                    {
                        add("Transfer Money");
                        add("Inquire Balance");
                        add("Pay Bills");
                        add("Deposit Money");
                        add("Withdraw Money");
                        add("Quit");
                    }
                };
            }
            case "Transfer-Bank" -> {
                return new ArrayList<String>() {
                    {
                        add("Transfer to another Instapay Account.");
                        add("Transfer to Wallet.");
                        add("Transfer to Bank Account.");
                        add("Quit");
                    }
                };
            }
            case "Transfer-Normal" -> {
                return new ArrayList<String>() {
                    {
                        add("Transfer to another Instapay Account.");
                        add("Transfer to Wallet.");
                        add("Quit");
                    }
                };
            }
            default -> {
                return null;
            }
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
    }

}

/*
 * System.out.println(BankAPI.getUser("id", "1"));
 * System.out.println(WalletAPI.getUser("id", "5"));
 * 
 * UserAccount bankAccount = new BankAccountUser("usf_insta", "12345678901",
 * "1", "Password#123");
 * UserAccount walletAccount = new WalletAccountUser("usf_insta", "12345678905",
 * "5", "pAssword$12");
 * 
 * System.out.println(bankAccount.inquireBalance());
 * System.out.println(walletAccount.inquireBalance());
 * 
 * for (Bill bill : bankAccount.getBills()) {
 * System.out.println(bill);
 * }
 * System.out.println();
 * System.out.println(bankAccount.payBill(bankAccount.getBills().get(0)));
 * System.out.println(bankAccount.inquireBalance());
 * System.out.println(bankAccount.payBill(bankAccount.getBills().get(0)));
 * System.out.println(bankAccount.inquireBalance());
 * System.out.println(bankAccount.payBill(bankAccount.getBills().get(0)));
 * System.out.println(bankAccount.inquireBalance());
 * System.out.println(bankAccount.payBill(bankAccount.getBills().get(0)));
 * System.out.println(bankAccount.inquireBalance());
 * 
 * for (Bill bill : bankAccount.getBills()) {
 * System.out.println(bill);
 * }
 * 
 * System.out.println();
 * for (Bill bill : walletAccount.getBills()) {
 * System.out.println(bill);
 * }
 */