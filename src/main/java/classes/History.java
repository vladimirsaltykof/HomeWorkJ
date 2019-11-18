package classes;

import java.util.Date;

public class History {
    private static long countId = 0;
    private long id;            // целое число, уникальный идентификатор перевода
    private String fromAccount; // строка, номер счета-источника перевода денег
    private String toAccount;   // строка, номер счета-получателя перевода денег
    private double amount;      // число с плавающей точкой, сумма перевода
    private Date date;          // дата и время осуществления перевода (любой формат, который может прочитать человек, т.е. не timestamp)

    public History(String fromAccount, String toAccount, double amount, Date date) {

        this.id = countId++;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.date = date;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
