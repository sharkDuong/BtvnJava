package Module_2;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private Employee employeeInCharge;
    private List<Transaction> transactions;

    public Account(String accountNumber, String accountHolder, double balance, Employee employeeInCharge) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.employeeInCharge = employeeInCharge;
        this.transactions = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction("Nạp tiền", amount));
    }

    public void withdraw(double amount) throws Exception {
        if (amount > balance) {
            throw new Exception("Số dư không đủ.");
        }
        balance -= amount;
        transactions.add(new Transaction("Rút tiền", amount));
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setEmployeeInCharge(Employee employee) {
        this.employeeInCharge = employee;
    }

    @Override
    public String toString() {
        return String.format("Số tài khoản: %s\nTên chủ tài khoản: %s\nSố dư: %.2f",
                accountNumber, accountHolder, balance);
    }
}