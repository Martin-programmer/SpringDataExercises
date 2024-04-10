package course.springdata.springdata.dao;

import course.springdata.springdata.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
