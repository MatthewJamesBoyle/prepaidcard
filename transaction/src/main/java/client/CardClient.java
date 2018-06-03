package client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import boylem.matt.transaction.domain.Card;

@FeignClient("Card")
public interface CardClient {

	@RequestMapping("/{id}")
	public Card findCardById(@PathVariable("id") long id);

}
