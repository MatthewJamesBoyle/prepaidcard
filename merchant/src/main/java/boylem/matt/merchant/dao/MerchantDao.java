package boylem.matt.merchant.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import boylem.matt.merchant.domain.Merchant;

public interface MerchantDao extends JpaRepository<Merchant, Long> {

	Merchant findById(Long transactionId);

}
