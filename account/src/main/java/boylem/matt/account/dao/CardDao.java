package boylem.matt.account.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import boylem.matt.account.domain.Account;
import boylem.matt.account.domain.Card;

public interface CardDao extends JpaRepository<Card, Long> {

	public Card findCardById(Long cardId);

}
