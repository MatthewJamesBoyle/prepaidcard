package boylem.matt.merchant.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import boylem.matt.merchant.domain.Merchant;
import boylem.matt.merchant.exception.MerchantCreationException;
import boylem.matt.merchant.service.MerchantService;

@RestController
/**
 * Merchant Rest Controller
 * 
 * @author Matt Boyle
 *
 */
public class MerchantController {

	@Autowired
	/**
	 * Injected merchant service.
	 */
	MerchantService merchantService;

	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	/**
	 * Basic health check endpoint.
	 * 
	 * @return String "pong"
	 */
	public String ping() {
		return "pong";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	/**
	 * create Merchant.
	 * 
	 * @param merchant
	 * @return Merchant
	 * @throws MerchantCreationException
	 */
	public Merchant createMerchant(@Valid @RequestBody Merchant merchant) throws MerchantCreationException {
		return merchantService.create(merchant);
	}
}
