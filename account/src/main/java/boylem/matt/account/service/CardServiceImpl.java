package boylem.matt.account.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boylem.matt.account.dao.AccountDao;
import boylem.matt.account.dao.CardDao;
import boylem.matt.account.domain.Account;
import boylem.matt.account.domain.Card;
import boylem.matt.account.domain.CardStatus;

@Service
public class CardServiceImpl implements CardService {

	@Autowired
	AccountDao accountDao;
	@Autowired
	CardDao cardDao;

	@Override
	public Card createCard(Long accId) {
		Account account = accountDao.findById(accId);
		Date expiryDate = new Date();
		expiryDate.setYear(expiryDate.getYear());
		Card card = new Card(new Date(), expiryDate, 12345678L, account, CardStatus.ACTIVE);
		cardDao.save(card);
		return card;
	}

	@Override
	public String freezeCard(Long cardId) {
		Card card = cardDao.findOne(cardId);
		card.setCardStatus(CardStatus.FROZEN);
		cardDao.save(card);
		return "successfully Frozen";
	}

	@Override
	public String closeCard(Long cardId) {
		Card card = cardDao.findOne(cardId);
		card.setCardStatus(CardStatus.DEACTIVATED);
		cardDao.save(card);
		return "successfully Closed Account";
	}

}
