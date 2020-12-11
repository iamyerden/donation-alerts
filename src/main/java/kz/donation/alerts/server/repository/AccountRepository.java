package kz.donation.alerts.server.repository;

import kz.donation.alerts.server.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account getById(Integer id);
    Account getByUsername(String username);

    @Query(value = "Select * FROM account WHERE username like %?1%", nativeQuery = true)
    List<Account> search(String username);
}
