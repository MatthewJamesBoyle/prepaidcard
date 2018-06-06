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
public class CardServiceImpl implements CardService {

	@Autowired
	AccountDao accountDao;
	@Autowired
	CardDao cardDao;

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

	public Card freezeCard(Long cardId) throws CardNotFoundException {
		Card card = cardDao.findOne(cardId);
		if (card == null) {
			throw new CardNotFoundException(cardId);
		}
		card.setCardStatus(CardStatus.FROZEN);
		cardDao.save(card);
		return card;
	}

	public Card closeCard(Long cardId) throws CardNotFoundException {
		Card card = cardDao.findOne(cardId);
		if (card == null) {
			throw new CardNotFoundException(cardId);
		}
		card.setCardStatus(CardStatus.DEACTIVATED);
		cardDao.save(card);
		return card;
	}

}
