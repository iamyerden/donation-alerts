package kz.donation.alerts.server.repository;

import kz.donation.alerts.server.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account getById(Integer id);
    Account getByUsername(String username);
}
