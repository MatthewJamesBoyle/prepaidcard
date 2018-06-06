package boylem.matt.merchant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import boylem.matt.merchant.domain.Merchant;
import boylem.matt.merchant.exception.MerchantCreationException;
import boylem.matt.merchant.service.MerchantService;

@RestController
public class MerchantController {

	@Autowired
	MerchantService merchantService;

	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Merchant createTransaction(Merchant merchant) throws MerchantCreationException {
		return merchantService.create(merchant);
	}
}
