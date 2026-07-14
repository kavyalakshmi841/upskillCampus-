import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final String FILE_NAME = "accounts.txt";

    // Save Accounts to File
    public static void saveAccounts(ArrayList<Customer> customers) {

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));

            for (Customer customer : customers) {

                Account account = customer.getAccount();

                writer.write(
                        account.getAccountNumber() + "," +
                        customer.getCustomerName() + "," +
                        customer.getMobileNumber() + "," +
                        customer.getAddress() + "," +
                        account.getPassword() + "," +
                        account.getBalance());

                writer.newLine();
            }

            writer.close();

            System.out.println("Data Saved Successfully.");

        } catch (IOException e) {

            System.out.println("Error Saving File.");
        }
    }

    // Load Accounts from File
    public static ArrayList<Customer> loadAccounts() {

        ArrayList<Customer> customers = new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return customers;
        }

        try {

            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                int accountNumber = Integer.parseInt(data[0]);
                String name = data[1];
                String mobile = data[2];
                String address = data[3];
                String password = data[4];
                double balance = Double.parseDouble(data[5]);

                Account account = new Account(accountNumber, name, password, balance);

                Customer customer =
                        new Customer(name, mobile, address, account);

                customers.add(customer);
            }

            reader.close();

        } catch (Exception e) {

            System.out.println("Error Loading File.");
        }

        return customers;
    }
}
