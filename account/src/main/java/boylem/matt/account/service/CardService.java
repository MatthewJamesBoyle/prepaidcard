package boylem.matt.account.service;

import boylem.matt.account.domain.Card;

public interface CardService {

	Card createCard(Long accId);

	String freezeCard(Long cardId);

	String closeCard(Long cardId);

}
