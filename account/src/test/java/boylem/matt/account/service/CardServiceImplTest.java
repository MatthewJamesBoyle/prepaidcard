package boylem.matt.account.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import boylem.matt.account.dao.AccountDao;
import boylem.matt.account.dao.CardDao;
import boylem.matt.account.domain.Account;
import boylem.matt.account.domain.Card;
import boylem.matt.account.domain.CardStatus;
import boylem.matt.account.domain.Deposit;
import boylem.matt.account.exception.AccountNotFoundException;
import boylem.matt.account.exception.CardNotFoundException;
import boylem.matt.account.exception.CouldNotCreateAccountException;

@RunWith(SpringRunner.class)
public class CardServiceImplTest {

	@TestConfiguration
	static class CardServiceImplTestContextConfiguration {

		@Bean
		public CardService cardService() {
			return new CardServiceImpl();
		}
	}

	@Autowired
	private CardService cardService;

	@MockBean
	AccountDao accountDao;

	@MockBean
	CardDao cardDao;

	private Account account;

	@Before
	public void setUp() {
		account = new Account(1L, "Matt", "Boyle", 10L, 10L);
		Mockito.when(accountDao.findById(account.getId())).thenReturn(account);

		Card card = new Card(new Date(), new Date(), 12345678L, account, CardStatus.ACTIVE);
		Mockito.when(cardDao.findCardById(1L)).thenReturn(card);
	}

	@Test
	public void createCardTest() throws AccountNotFoundException {
		Card card = cardService.createCard(1L);
		assertThat(card.getAccount().getId()).isEqualTo(1L);
	}

	@Test
	public void freezeCardTest() throws CardNotFoundException {
		Card card = cardService.freezeCard(1L);
		assertThat(card.getCardStatus()).isEqualTo(CardStatus.FROZEN);
	}

	@Test
	public void closeCardTest() throws CardNotFoundException {
		Card card = cardService.closeCard(1L);
		assertThat(card.getCardStatus()).isEqualTo(CardStatus.DEACTIVATED);
	}

}
