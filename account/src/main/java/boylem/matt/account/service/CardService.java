package boylem.matt.account.service;

import boylem.matt.account.domain.Card;
import boylem.matt.account.exception.AccountNotFoundException;
import boylem.matt.account.exception.CardNotFoundException;

public interface CardService {

	Card createCard(Long accId) throws AccountNotFoundException;

	Card freezeCard(Long cardId) throws CardNotFoundException;

	Card closeCard(Long cardId) throws CardNotFoundException;

}
