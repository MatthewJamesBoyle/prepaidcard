package boylem.matt.transaction.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import boylem.matt.transaction.domain.Merchant;

@FeignClient("merchant")
public interface MerchantClient {

	@RequestMapping("/{id}")
	public Merchant findMerchantById(@PathVariable("id") long id);

}
