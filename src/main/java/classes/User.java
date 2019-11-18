package classes;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class User {
    private static int countId = 0;
    private Map<String, Double> accounts;
    private List<History> history;


    public User() {
        this.accounts = new ConcurrentHashMap<>();
        this.history = Collections.synchronizedList(new ArrayList<>());
    }

    public Map<String, Double> getAccounts() {
        return accounts;
    }

    public void addAccount(Double amount) {
        String id = "" + (countId + 1);
        this.accounts.put(id, amount);
        countId++;
    }

    public double getAmount(String id) {
        return accounts.get(id);
    }

    public void setAmount(String id, double amount) {
        if (this.accounts.containsKey(id)) {
            this.accounts.put(id, amount);
        }
    }

    public List<History> getHistory() {
        return history;
    }
}
