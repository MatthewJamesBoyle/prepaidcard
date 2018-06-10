package boylem.matt.merchant.service;

import static org.assertj.core.api.Assertions.assertThat;

import javax.security.auth.login.AccountNotFoundException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import boylem.matt.merchant.dao.MerchantDao;
import boylem.matt.merchant.domain.Merchant;
import boylem.matt.merchant.exception.MerchantCreationException;

@RunWith(SpringRunner.class)
public class MerchantServiceImplTest {

	@TestConfiguration
	static class CardServiceImplTestContextConfiguration {

		@Bean
		public MerchantService merchantService() {
			return new MerchantServiceImpl();
		}
	}

	@Autowired
	private MerchantService merchantService;

	@MockBean
	MerchantDao merchantDao;

	@Test
	public void createMerchantTest() throws MerchantCreationException {
		Merchant merchant = new Merchant("Matts business", "123 fake street");
		assertThat(merchantService.create(merchant)).isEqualTo(merchant);
	}

}
