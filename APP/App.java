import java.util.ArrayList;
import java.util.Scanner;

import Account.UserAccount;
import Authentication.Authentication;
import Authentication.BankAuthentication;
import Authentication.WalletAuthentication;

public class App {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int answer = 0;
        boolean run = true;
        UserAccount account;
        String status = "registration";
        System.out.println("Welcome to Instapay Application:)");
        System.out.println("Would you like to: ");
        while (run) {
            // clearScreen();
            ArrayList<String> menu = getMainMenu(status);
            for (int i = 0; i < menu.size(); i++) {
                System.out.println("    " + (i + 1) + "." + menu.get(i));
            }
            System.out.println();
            System.out.println("Select Action: ");
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
                    status = "actions";
                    break;
                }
                case "Sign Up": {
                    System.out.println("Select Account Type.");
                    System.out.println("1. Bank Account");
                    System.out.println("2. Wallet Account");
                    String type = scanner.nextLine();
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

                        System.out.println("Account Added, Please Log In.");
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

                        System.out.println("Account Added, Please Log In.");
                        break;
                    }
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