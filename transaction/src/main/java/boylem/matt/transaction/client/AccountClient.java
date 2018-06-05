package boylem.matt.transaction.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import boylem.matt.transaction.domain.Card;

@FeignClient("account")
public interface AccountClient {

	@RequestMapping("/{id}")
	public Card findCardById(@PathVariable("id") long id);

	@RequestMapping("/{id}/authorize")
	public Card authorizePayment(@PathVariable("id") long id);

	public void finalizeTransaction(Long cardId, Long amount);

}
