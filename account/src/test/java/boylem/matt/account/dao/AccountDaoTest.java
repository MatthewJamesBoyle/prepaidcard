package boylem.matt.account.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import boylem.matt.account.dao.AccountDao;
import boylem.matt.account.domain.Account;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountDaoTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private AccountDao accountDao;

	@Test
	public void whenFindById_thenReturnAccount() {
		Account account = new Account(1L, "Matt", "Boyle", 10L, 10L);
		entityManager.merge(account);
		entityManager.flush();

		Account found = accountDao.findById(1L);
		assertThat(found.getFirstName()).isEqualTo(account.getFirstName());

	}

}