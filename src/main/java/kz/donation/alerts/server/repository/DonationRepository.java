package kz.donation.alerts.server.repository;

import kz.donation.alerts.server.model.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Integer> {
    Donation getById(Integer id);
}
