package boylem.matt.account.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boylem.matt.account.dao.AccountDao;
import boylem.matt.account.dao.CardDao;
import boylem.matt.account.domain.Account;
import boylem.matt.account.domain.Card;
import boylem.matt.account.domain.CardStatus;
import boylem.matt.account.exception.AccountNotFoundException;
import boylem.matt.account.exception.CardNotFoundException;

@Service
/**
 * CardServiceImpl
 * 
 * @author MattBoyle
 *
 */
public class CardServiceImpl implements CardService {

	@Autowired
	/**
	 * Injected accountDao
	 */
	AccountDao accountDao;

	@Autowired
	/**
	 * injectedCardDao;
	 */
	CardDao cardDao;

	/**
	 * create card for accId.
	 * 
	 * @param accId.
	 *            id to link account to.
	 * @return Card.
	 * @throws AccountNotFoundException
	 */
	public Card createCard(Long accId) throws AccountNotFoundException {
		Account account = accountDao.findById(accId);
		if (account == null) {
			throw new AccountNotFoundException(accId);
		}
		Date expiryDate = new Date();
		expiryDate.setYear(expiryDate.getYear());
		Card card = new Card(new Date(), expiryDate, 12345678L, account, CardStatus.ACTIVE);
		cardDao.save(card);
		return card;
	}

	/**
	 * Update a card to frozen state.
	 * 
	 * @param cardId.
	 *            id of card to freeze.
	 * @return Card.
	 * @throws CardNotFoundException
	 */
	public Card freezeCard(Long cardId) throws CardNotFoundException {
		Card card = cardDao.findCardById(cardId);
		if (card == null) {
			throw new CardNotFoundException(cardId);
		}
		card.setCardStatus(CardStatus.FROZEN);
		cardDao.save(card);
		return card;
	}

	/**
	 * Update a card to closed stare.
	 * 
	 * @param cardId.
	 *            id of card to close.
	 * @return Card
	 * @throws CardNotFoundException
	 */
	public Card closeCard(Long cardId) throws CardNotFoundException {
		Card card = cardDao.findCardById(cardId);
		if (card == null) {
			throw new CardNotFoundException(cardId);
		}
		card.setCardStatus(CardStatus.DEACTIVATED);
		cardDao.save(card);
		return card;
	}

}
