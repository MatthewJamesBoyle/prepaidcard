package boylem.matt.merchant.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import boylem.matt.merchant.domain.Merchant;

/**
 * JPA repository for Merchant
 * 
 * @author Matt Boyle
 *
 */
public interface MerchantDao extends JpaRepository<Merchant, Long> {
	/**
	 * find a merchant by a transaction Id
	 * 
	 * @param transactionId
	 * @return Merchant
	 */
	Merchant findById(Long transactionId);

}
