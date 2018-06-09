package boylem.matt.merchant.service;

import boylem.matt.merchant.domain.Merchant;
import boylem.matt.merchant.exception.MerchantCreationException;

/**
 * Merchant service interface.
 * 
 * @author Matt Boyle
 *
 */
public interface MerchantService {

	/**
	 * Create a merchant.
	 * 
	 * @param merchant
	 *            merchant to create
	 * @return Merchant
	 * @throws MerchantCreationException
	 */
	Merchant create(Merchant merchant) throws MerchantCreationException;
}
