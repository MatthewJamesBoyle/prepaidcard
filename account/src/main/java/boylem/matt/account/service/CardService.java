package boylem.matt.account.service;

import boylem.matt.account.domain.Card;
import boylem.matt.account.exception.AccountNotFoundException;
import boylem.matt.account.exception.CardNotFoundException;

/**
 * CardService.
 * 
 * @author Matt Boyle.
 *
 */
public interface CardService {

	/**
	 * create card for accId.
	 * 
	 * @param accId.
	 *            id to link account to.
	 * @return Card.
	 * @throws AccountNotFoundException
	 */
	Card createCard(Long accId) throws AccountNotFoundException;

	/**
	 * Update a card to frozen state.
	 * 
	 * @param cardId.
	 *            id of card to freeze.
	 * @return Card.
	 * @throws CardNotFoundException
	 */
	Card freezeCard(Long cardId) throws CardNotFoundException;

	/**
	 * Update a card to closed stare.
	 * 
	 * @param cardId.
	 *            id of card to close.
	 * @return Card
	 * @throws CardNotFoundException
	 */
	Card closeCard(Long cardId) throws CardNotFoundException;

}
