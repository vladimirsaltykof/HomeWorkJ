package classes;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.Date;
import java.util.List;


@org.springframework.web.bind.annotation.RestController
public class RestController {
    User user1 = new User(); //example

    {
        user1.addAccount(1000.0);
        user1.addAccount(2000.0);
        user1.addAccount(50000.0);
    }

    @RequestMapping(value = "/order/history", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<History> getHistory() {
        return user1.getHistory();
    }

    @RequestMapping(value = "/order/transfer/{fromAccount}={toAccount}={amount}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String message(@PathVariable("fromAccount") String fromAccount, @PathVariable("toAccount") String toAccount, @PathVariable("amount") double amount) {
        if (amount <= user1.getAccounts().get(fromAccount)) {
            makeTransfer(fromAccount, toAccount, amount);
            return "\"message\": \"Перевод успешно совершён. \nАккаунт " + fromAccount + ": " + user1.getAmount(fromAccount) + "\n" + "Аккаунт " + toAccount + ": " + user1.getAmount(toAccount) + "\"";
        } else
            return "\"message\": \"На счету недостаточно средств.\"";


    }

    @RequestMapping(method = RequestMethod.POST)
    public void makeTransfer(String fromAccount, String toAccount, double amount) {
        user1.setAmount(fromAccount, user1.getAccounts().get(fromAccount) - amount);
        user1.setAmount(toAccount, user1.getAccounts().get(toAccount) + amount);
        user1.getHistory().add(new History(fromAccount, toAccount, amount, new Date()));
    }

}
