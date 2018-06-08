package boylem.matt.account.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import boylem.matt.account.domain.Account;

/**
 * JPA repository for Account.
 * 
 * @author Matt Boyle.
 *
 */
public interface AccountDao extends JpaRepository<Account, Long> {

	Account findById(Long accId);

}
