    // Deposit
    static void deposit() {

        System.out.print("Enter Amount : ");
        double amount = sc.nextDouble();

        currentCustomer.getAccount().deposit(amount);

        System.out.println("Amount Deposited Successfully.");
    }

    // Withdraw
    static void withdraw() {

        System.out.print("Enter Amount : ");
        double amount = sc.nextDouble();

        currentCustomer.getAccount().withdraw(amount);
    }

    // Balance Enquiry
    static void balanceEnquiry() {

        System.out.println("\n========== BALANCE ==========");
        System.out.println("Account Number : "
                + currentCustomer.getAccount().getAccountNumber());

        System.out.println("Account Holder : "
                + currentCustomer.getCustomerName());

        System.out.println("Available Balance : ₹"
                + currentCustomer.getAccount().getBalance());
    }

    // Fund Transfer
    static void fundTransfer() {

        System.out.print("Receiver Account Number : ");
        int receiver = sc.nextInt();

        System.out.print("Transfer Amount : ");
        double amount = sc.nextDouble();

        bank.transfer(
                currentCustomer.getAccount().getAccountNumber(),
                receiver,
                amount);

    }

    // Account Statement
    static void accountStatement() {

        System.out.println("\n========== ACCOUNT ==========");

        currentCustomer.displayCustomer();

        System.out.println("Current Balance : ₹"
                + currentCustomer.getAccount().getBalance());

    }

    // Change Password
    static void changePassword() {

        sc.nextLine();

        System.out.print("Old Password : ");
        String oldPass = sc.nextLine();

        if(currentCustomer.getAccount().getPassword().equals(oldPass)) {

            System.out.print("New Password : ");
            String newPass = sc.nextLine();

            currentCustomer.getAccount().setPassword(newPass);

            System.out.println("Password Updated Successfully.");

        } else {

            System.out.println("Wrong Password.");

        }

    }

    // Transaction History
    static void transactionHistory() {

        System.out.println("\n========== TRANSACTION HISTORY ==========");

        System.out.println("Deposit");
        System.out.println("Withdrawal");
        System.out.println("Fund Transfer");

        System.out.println("\nDetailed transaction storage can be implemented using ArrayList<Transaction>.");
    }

    // Search Account
    static void searchAccount() {

        System.out.print("Enter Account Number : ");

        int accountNo = sc.nextInt();

        Customer customer = bank.findCustomer(accountNo);

        if(customer != null) {

            customer.displayCustomer();

        } else {

            System.out.println("Account Not Found.");

        }

    }

    // Delete Account
    static void deleteAccount() {

        System.out.print("Enter Account Number : ");

        int accountNo = sc.nextInt();

        bank.deleteCustomer(accountNo);

    }

          }
