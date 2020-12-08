package kz.donation.alerts.server.service.impl;

import kz.donation.alerts.server.model.Donation;
import kz.donation.alerts.server.repository.DonationRepository;
import kz.donation.alerts.server.service.IDonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationService implements IDonationService {

    @Autowired
    DonationRepository donationRepository;

    @Override
    public Donation addDonation(Donation donation) {
        return donationRepository.save(donation);
    }

    @Override
    public List<Donation> getAllDonations() {
        return donationRepository.findAll();
    }

    @Override
    public Donation getDonationById(Integer id) {
        return donationRepository.getById(id);
    }

    @Override
    public Donation updateDonation(Donation donation) {
        return donationRepository.save(donation);
    }

    @Override
    public void deleteByDonationId(Integer id) {
        donationRepository.deleteById(id);
    }
}
