package boylem.matt.merchant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import boylem.matt.merchant.dao.MerchantDao;
import boylem.matt.merchant.domain.Merchant;
import boylem.matt.merchant.exception.MerchantCreationException;
import utils.ErrorType;

@Service
public class MerchantServiceImpl implements MerchantService {

	@Autowired
	MerchantDao merchantDao;

	public Merchant create(Merchant merchant) throws MerchantCreationException {
		if (merchant == null || merchant.getName() == null || merchant.getAddress() == null) {
			throw new MerchantCreationException();
		}

		merchantDao.save(merchant);

		return merchant;
	}

}
