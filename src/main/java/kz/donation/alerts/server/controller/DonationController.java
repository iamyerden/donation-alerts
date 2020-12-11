package kz.donation.alerts.server.controller;

import kz.donation.alerts.server.model.Donation;
import kz.donation.alerts.server.service.IAccountService;
import kz.donation.alerts.server.service.IDonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class DonationController {

    @Autowired
    IDonationService donationService;

    @Autowired
    IAccountService accountService;

    @RequestMapping(value = "/public/donation/all/iterable", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<Donation> getAllIterable() {
        return donationService.getAllDonations();
    }

    @RequestMapping(value = "/public/donation/read/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public Donation get(@PathVariable("id") Integer id) {
        return donationService.getDonationById(id);
    }

    @RequestMapping(value = "/public/donation/create", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Donation create(@RequestBody Donation donation) {
        System.out.println(donation.toString());
        accountService.changeCashAccount(donation.getReceiver_id(), donation.getAmount());
        return donationService.addDonation(donation);
    }

    @RequestMapping(value = "/public/donation/update", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    public Donation update(@RequestBody Donation donation) {
        return donationService.updateDonation(donation);
    }

    @RequestMapping(value = "/public/donation/delete/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
    public void deleteById(@PathVariable("id") Integer id) {
        donationService.deleteByDonationId(id);
    }
}
