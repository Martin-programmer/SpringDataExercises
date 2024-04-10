package course.springdata.springdata.init;

import course.springdata.springdata.entity.Account;
import course.springdata.springdata.entity.User;
import course.springdata.springdata.service.AccountService;
import course.springdata.springdata.service.UserService;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ConsoleRunner implements CommandLineRunner {
    @Autowired
    private UserService userService;
    @Autowired
    private AccountService accountService;
    @Override
    public void run(String... args) throws Exception {
        User user1 = new User("Ivan Petrov",42);
        Account account1 = new Account(new BigDecimal(1500));

        user1 = userService.register(user1);
        account1 = accountService.createUserAccount(user1,account1);

        accountService.withdrawMoney(new BigDecimal(1000),account1.getId());
        accountService.depositMoney(new BigDecimal(800),account1.getId());
        accountService.getAllAccounts().forEach(System.out::println);

        User user2 = new User("Martin Pankov",20);
        Account account2 = new Account(new BigDecimal(2000));

        user2 = userService.register(user2);
        account2 = accountService.createUserAccount(user2,account2);

        accountService.transferMoney(new BigDecimal(500),user1.getId(),user2.getId());

    }
}
