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
import boylem.matt.account.exception.CouldNotCreateAccountException;

@RunWith(SpringRunner.class)
public class AccountServiceImplTest {

	@TestConfiguration
	static class AccountServiceImplTestContextConfiguration {

		@Bean
		public AccountService accountService() {
			return new AccountServiceImpl();
		}
	}

	@Autowired
	private AccountService accountService;

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
	public void getBalanceReturnsBalance() throws AccountNotFoundException {
		assertThat(accountService.getBalance(1L).getAvailableBalance()).isEqualTo(account.getAvailableBalance());
	}

	@Test(expected = AccountNotFoundException.class)
	public void getBalanceThowsWhenInvalidId() throws AccountNotFoundException {
		when(accountService.getBalance(anyLong())).thenThrow(AccountNotFoundException.class);
		assertThatThrownBy(() -> accountService.getBalance(1L)).isInstanceOf(AccountNotFoundException.class);
	}

	@Test
	public void depositTest() throws AccountNotFoundException {
		Deposit deposit = new Deposit(1L, 10L);
		assertThat(accountService.deposit(deposit).getBalance()).isEqualTo(20L);
	}

	@Test
	public void createAccountTest() throws CouldNotCreateAccountException {
		assertThat(accountService.createAccount(account)).isEqualTo(account);
	}

	@Test
	public void decreaseBalanceTest() throws AccountNotFoundException {
		assertThat(accountService.decreaseBalance(1L, 10L).getBalance()).isEqualTo(0L);
	}

	@Test
	public void authorisePaymentTest() throws AccountNotFoundException {
		assertThat(accountService.authorizePayment(1L, 10L).getAvailableBalance()).isEqualTo(0L);
	}

	@Test
	public void refundPaymentTest() throws AccountNotFoundException {
		assertThat(accountService.refund(1L, 10L).getAvailableBalance()).isEqualTo(20L);
	}

}
