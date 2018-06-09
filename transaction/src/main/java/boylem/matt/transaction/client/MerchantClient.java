package boylem.matt.transaction.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import boylem.matt.transaction.domain.Merchant;

@FeignClient("merchant")
/**
 * MerchantClient. Proxies requests to /merchant
 * 
 * @author Matt Boyle
 *
 */
public interface MerchantClient {

	@RequestMapping("/{id}")
	/**
	 * find a merchant by id/
	 * 
	 * @param id
	 * @return Merchant
	 */
	public Merchant findMerchantById(@PathVariable("id") long id);

}
