package Module_2;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class BankSystem {
    private Map<String, Account> accounts = new HashMap<>();
    private Map<String, Employee> employees = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BankSystem bankSystem = new BankSystem();
        bankSystem.run();
    }

    public void run() {
        while (true) {
            System.out.println("Chọn chức năng:");
            System.out.println("1. Quản lý tài khoản");
            System.out.println("2. Giao dịch tài khoản");
            System.out.println("3. Quản lý giao dịch");
            System.out.println("4. Quản lý nhân viên");
            System.out.println("5. Thoát chương trình");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng mới

            switch (choice) {
                case 1:
                    manageAccounts();
                    break;
                case 2:
                    manageTransactions();
                    break;
                case 3:
                    manageTransactionHistory();
                    break;
                case 4:
                    manageEmployees();
                    break;
                case 5:
                    exitProgram();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private void manageAccounts() {
        System.out.println("1. Thêm tài khoản mới");
        System.out.println("2. Sửa thông tin tài khoản");
        System.out.println("3. Xóa tài khoản");
        System.out.println("4. Tìm kiếm tài khoản");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Đọc dòng mới

        switch (choice) {
            case 1:
                addAccount();
                break;
            case 2:
                editAccount();
                break;
            case 3:
                deleteAccount();
                break;
            case 4:
                searchAccount();
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    private void manageTransactions() {
        System.out.println("1. Nạp tiền vào tài khoản");
        System.out.println("2. Rút tiền từ tài khoản");
        System.out.println("3. Chuyển khoản giữa hai tài khoản");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Đọc dòng mới

        switch (choice) {
            case 1:
                depositToAccount();
                break;
            case 2:
                withdrawFromAccount();
                break;
            case 3:
                transferBetweenAccounts();
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    private void manageTransactionHistory() {
        System.out.println("1. Hiển thị lịch sử giao dịch của một tài khoản");
        System.out.println("2. Hiển thị toàn bộ giao dịch trong hệ thống");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Đọc dòng mới

        switch (choice) {
            case 1:
                showTransactionHistory();
                break;
            case 2:
                showAllTransactions();
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    private void manageEmployees() {
        System.out.println("1. Thêm nhân viên mới");
        System.out.println("2. Xem danh sách nhân viên");
        System.out.println("3. Gán tài khoản cho nhân viên");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Đọc dòng mới

        switch (choice) {
            case 1:
                addEmployee();
                break;
            case 2:
                viewEmployees();
                break;
            case 3:
                assignAccountToEmployee();
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    private void addAccount() {
        System.out.print("Nhập số tài khoản: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Nhập tên chủ tài khoản: ");
        String accountHolder = scanner.nextLine();
        System.out.print("Nhập số dư ban đầu: ");
        double balance = scanner.nextDouble();
        scanner.nextLine(); // Đọc dòng mới
        System.out.print("Nhập ID nhân viên phụ trách: ");
        String employeeId = scanner.nextLine();

        Employee employee = employees.get(employeeId);
        if (employee == null) {
            System.out.println("Nhân viên không tồn tại.");
            return;
        }

        Account account = new Account(accountNumber, accountHolder, balance, employee);
        accounts.put(accountNumber, account);
        System.out.println("Tài khoản đã được thêm thành công!");
        System.out.println(account);
    }

    private void editAccount() {
        System.out.print("Nhập số tài khoản cần sửa: ");
        String accountNumber = scanner.nextLine();
        Account account = accounts.get(accountNumber);

        if (account == null) {
            System.out.println("Tài khoản không tồn tại.");
            return;
        }

        System.out.print("Nhập tên chủ tài khoản mới: ");
        String newAccountHolder = scanner.nextLine();
        System.out.print("Nhập số dư mới: ");
        double newBalance = scanner.nextDouble();
        scanner.nextLine(); // Đọc dòng mới

        account.setAccountHolder(newAccountHolder);
        account.setBalance(newBalance);
        System.out.println("Thông tin tài khoản đã được cập nhật!");
    }

    private void deleteAccount() {
        System.out.print("Nhập số tài khoản cần xóa: ");
        String accountNumber = scanner.nextLine();

        if (accounts.remove(accountNumber) != null) {
            System.out.println("Tài khoản đã được xóa thành công!");
        } else {
            System.out.println("Tài khoản không tồn tại.");
        }
    }

    private void searchAccount() {
        System.out.print("Nhập số tài khoản cần tìm: ");
        String accountNumber = scanner.nextLine();
        Account account = accounts.get(accountNumber);

        if (account != null) {
            System.out.println(account);
        } else {
            System.out.println("Tài khoản không tồn tại.");
        }
    }

    private void depositToAccount() {
        System.out.print("Nhập số tài khoản: ");
        String accountNumber = scanner.nextLine();
        Account account = accounts.get(accountNumber);

        if (account == null) {
            System.out.println("Tài khoản không tồn tại.");
            return;
        }

        System.out.print("Nhập số tiền nạp: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
        System.out.println("Nạp tiền thành công!");
    }

    private void withdrawFromAccount() {
        System.out.print("Nhập số tài khoản: ");
        String accountNumber = scanner.nextLine();
        Account account = accounts.get(accountNumber);

        if (account == null) {
            System.out.println("Tài khoản không tồn tại.");
            return;
        }

        System.out.print("Nhập số tiền rút: ");
        double amount = scanner.nextDouble();
        try {
            account.withdraw(amount);
            System.out.println("Rút tiền thành công!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void transferBetweenAccounts() {
        System.out.print("Nhập số tài khoản nguồn: ");
        String fromAccountNumber = scanner.nextLine();
        System.out.print("Nhập số tài khoản đích: ");
        String toAccountNumber = scanner.nextLine();

        Account fromAccount = accounts.get(fromAccountNumber);
        Account toAccount = accounts.get(toAccountNumber);

        if (fromAccount == null || toAccount == null) {
            System.out.println("Một trong hai tài khoản không tồn tại.");
            return;
        }

        System.out.print("Nhập số tiền chuyển: ");
        double amount = scanner.nextDouble();
        try {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
            System.out.println("Chuyển khoản thành công!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void showTransactionHistory() {
        System.out.print("Nhập số tài khoản: ");
        String accountNumber = scanner.nextLine();
        Account account = accounts.get(accountNumber);

        if (account == null) {
            System.out.println("Tài khoản không tồn tại.");
            return;
        }

        List<Transaction> transactions = account.getTransactions();
        if (transactions.isEmpty()) {
            System.out.println("Không có giao dịch nào.");
        } else {
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }

    private void showAllTransactions() {
        for (Account account : accounts.values()) {
            for (Transaction transaction : account.getTransactions()) {
                System.out.println(transaction);
            }
        }
    }

    private void addEmployee() {
        System.out.print("Nhập ID nhân viên: ");
        String id = scanner.nextLine();
        System.out.print("Nhập tên nhân viên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập lương nhân viên: ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); // Đọc dòng mới

        Employee employee = new Employee(id, name, salary);
        employees.put(id, employee);
        System.out.println("Nhân viên đã được thêm thành công!");
    }

    private void viewEmployees() {
        for (Employee employee : employees.values()) {
            System.out.println(employee);
        }
    }

    private void assignAccountToEmployee() {
        System.out.print("Nhập số tài khoản: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Nhập ID nhân viên: ");
        String employeeId = scanner.nextLine();

        Account account = accounts.get(accountNumber);
        Employee employee = employees.get(employeeId);

        if (account == null) {
            System.out.println("Tài khoản không tồn tại.");
            return;
        }
        if (employee == null) {
            System.out.println("Nhân viên không tồn tại.");
            return;
        }

        account.setEmployeeInCharge(employee);
        System.out.println("Tài khoản đã được gán cho nhân viên thành công!");
    }

    private void exitProgram() {
        System.out.println("Cảm ơn bạn đã sử dụng hệ thống quản lý tài khoản. Hẹn gặp lại!");
        System.exit(0);
    }
}