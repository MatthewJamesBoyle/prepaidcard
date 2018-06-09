package boylem.matt.transaction.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import boylem.matt.transaction.domain.Account;
import boylem.matt.transaction.domain.Card;

@FeignClient("account")
/**
 * AccountClient. Proxies requests to /account
 * 
 * @author Matt Boyle
 *
 */
public interface AccountClient {

	@RequestMapping("/card/{id}")
	/**
	 * Find a card by card id.
	 * 
	 * @param id
	 *            card Id.
	 * @return Card.
	 */
	public Card findCardById(@PathVariable("id") long id);

	@RequestMapping("/{id}/authorize/{amount}")
	/**
	 * authorise a payment for amount.
	 * 
	 * @param id
	 *            card id.
	 * @param amount
	 *            amount to request.
	 * @return Card.
	 */
	public Card authorizePayment(@PathVariable("id") long id, @PathVariable("amount") long amount);

	@RequestMapping("/card/{cardId}/amount/{amount}/finalize")
	/**
	 * Finalize a payment for amount.
	 * 
	 * @param cardId
	 *            card id.
	 * @param amount
	 *            amount to finalize.
	 * @return Account.
	 */
	public Account finalizeTransaction(@PathVariable("cardId") Long cardId, @PathVariable("amount") Long amount);

	@RequestMapping("/refund/{cardId}/{amount}/updateBalance")
	/**
	 * refund a card for amount.
	 * 
	 * @param cardId
	 *            card id.
	 * @param amount
	 *            amount to refund.
	 */
	public void refund(@PathVariable("cardId") Long cardId, @PathVariable("amount") Long amount);
}
