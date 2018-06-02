package boylem.matt.account.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

	@RequestMapping(value = "/card/create", method = RequestMethod.POST)
	public Card createCard(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("------------------------------- REQUEST" + request.getParameter("accountId"));
		Long accountId = Long.parseLong(request.getParameter("accountId"));
		return cardService.createCard(2L);
	}

	@RequestMapping(value = "/card/freeze", method = RequestMethod.POST)
	public String freezeCard(@RequestParam("accountId") Long accountId, @RequestParam("cardId") Long cardId) {
		return cardService.freezeCard(accountId, cardId);
	}

	@RequestMapping(value = "/card/close", method = RequestMethod.POST)
	public String closeCard(@Valid @RequestBody Long accountId, @Valid @RequestBody Long cardId) {
		return cardService.closeCard(accountId, cardId);
	}

}
