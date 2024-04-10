package course.springdata.springdata.service;

import course.springdata.springdata.entity.Account;
import course.springdata.springdata.entity.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface AccountService {

    Account createUserAccount(User user, Account account);
    void depositMoney(BigDecimal amount, Long accountId);
    void withdrawMoney(BigDecimal amount, Long accountId);
    void transferMoney(BigDecimal amount, Long fromId, Long toId);

    List<Account> getAllAccounts();
}
