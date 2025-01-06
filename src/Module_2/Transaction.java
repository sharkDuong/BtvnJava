package Module_2;

import java.time.LocalDateTime;

public class Transaction {
    private String type;
    private double amount;
    private LocalDateTime timestamp;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return String.format("Giao dịch: %s, Số tiền: %.2f, Thời gian: %s",
                type, amount, timestamp);
    }
}