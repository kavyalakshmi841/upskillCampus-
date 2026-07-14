import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Bank bank = new Bank();
    static Customer currentCustomer = null;

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n==================================");
            System.out.println("   BANKING INFORMATION SYSTEM");
            System.out.println("==================================");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Display All Accounts");
            System.out.println("4. Search Account");
            System.out.println("5. Delete Account");
            System.out.println("6. Exit");
            System.out.print("Enter Choice : ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    register();
                    break;

                case 2:
                    login();
                    break;

                case 3:
                    bank.displayAllCustomers();
                    break;

                case 4:
                    searchAccount();
                    break;

                case 5:
                    deleteAccount();
                    break;

                case 6:
                    System.out.println("Thank You...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    // Registration
    static void register() {

        System.out.println("\n===== REGISTRATION =====");

        System.out.print("Account Number : ");
        int accountNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Customer Name : ");
        String name = sc.nextLine();

        System.out.print("Mobile Number : ");
        String mobile = sc.nextLine();

        System.out.print("Address : ");
        String address = sc.nextLine();

        System.out.print("Password : ");
        String password = sc.nextLine();

        System.out.print("Initial Deposit : ");
        double balance = sc.nextDouble();

        Account account =
                new Account(accountNo, name, password, balance);

        Customer customer =
                new Customer(name, mobile, address, account);

        bank.addCustomer(customer);

        System.out.println("Registration Successful.");
    }

    // Login
    static void login() {

        System.out.println("\n===== LOGIN =====");

        System.out.print("Account Number : ");
        int accountNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Password : ");
        String password = sc.nextLine();

        Customer customer = bank.findCustomer(accountNo);

        if (customer != null &&
                customer.getAccount().getPassword().equals(password)) {

            currentCustomer = customer;

            System.out.println("Login Successful.");

            userMenu();

        } else {

            System.out.println("Invalid Login.");
        }
    }

    // User Menu
    static void userMenu() {

        while (true) {

            System.out.println("\n========== USER MENU ==========");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance Enquiry");
            System.out.println("4. Fund Transfer");
            System.out.println("5. Account Statement");
            System.out.println("6. Change Password");
            System.out.println("7. Transaction History");
            System.out.println("8. Logout");

            System.out.print("Enter Choice : ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    deposit();
                    break;

                case 2:
                    withdraw();
                    break;

                case 3:
                    balanceEnquiry();
                    break;

                case 4:
                    fundTransfer();
                    break;

                case 5:
                    accountStatement();
                    break;

                case 6:
                    changePassword();
                    break;

                case 7:
                    transactionHistory();
                    break;

                case 8:
                    return;

                default:
                    System.out.println("Invalid Choice.");
            }
        }
              }
