package boylem.matt.merchant.service;

import org.springframework.http.ResponseEntity;

import boylem.matt.merchant.domain.Merchant;

public interface MerchantService {

	ResponseEntity<?> create(Merchant merchant);
}
