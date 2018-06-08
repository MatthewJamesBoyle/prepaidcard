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
import boylem.matt.account.domain.Account;
import boylem.matt.account.domain.Card;
import boylem.matt.account.exception.AccountNotFoundException;
import boylem.matt.account.exception.CardNotFoundException;
import boylem.matt.account.service.AccountService;
import boylem.matt.account.service.CardService;

@RestController
/**
 * RestController for CardController.
 * 
 * @author Matt Boyle
 *
 */
public class CardController {

	@Autowired
	/**
	 * injected CardService.
	 */
	private CardService cardService;

	@Autowired
	/**
	 * Injected CardDao.
	 */
	private CardDao cardDao;

	@RequestMapping(value = "/card/create/{accountId}", method = RequestMethod.POST)
	/**
	 * Creates a card and links it to accountId
	 * 
	 * @param accountId.
	 *            account to be linked.
	 * @return Card.
	 * @throws AccountNotFoundException
	 *             Thrown if account can't be found.
	 */
	public Card createCard(@PathVariable("accountId") long accountId) throws AccountNotFoundException {
		return cardService.createCard(accountId);
	}

	@RequestMapping(value = "/card/{cardId}", method = RequestMethod.GET)
	/**
	 * Finds a card byId.
	 * 
	 * @param cardId.
	 *            id of Card to find.
	 * @return Card
	 * @throws CardNotFoundException.
	 *             Thrown if card can't be found.
	 */
	public Card findAccountById(@PathVariable Long cardId) throws CardNotFoundException {
		return cardDao.findCardById(cardId);
	}

	@RequestMapping(value = "/card/freeze/{cardId}", method = RequestMethod.POST)
	/**
	 * Freezes a card.
	 * 
	 * @param cardId.
	 *            id of card to freeze.
	 * @return Card.
	 * @throws CardNotFoundException.
	 *             Thrown if card can't be found.
	 */
	public Card freezeCard(@PathVariable("cardId") long cardId) throws CardNotFoundException {
		return cardService.freezeCard(cardId);
	}

	@RequestMapping(value = "/card/close/{cardId}", method = RequestMethod.POST)
	/**
	 * Updates the status of a card to closed.
	 * 
	 * @param cardId
	 *            id of card to close.
	 * @return Card.
	 * @throws CardNotFoundException.
	 *             Thrown if card cannot be found.
	 */
	public Card closeCard(@PathVariable("cardId") long cardId) throws CardNotFoundException {
		return cardService.closeCard(cardId);
	}

}
