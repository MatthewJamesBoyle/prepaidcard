package boylem.matt.account.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import boylem.matt.account.dao.CardDao;
import boylem.matt.account.domain.Card;
import boylem.matt.account.service.AccountService;
import boylem.matt.account.service.CardService;

@RestController
public class CardController {

	@Autowired
	private CardService cardService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private CardDao cardDao;

	@RequestMapping(value = "/card/create/{accountId}", method = RequestMethod.POST)
	public Card createCard(@PathVariable("accountId") long accountId) {
		return cardService.createCard(accountId);
	}

	@RequestMapping(value = "/card/freeze/{cardId}", method = RequestMethod.POST)
	public String freezeCard(@RequestParam("cardId") long cardId) {
		return cardService.freezeCard(cardId);
	}

	@RequestMapping(value = "/card/close/{cardId}", method = RequestMethod.POST)
	public String closeCardd(@RequestParam("cardId") long cardId) {
		return cardService.closeCard(cardId);
	}

}