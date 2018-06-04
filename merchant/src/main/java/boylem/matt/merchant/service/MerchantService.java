package boylem.matt.merchant.service;

import org.springframework.http.ResponseEntity;

import boylem.matt.merchant.domain.Merchant;
import boylem.matt.merchant.exception.MerchantCreationException;

public interface MerchantService {

	Merchant create(Merchant merchant) throws MerchantCreationException;
}
