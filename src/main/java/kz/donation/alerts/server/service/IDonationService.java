package kz.donation.alerts.server.service;

import kz.donation.alerts.server.model.Donation;

import java.util.List;

public interface IDonationService {
    Donation addDonation(Donation donation);
    List<Donation> getAllDonations();
    Donation getDonationById(Integer id);
    Donation updateDonation(Donation donation);
    void deleteByDonationId(Integer id);
}
