package boylem.matt.transaction.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import boylem.matt.transaction.domain.Account;
import boylem.matt.transaction.domain.Card;

@FeignClient("account")
public interface AccountClient {

	@RequestMapping("/card/{id}")
	public Card findCardById(@PathVariable("id") long id);

	@RequestMapping("/{id}/authorize/{amount}")
	public Card authorizePayment(@PathVariable("id") long id, @PathVariable("amount") long amount);

	@RequestMapping("/card/{cardId}/amount/{amount}/finalize")
	public Account finalizeTransaction(@PathVariable Long cardId, @PathVariable Long amount);

	@RequestMapping("/{cardId}/{amount}/updateBalance")
	public void updateBalance(@PathVariable("cardId") Long cardId, @PathVariable("amount") Long amount);
}
